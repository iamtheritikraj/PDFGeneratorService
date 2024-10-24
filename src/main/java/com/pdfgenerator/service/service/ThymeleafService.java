package com.pdfgenerator.service.service;

import com.pdfgenerator.service.model.InvoiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
public class ThymeleafService {

    @Autowired
    private SpringTemplateEngine templateEngine;

    public String processTemplate(InvoiceRequest invoiceRequest) {
        Context context = new Context();
        context.setVariable("invoice", invoiceRequest);
        return templateEngine.process("invoice-template", context);
    }
}
