package com.audax.AudaxTimeSheet.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.audax.AudaxTimeSheet.entities.Resource;
import com.audax.AudaxTimeSheet.repositories.ResourceRepo;
import com.audax.AudaxTimeSheet.services.PDFExportService;

@Controller
public class PDFExportController {
	@Autowired
	private ResourceRepo resourceRepo;

	@GetMapping(value = "/openpdf/resources", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> resourceReport() throws IOException {
		List<Resource> resources = resourceRepo.findAll();

		ByteArrayInputStream bis = PDFExportService.resourcePDFReport(resources);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=resources.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
}
