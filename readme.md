PDFGeneratorService: Spring Boot Application designed to generate PDF Invoice, which can be used by POSTMAN/SWAGGER

How to use?

1. GET: api/pdf/download?fileName="example.pdf"
2. POST: api/pdf/generate
   Body: 
   {
   "seller": "XYZ Pvt. Ltd.",
   "sellerGstin": "29AABBCCDD121ZD",
   "sellerAddress": "New Delhi, India",
   "buyer": "Vedant Computers",
   "buyerGstin": "29AABBCCDD131ZD",
   "buyerAddress": "New Delhi, India",
   "items": [
   {
   "name": "Product 1",
   "quantity": "12 Nos",
   "rate": 123.00,
   "amount": 1476.00
   }
   ]
   }
Header:
Content-Type=Application/JSON

About:
● REST API to accept data and generate a PDF based on the received data.
● Ability to download the above-generated PDF
● Stored the generated PDF in the local storage and redownload it when the same data is provided instead of generating it again.

Technology Used:
Java SpringBoot to create REST API service.
Used Java Template Engines like Thymeleaf and iText to generate the PDF and store it on the local storage which can be retrieved later.