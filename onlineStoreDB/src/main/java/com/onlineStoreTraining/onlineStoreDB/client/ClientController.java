package com.onlineStoreTraining.onlineStoreDB.client;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineStoreTraining.onlineStoreDB.orders.Orders;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ClientController {
	
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/clients")
	public List <Client> getAllClients(){ 
	return clientService.getAllClients();
	}	
	@RequestMapping("/clients/forexcel")
	public List <Client> getAllClientsForExcel(){ 
	return clientService.getAllClientsForExcel();
	}	
	
	@RequestMapping("/clients/{id}")
	public Client getClient(@PathVariable Integer id)	{
		
		return clientService.getClient(id);
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/clients")
	public void addClient(@RequestBody Client client ) {
		clientService.addClient(client);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/clients/{id}")
	public void updateClient(@RequestBody Client client,@PathVariable Integer id) {
		clientService.updateClient(id,client);	
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/clients/{id}")
	public void deleteClient(@PathVariable Integer id) {
		clientService.deleteClient(id);
	}
	
	@RequestMapping("/client/orderReport/{id}")
	public List<Orders> getOrdersReportforClientId(@PathVariable Integer id){
		return clientService.getAllOrdersOfClientForExcel(id);
	}
	
	
	
	@RequestMapping(value="/clients/info/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
	 public ResponseEntity<InputStreamResource> getClientInfo(@PathVariable Integer id) throws FileNotFoundException {

        

        ByteArrayInputStream bis = clientService.writingInPDF(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
	

}
