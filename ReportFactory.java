package com.bankonet.report;


public class ReportFactory {

	public static ReportGenerator createReport(String reportType) {

		if("HtmlReport".equals(reportType)){
			
			return new PdfReportGenerator();
			
			
		}else if("PdfReport".equals(reportType)){
			
			return new HtmlReportGenerator();
			
		}throw new IllegalArgumentException("type de rapport inconnu"+reportType);
		
	}

}
