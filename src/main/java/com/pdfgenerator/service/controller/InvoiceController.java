package com.pdfgenerator.service.controller;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import com.pdfgenerator.service.model.InvoiceRequest;
import com.pdfgenerator.service.service.PdfService;


@RestController
@RequestMapping("/api/pdf")
public class InvoiceController {

    @Autowired
    private PdfService pdfService;  

    @PostMapping("/generate")
    public ResponseEntity<?> generatePdf(@RequestBody InvoiceRequest invoiceRequest) {

        String pdfPath = pdfService.generatePdf(invoiceRequest);
        return ResponseEntity.ok("PDF generated at path: " + pdfPath);
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadPdf(@RequestParam String fileName) {
    	System.out.println(fileName);
    	
        File file = new File("pdf-storage/" + fileName);
        
        System.out.println(file);
        
        if (!file.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Resource resource = new FileSystemResource(file);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }
}


