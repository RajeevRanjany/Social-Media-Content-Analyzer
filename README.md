Social Media Content Analyzer

This project is a web-based application that extracts text from uploaded social media content available in PDF files and images (screenshots, scanned documents, etc.). The main goal is to analyze raw social media content and make it editable for further engagement improvement tasks.

The backend is built using Spring Boot and provides a REST API for text extraction. For PDF text extraction, the application uses Apache PDFBox to read and maintain formatting of documents. For images, it uses the Tesseract OCR engine via the Tess4J library to convert pictures into accurate text. The extracted text is then returned to the frontend where it can be viewed and copied by the user.

A minimal frontend is built using HTML, JavaScript, and Bootstrap, providing a user-friendly interface with loading indicators and error handling. The system also supports drag-and-drop or manual file upload via a file picker.

Tech Stack

Spring Boot (Backend REST API)

PDFBox (PDF Parsing)

Tesseract OCR + Tess4J (Image Text Extraction)

HTML + JavaScript + Bootstrap (Frontend UI)

Features

Upload PDF or Image

Extract readable text

Error handling & loading UX

Works fully offline (Free OCR)

