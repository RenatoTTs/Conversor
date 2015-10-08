package Importacao.softpharma;

import java.util.ArrayList;
import java.util.List;

public class ObjetoExportacao {
	
	String nome="";
	String matricula;
	List<String> titulos = new ArrayList<String>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public List<String> getTitulos() {
		return titulos;
	}
	public void setTitulos(List<String> titulos) {
		this.titulos = titulos;
	}
	
	

	
}
