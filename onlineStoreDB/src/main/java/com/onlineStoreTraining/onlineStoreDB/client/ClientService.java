package com.onlineStoreTraining.onlineStoreDB.client;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import com.onlineStoreTraining.onlineStoreDB.orders.Orders;
import com.onlineStoreTraining.onlineStoreDB.orders.OrdersService;
import com.onlineStoreTraining.onlineStoreDB.orders.OrdersController;
import com.onlineStoreTraining.onlineStoreDB.orders.OrdersRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grapecity.documents.excel.ITable;
import com.grapecity.documents.excel.IWorksheet;
import com.grapecity.documents.excel.SaveFileFormat;
import com.grapecity.documents.excel.Workbook;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.onlineStoreTraining.onlineStoreDB.orders.Orders;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OrdersRepository ordersRepository;
	
		
	public List <Client> getAllClients(){
		List<Client> clients= new ArrayList<>();
		 clientRepository.findAll()
				.forEach(clients::add);
		 return clients;
	}
	public Client getClient(Integer id) {
		
		return clientRepository.findById(id).get();
	}
	public void addClient(Client client) {

		clientRepository.save(client);
	}
	public void updateClient(Integer id, Client client) {
		clientRepository.save(client);

	}
	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);

	}
	public List <Client> getAllClientsForExcel(){
		List<Client> clients= new ArrayList<>();
		 clientRepository.findAll()
				.forEach(clients::add);
		 
		 Workbook workbook = new Workbook();
		 IWorksheet worksheet = workbook.getWorksheets().get(0);
		 
		 Object[][] array = clients.stream()
			        .map(p -> new Object[] {p.getClient_id(), p.getFirst_name(), p.getLast_name(),p.getSex()})
			        .toArray(Object[][]::new);
		 String range="B10:F"+(10+array.length);
		 
		 worksheet.getRange(range).setValue(array);
		 workbook.save("SimpleBudget.xlsx");
		 		 				 
		 return clients;
	}
	public List <Orders> getAllOrdersOfClientForExcel(int id){
		List<Orders> list1=new ArrayList<>();
    	ordersRepository.findByTheclient(id)
		.forEach(list1::add);
		 
		 Workbook workbook = new Workbook();
		 IWorksheet worksheet = workbook.getWorksheets().get(0);
		 
		 Object[][] array = list1.stream()
			        .map(p -> new Object[] {p.getId(), p.getProduct(), p.getVolume(),p.getEmission(),p.getTheclient()})
			        .toArray(Object[][]::new);
		 String range="B10:F"+(10+array.length);
		 
		 worksheet.getRange(range).setValue(array);
		 
		
		 worksheet.getRange("B9").setValue("ID");
		 worksheet.getRange("C9").setValue("PRODUCT");
		 worksheet.getRange("D9").setValue("VOLUME");
		 worksheet.getRange("E9").setValue("EMISSION");
		 worksheet.getRange("F9").setValue("CLIENT");
		 worksheet.getRange("H9").setValue("TOTAL VOLUME");
		 
		 String newRange="B9:F"+(10+array.length);
		 
		 ITable ordersTable = worksheet.getTables().add(worksheet.getRange(newRange), true);
		 ordersTable.setName("tblOrders");
		 ordersTable.setTableStyle(workbook.getTableStyles().get("TableStyleMedium4"));
		 
		 worksheet.getNames().add("TotalVolume", "=SUM(tblOrders[VOLUME])");
		 worksheet.getRange("H10").setFormula("=TotalVolume");
		 
		 worksheet.save("dest.pdf", SaveFileFormat.Pdf);
		 workbook.save("SimpleOrderReport.xlsx");
		 
		 		 				 
		 return list1;
	}
	
	
	
	 public  ByteArrayInputStream writingInPDF(int id) throws FileNotFoundException {
        
		ByteArrayOutputStream out = new ByteArrayOutputStream();
    	Client ion=clientRepository.findById(id).get();
    	String paraText= ion.toString();
    	Paragraph paragraph1= new Paragraph(paraText);
    	
    	List<Orders> list1=new ArrayList<>();
    	ordersRepository.findByTheclient(id)
		.forEach(list1::add);
    	String paraText2= list1.toString();
    	Paragraph paragraph2= new Paragraph(paraText2);
    	String path="e://FirstPDF.pdf";
    	
    	PdfWriter pdfWriter=new PdfWriter(path);
    	PdfDocument pdfDocument= new PdfDocument(pdfWriter);
    	pdfDocument.addNewPage();
    	
    	Document document=new Document(pdfDocument);
    	
    	document.add(paragraph1);
    	document.add( paragraph2);
    	document.close();
    	Document document2=new Document(new PdfDocument(new PdfWriter(out)));
    	document2.add(paragraph1);
    	document2.add( paragraph2);
    	document2.close();
    	
    	return new ByteArrayInputStream(out.toByteArray());
    	
    }
}
