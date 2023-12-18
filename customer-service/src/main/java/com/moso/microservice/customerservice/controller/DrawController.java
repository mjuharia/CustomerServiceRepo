package com.moso.microservice.customerservice.controller;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.moso.microservice.customerservice.enity.Customer;
import com.moso.microservice.customerservice.enity.CustomerContact;
import com.moso.microservice.customerservice.enity.DrawDocs;
import com.moso.microservice.customerservice.enity.Error;
import com.moso.microservice.customerservice.enity.DrawRequest;
import com.moso.microservice.customerservice.enity.DrawResponse;
import com.moso.microservice.customerservice.enity.FundingSource;
import com.moso.microservice.customerservice.enity.FundingSourceAuditLog;
import com.moso.microservice.customerservice.exceptions.CustomerNotFoundException;
import com.moso.microservice.customerservice.jpa.DrawDocsRepository;
import com.moso.microservice.customerservice.jpa.DrawRequestRepository;
import com.moso.microservice.customerservice.jpa.DrawResponseRepository;
import com.moso.microservice.customerservice.jpa.ErrorRepository;
import com.moso.microservice.customerservice.jpa.FundingSourceAuditLogRepository;
import com.moso.microservice.customerservice.jpa.FundingSourceRepository;
import com.moso.microservice.customerservice.jpa.ServicingDrawDocumentRepository;

import jakarta.validation.Valid;



@RestController
public class DrawController {
	
	@Autowired
	DrawRequestRepository lDrawReqRepo;
	
	@Autowired
	DrawResponseRepository lDrawResponseRepo;
	
	@Autowired
	FundingSourceRepository lFundingSourceRepo;
	
	@Autowired
	FundingSourceAuditLogRepository lFundingSourceALRepo;
	
	@Autowired
	ErrorRepository lErrorRepo;
	
	@Autowired
	DrawDocsRepository lDrawDocRepo;
	
	@Autowired
	ServicingDrawDocumentRepository lServicingDocRepo;
	
	@GetMapping("/draws-notfiltered/{id}")
	public EntityModel<DrawRequest> getDrawByID(@PathVariable int id){
		DrawRequest lDraw = this.getDrawRequestByID(id);
		
		EntityModel<DrawRequest> lEntDraw = EntityModel.of(lDraw);
		
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllDraws());
		lEntDraw.add(link.withRel("all-draws"));
		
