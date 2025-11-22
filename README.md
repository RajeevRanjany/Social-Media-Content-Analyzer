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

Simple UI : 
<img width="1757" height="952" alt="Screenshot 2025-11-23 at 2 30 26 AM" src="https://github.com/user-attachments/assets/1c6d5bae-b2c1-44d9-bcf6-448a6cd12562" />

Extracting Text form Image (Image Analysis) :
<img width="1663" height="796" alt="Screenshot 2025-11-23 at 2 33 13 AM" src="https://github.com/user-attachments/assets/aff9b011-cda3-453d-b889-00721540fa4c" />


Extracting Text form PDF file : 
<img width="1504" height="975" alt="Screenshot 2025-11-23 at 2 33 55 AM" src="https://github.com/user-attachments/assets/c1945324-c11b-4175-8307-b07b342ee7a8" />



Future Enhancement:
The application can be extended to generate smarter engagement suggestions using AI models such as Gemini or GPT. These models can analyze tone, sentiment, topic relevance and audience targeting to recommend context-aware improvements like optimized hashtags, captions, and call-to-actions. This would move beyond rule-based checks and provide personalized content strategy guidance.
