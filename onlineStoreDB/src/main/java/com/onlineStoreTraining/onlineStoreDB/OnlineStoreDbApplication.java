package com.onlineStoreTraining.onlineStoreDB;

import com.grapecity.documents.excel.*;
import com.grapecity.documents.excel.drawing.*;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.onlineStoreTraining.onlineStoreDB.client.Client;
import com.onlineStoreTraining.onlineStoreDB.client.ClientService;

@SpringBootApplication
public class OnlineStoreDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreDbApplication.class, args);	
	}
   
}
