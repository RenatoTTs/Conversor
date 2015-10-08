package lib;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GerarPDF {
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);


	public void criarPdf(String arquivo, List<CodigosIvalidos> lista) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(arquivo+"\\CodigosInvalido"+LocalDate.now()+".pdf"));
			document.open();
			addContent(document,lista);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addContent(Document document, List<CodigosIvalidos> lista) throws DocumentException {

		Anchor anchor = new Anchor("Código Barras Inválido", catFont);

		Paragraph subPara = new Paragraph(anchor);

		// add a table
		createTable(subPara, lista);

		// now add all this to the document
		document.add(subPara);

	}

	private static void createTable(Paragraph subPara, List<CodigosIvalidos> lista) throws BadElementException {
		PdfPTable table = new PdfPTable(2);

		PdfPCell c1 = new PdfPCell(new Phrase("Codigo Barra"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Descrição"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		
		table.setHeaderRows(1);
		
		for (CodigosIvalidos codigosIvalidos : lista) {
			table.addCell(codigosIvalidos.getCodigos());
			table.addCell(codigosIvalidos.getDescricao());
		}

		subPara.add(table);

	}

}