		return lEntDraw;
	}
	
	@GetMapping("/draws/{id}")
	public MappingJacksonValue fetchDrawFiltered(@PathVariable int id){
		
		DrawRequest lDraw = this.getDrawRequestByID(id);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("dtDrawID", "dtDrawFundingID");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DrawFilter", filter );
		
		MappingJacksonValue mapJackVal = new MappingJacksonValue(lDraw);
		mapJackVal.setFilters(filters);
		/*
		EntityModel<MappingJacksonValue> lEntDraw = EntityModel.of(mapJackVal);
		
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllDraws());
		lEntUsr.add(link.withRel("all-draws"));
		*/
		return mapJackVal;
	}
	
	
	@PostMapping("/draw")
	public ResponseEntity<DrawRequest> createDrawRequest(@Valid @RequestBody DrawRequest drawReq){
		
		DrawRequest lDrawReq = lDrawReqRepo.save(drawReq);
		
		List<FundingSource> f_src_lst = setBuiltDrawID(drawReq.getFundingSources(), lDrawReq);
		f_src_lst = lFundingSourceRepo.saveAll(f_src_lst);
		List<FundingSourceAuditLog> lAuditLst = getFundingSourceAuditLog(f_src_lst);
		lAuditLst = lFundingSourceALRepo.saveAll (lAuditLst);
			
	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(lDrawReq.getBuiltDrawId())
				.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping("/draw")
	public ResponseEntity<DrawRequest> updateDrawRequest(@Valid @RequestBody DrawRequest drawReq){
				
		List<FundingSource> lFundSrcLst = lFundingSourceRepo.saveAll(setBuiltDrawID(drawReq.getFundingSources(),drawReq));
		List<FundingSourceAuditLog> lAuditLst = getFundingSourceAuditLog(lFundSrcLst);
		lFundingSourceALRepo.saveAll(lAuditLst);
		DrawRequest lDrawReq = lDrawReqRepo.save(drawReq);
	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(lDrawReq.getBuiltDrawId())
				.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PatchMapping("/draw")
	public ResponseEntity<DrawRequest> modifyDrawRequest(@Valid @RequestBody DrawRequest drawReq){
		
		List<FundingSource> lFundSrcLst = lFundingSourceRepo.saveAll(setBuiltDrawID(drawReq.getFundingSources(),drawReq));
		List<FundingSourceAuditLog> lAuditLst = getFundingSourceAuditLog(lFundSrcLst);
		lFundingSourceALRepo.saveAll(lAuditLst);
		DrawRequest lDrawReq = lDrawReqRepo.save(drawReq);
		
	
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(lDrawReq.getBuiltDrawId())
				.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	
	/******************          DRAW RESPONSE SECTION  ********************/
	
	@GetMapping("/drawresponses/{id}")
	public MappingJacksonValue fetchDrawResponsesFiltered(@PathVariable int id){
		DrawResponse lDrawResp = getDrawResponseByID(id);
		DrawRequest lDrawReq = getDrawRequestByID(lDrawResp.getBuiltDrawID());
		lDrawResp.setlFundingSource(lDrawReq.getFundingSources());
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("fundingAmount", "capiAmount");
		if (lDrawResp.getSuccess()) {
			filter = SimpleBeanPropertyFilter.serializeAllExcept("fundingAmount", "capiAmount", "errorList");
		}
		else {
			filter = SimpleBeanPropertyFilter.serializeAllExcept("fundingAmount", "capiAmount", "id", "fundingSources");
		}
		FilterProvider filters = new SimpleFilterProvider().addFilter("DrawFilter", filter );
		
		MappingJacksonValue mapJackVal = new MappingJacksonValue(lDrawResp);
		mapJackVal.setFilters(filters);
		/*
		EntityModel<MappingJacksonValue> lEntDraw = EntityModel.of(mapJackVal);
		
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllDraws());
		lEntUsr.add(link.withRel("all-draws"));
		*/
		return mapJackVal;
	}
	
	@PostMapping("/drawresponse")
	public ResponseEntity<DrawResponse> createDrawResponse(@Valid @RequestBody DrawResponse drawResp){
		
		
		DrawRequest lDrawReq = getDrawRequestByID(drawResp.getBuiltDrawID());
		
		
		DrawResponse lDrawResp = lDrawResponseRepo.save(drawResp);
		if (lDrawResp.getSuccess()) {
			
			List<FundingSource> lFundSrcLst = lFundingSourceRepo.saveAll(adjustBalances(lDrawReq));
			List<FundingSourceAuditLog> lAuditLst = getFundingSourceAuditLog(lFundSrcLst);
			lFundingSourceALRepo.saveAll(lAuditLst);
			
		}
		else {
			for (Error err : lDrawResp.getErrorList()) {
				err.setiResponse(lDrawResp);
				lErrorRepo.save(err);
			}
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(lDrawResp.getBuiltDrawID())
				.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	private List<FundingSource> adjustBalances(DrawRequest aDrawReq){
		List<FundingSource> fsrcLst = new ArrayList<FundingSource>();
		for (FundingSource f_source : aDrawReq.getFundingSources()) {
			f_source.setOutstandingPplBal(f_source.getOutstandingPplBal().add(f_source.getFundingAmount()));
			f_source.setAmountNotBorrowed(f_source.getAmountNotBorrowed().subtract(f_source.getFundingAmount()));
			fsrcLst.add(f_source);
			
		}
		return fsrcLst;
	}
	
	private DrawResponse getDrawResponseByID(int builtDrawID) {
		Optional<DrawResponse> lOptDrawResp = lDrawResponseRepo.findById(builtDrawID);
		
		if (lOptDrawResp.isEmpty()) {
			throw new CustomerNotFoundException("Built Draw Id = " + builtDrawID + " NOT FOUND!");
		}
		return lOptDrawResp.get();
		
		
	}
	
	private DrawRequest getDrawRequestByID(int builtDrawID) {
		Optional<DrawRequest> lOptDrawReq = lDrawReqRepo.findById(builtDrawID);
		if (lOptDrawReq.isEmpty()) {
			throw new CustomerNotFoundException("Built Draw Id = " + builtDrawID + " NOT FOUND!");
		}
		return lOptDrawReq.get();
		
		
	}
	
	private List<FundingSource> setBuiltDrawID(List<FundingSource> lSourceLst, DrawRequest drawReq){
		List<FundingSource> fsrcLst = new ArrayList<FundingSource>();
		for (FundingSource f_source : lSourceLst) {
			f_source.setiDraw(drawReq);
			fsrcLst.add(f_source);
			
		}
		return fsrcLst;
	}
	
	private List<FundingSourceAuditLog> getFundingSourceAuditLog(List<FundingSource> lSourceLst) {
		
		List<FundingSourceAuditLog> sourceAuditLogLst = new ArrayList<FundingSourceAuditLog>();
		
		for (FundingSource f_source : lSourceLst) {
			sourceAuditLogLst.add(new FundingSourceAuditLog(f_source));
		}
		
		return sourceAuditLogLst;
	}
	
	
	
	
	@GetMapping("/drawdocs-filtered/{id}")
	public MappingJacksonValue fetchDrawDocFiltered(@PathVariable int id){
		Optional<DrawDocs> lOptDrawDocResp = lDrawDocRepo.findById(id);
				
		if (lOptDrawDocResp.isEmpty()) {
			throw new CustomerNotFoundException("Built Draw Id = " + id + " NOT FOUND!");
		}
		DrawDocs lDrawResp = lOptDrawDocResp.get();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("id");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("DrawFilter", filter );
		
		MappingJacksonValue mapJackVal = new MappingJacksonValue(lDrawResp);
		mapJackVal.setFilters(filters);
		/*
		EntityModel<MappingJacksonValue> lEntDraw = EntityModel.of(mapJackVal);
		
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllDraws());
		lEntUsr.add(link.withRel("all-draws"));
		*/
		return mapJackVal;
	}
	
	@GetMapping("/draws")
	public List<DrawRequest> getAllDraws(){
		return lDrawReqRepo.findAll();
	}
	
}
