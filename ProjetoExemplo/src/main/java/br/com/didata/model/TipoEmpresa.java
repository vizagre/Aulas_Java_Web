package br.com.didata.model;

public enum TipoEmpresa {
	MEI("Microempreendedor Individual"), 
	ME("Microempresa"), 
	EPP("Empresa de Pequeno Porte"), 
	EIRELI("Empresa Individual de Responsabilidade Limitada");
	
	private String tipo;
	
	TipoEmpresa(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
