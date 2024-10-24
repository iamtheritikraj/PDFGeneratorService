<h1>PDF Generator Service</h1>

<p>
    <strong>PDFGeneratorService</strong> is a Spring Boot application designed to generate PDF invoices that can be used via POSTMAN or Swagger UI.
    It allows you to submit invoice data via a REST API and generate a downloadable PDF invoice. 
    The generated PDFs are stored locally, and if the same data is provided again, the system retrieves the existing PDF instead of regenerating it.
</p>

<h2>How to Use</h2>

<h3>1. Download PDF</h3>
<p>
    <strong>GET:</strong> <code>api/pdf/download?fileName="example.pdf"</code><br>
    Use this endpoint to download an already generated PDF by providing the <code>fileName</code> parameter in the query string.
</p>

<h3>2. Generate PDF</h3>
<p>
    <strong>POST:</strong> <code>api/pdf/generate</code><br>
    Use this endpoint to generate a new PDF by providing the invoice data in the request body.
</p>

<h4>Sample Request Body</h4>
<pre>
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
</pre>

<h4>Required Header</h4>
<p><strong>Content-Type:</strong> <code>application/json</code></p>

<h2>Features</h2>
<ul>
    <li>REST API to accept invoice data and generate a PDF based on the received information.</li>
    <li>Ability to download the generated PDF by providing the file name.</li>
    <li>Stores the generated PDF in local storage and retrieves it when the same data is provided again to avoid regeneration.</li>
</ul>

<h2>Technology Stack</h2>
<ul>
    <li><strong>Java:</strong> Programming language used to build the application.</li>
    <li><strong>Spring Boot:</strong> Framework used to create the REST API service.</li>
    <li><strong>Thymeleaf:</strong> Template engine used to generate HTML content for the PDF.</li>
    <li><strong>iText:</strong> Library used to convert HTML content to a PDF document.</li>
</ul>

<h2>Endpoints</h2>
<table border="1" cellpadding="10">
    <thead>
        <tr>
            <th>Method</th>
            <th>URL</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>GET</td>
            <td><code>/api/pdf/download?fileName="example.pdf"</code></td>
            <td>Download the PDF by file name.</td>
        </tr>
        <tr>
            <td>POST</td>
            <td><code>/api/pdf/generate</code></td>
            <td>Generate a new PDF invoice by submitting invoice data.</td>
        </tr>
    </tbody>
</table>

<h2>Installation and Setup</h2>
<ol>
    <li>Clone the repository to your local machine.</li>
    <li>Open the project in your preferred IDE.</li>
    <li>Ensure you have Java 8+ and Maven installed.</li>
    <li>Run <code>mvn clean install</code> to build the project.</li>
    <li>Run the application using <code>mvn spring-boot:run</code>.</li>
</ol>


<h2>License</h2>
<p>This project is licensed under the MIT License.</p>
