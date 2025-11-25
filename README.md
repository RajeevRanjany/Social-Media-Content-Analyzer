
# Social Media Content Analyzer

Live : https://meticulous-courage-production-6db5.up.railway.app

[Watch the video] : https://drive.google.com/file/d/1QHDxlmO4dHC9lXKFLC0gVCY-wSg4BXC3/view?usp=sharing



A Spring Boot application that extracts text from **PDFs and Images**, performs **OCR using Tesseract**, and provides **AI-generated engagement suggestions** (hashtags, captions, emojis, CTA) using **Google Gemini**.

## Approach

This project extracts text from both PDF and image files and then generates social media engagement suggestions using Google Gemini. For PDF files, the application uses Apache PDFBox to directly read and extract text content without converting pages into images. For images (JPG/PNG), Tesseract OCR is used to detect and extract textual content.

Once the text is obtained, it is passed to the Gemini API to generate captions, hashtags, keywords, and audience engagement ideas tailored for social media use cases. 

The backend is built using Spring Boot and exposes a REST API endpoint that accepts file uploads. The frontend, built using HTML, CSS and JavaScript, displays the extracted text along with AI-generated suggestions.

## Deployment Note

At present, PDF extraction works both locally and on cloud deployments. Image-based OCR works correctly on local machines (where Tesseract OCR is installed), but it is not yet enabled on the cloud version. This is because Tesseract requires OS-level installation in the server environment. The project will be containerized using Docker in the next update to ensure that Tesseract OCR runs reliably on cloud platforms as well.



---

##Features

| Feature | Description |
|--------|-------------|
|  **PDF Text Extraction** | Extracts text using Apache PDFBox |
|  **Image OCR** | Reads scanned text using Tesseract OCR |
|  **AI Suggestions** | Generates hashtags, emojis, captions & CTA |
|  **Drag & Drop Upload** | Simple UI with upload + loading state |
|  **Secure API Key** | Gemini key via environment variable |
| ⚠**Error Handling** | Basic validations & responses |

---

## Tech Stack

### **Backend**
- Java + Spring Boot
- PDFBox
- Tesseract (Tess4J)
- Gemini API (AI text generation)

### **Frontend**
- HTML5 + Bootstrap 5
- Vanilla JavaScript

---

## 📁 Project Structure

```
src/
└─ main/
├─ java/
│ └─ SocialMediaAnalyser/SocailMedia/
│ ├─ controller/UploadController.java
│ ├─ service/OCRService.java
│ └─ service/SuggestionService.java
└─ resources/
├─ static/index.html
└─ application.properties
```

## Setup & Installation

### ▶ 1. Install Tesseract (Mac)
```bash
brew install tesseract


ls /opt/homebrew/share/tessdata/

git clone https://github.com/RajeevRanjany/Social-Media-Content-Analyzer
cd SocialMediaAnalyser

GEMINI_API_KEY = {GEMINI_API_KEY}

Run the Applications 

```


Simple UI : 
<img width="1757" height="952" alt="Screenshot 2025-11-23 at 2 30 26 AM" src="https://github.com/user-attachments/assets/1c6d5bae-b2c1-44d9-bcf6-448a6cd12562" />

Extracting Text form Image (Image Analysis) :
<img width="1373" height="801" alt="Screenshot 2025-11-23 at 12 16 03 PM" src="https://github.com/user-attachments/assets/3a13859a-c630-4328-827d-e5fe0e559602" />


Extracting Text form PDF file : 
<img width="1350" height="797" alt="Screenshot 2025-11-23 at 12 15 38 PM" src="https://github.com/user-attachments/assets/5ab74bbe-8f35-47da-ad19-50ec3fa99be5" />


Future Enhancement:

Smart engagement suggestions powered fully by AI sentiment + tone analysis (Gemini / GPT).

MIT License © 2025
