package com.bankonet.report;

public class HtmlReportGenerator extends ReportGenerator implements IReportGenerator {

	private String auteur;


	public void generate() {
		
		System.out.println("création du rapport html");
		
	}
	
	public void generate(String a) {
		this.auteur = a;
		System.out.println("auteur du rapport html = " + getAuteur());
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
