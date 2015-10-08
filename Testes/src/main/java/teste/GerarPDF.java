package teste;

import java.io.FileOutputStream;
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

	public GerarPDF(String arquivo) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			document.open();
			addContent(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addContent(Document document) throws DocumentException {

		Anchor anchor = new Anchor("Código Barras Inválido", catFont);

		Paragraph subPara = new Paragraph(anchor);

		// add a table
		createTable(subPara);

		// now add all this to the document
		document.add(subPara);

	}

	private static void createTable(Paragraph subPara) throws BadElementException {
		PdfPTable table = new PdfPTable(2);

		PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Table Header 2"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		table.setHeaderRows(1);

		table.addCell("1.0");
		table.addCell("1.1");
		table.addCell("1.2");
		table.addCell("2.1");
		table.addCell("2.2");
		table.addCell("2.3");

		subPara.add(table);

	}
	public static void main(String[] args) {
		
		String arquivo = "d:\\pdf04.pdf";
		
		new GerarPDF(arquivo);
	}

}