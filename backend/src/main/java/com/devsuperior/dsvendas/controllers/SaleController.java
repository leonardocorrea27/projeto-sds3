package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.dto.SalesuccessDTO;
import com.devsuperior.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
   private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> FindAll(Pageable pageable) {	
		Page<SaleDTO> list = service.FindAll(pageable);
	  return ResponseEntity.ok(list);	  			  
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {	
	List<SaleSumDTO> list = service.AmountGroupedBySeller();
	 return ResponseEntity.ok(list);	
}
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SalesuccessDTO>> successGroupedBySeller() {	
	List<SalesuccessDTO> list = service.successGroupedBySeller();
	 return ResponseEntity.ok(list);	
	}
}