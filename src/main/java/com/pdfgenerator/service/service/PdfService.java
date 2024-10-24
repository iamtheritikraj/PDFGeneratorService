package com.pdfgenerator.service.service;

import com.pdfgenerator.service.model.InvoiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Service
public class PdfService {

    @Autowired
    private ThymeleafService thymeleafService; 

    public String generatePdf(InvoiceRequest invoiceRequest) {
    	
        String pdfPath = "pdf-storage/invoice-" + invoiceRequest.getSeller() + ".pdf";

        
        File directory = new File("pdf-storage");
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Created directory: {pdf-storage}");
            } else {
            	System.out.println("Could not create directory: {pdf-storage}");
            }
        }
        File file = new File(pdfPath);
        if (file.exists()) {
            return pdfPath; 
        }

        String htmlContent = thymeleafService.processTemplate(invoiceRequest);
        if (htmlContent == null || htmlContent.isEmpty()) {
            System.out.println("Generated HTML content is null or empty");
            return null; 
        }


        try (OutputStream os = new FileOutputStream(file)) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(os);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pdfPath; 
    }
}
