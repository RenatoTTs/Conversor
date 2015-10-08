package lib;

import java.util.ArrayList;
import java.util.List;

public class ObjetoListaAtualizacao {
	List<Object[]> linha;
	
	public List<Object[]> getDescricao() {
		linha = new ArrayList<>();
		linha.add(new Object[]{ false, "Descrição" });
		linha.add(new Object[]{ false, "Preço de venda" });
		linha.add(new Object[]{ false, "Lista(Positiva,Negativa,Neutra)" });
		linha.add(new Object[]{ false, "Data da Última Compra" });
		linha.add(new Object[]{ false, "Tributação" });
		linha.add(new Object[]{ false, "Unidade de Medida" });
		linha.add(new Object[]{ false, "Preço de Custo" });
		linha.add(new Object[]{ false, "Margem de Lucro" });
		linha.add(new Object[]{ false, "Preço de Fábrica" });
		linha.add(new Object[]{ false, "Custo Médio" });
		linha.add(new Object[]{ false, "Fração" });
		linha.add(new Object[]{ false, "Quantidade" });
		linha.add(new Object[]{ false, "DCB" });
		linha.add(new Object[]{ false, "Nome Subistância" });
		linha.add(new Object[]{ false, "NCM" });
		linha.add(new Object[]{ false, "Mínimo" });
		linha.add(new Object[]{ false, "Demanda" });
		linha.add(new Object[]{ false, "Registro MS" });
		return linha;
	}

	public void setDescricao(Object[] descricao) {
		this.linha.add(descricao);
	}

	
	
	

}
