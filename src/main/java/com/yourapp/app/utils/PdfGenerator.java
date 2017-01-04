package com.yourapp.app.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PdfGenerator {
	
	public static void generateDocument() throws IOException, DocumentException{
		PdfReader pdfReader = new PdfReader("template.pdf");
		FileOutputStream fileOutputStream = new FileOutputStream("doc.pdf");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfStamper stampler = new PdfStamper(pdfReader, fileOutputStream);
		stampler.setFormFlattening(true);
		
	}
}
