package com.bankonet.report;

public class PdfReportGenerator extends ReportGenerator implements IReportGenerator {

	private String auteur;


	public void generate() {
		System.out.println("auteur du rapport PDF = ");

	}


	public void generate(String a) {

		this.auteur = a;
		System.out.println("auteur du rapport PDF = " + getAuteur());

	}


	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
