# Social Media Content Analyzer

A Spring Boot application that extracts text from **PDFs and Images**, performs **OCR using Tesseract**, and provides **AI-generated engagement suggestions** (hashtags, captions, emojis, CTA) using **Google Gemini**.

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
![Screenshot 2025-11-23 at 12.03.34 PM.png](../../../../var/folders/kh/bk7tfj9935vfg_p4223r8rgc0000gn/T/TemporaryItems/NSIRD_screencaptureui_7EvdyD/Screenshot%202025-11-23%20at%2012.03.34%E2%80%AFPM.png)

Extracting Text form PDF file : 
![Screenshot 2025-11-23 at 12.04.44 PM.png](../../../../var/folders/kh/bk7tfj9935vfg_p4223r8rgc0000gn/T/TemporaryItems/NSIRD_screencaptureui_zQ45Vc/Screenshot%202025-11-23%20at%2012.04.44%E2%80%AFPM.png)

Future Enhancement:

Smart engagement suggestions powered fully by AI sentiment + tone analysis (Gemini / GPT).

MIT License © 2025
