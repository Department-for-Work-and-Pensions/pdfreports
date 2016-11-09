package gov.dwp.carers.pdfreports.service;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;

public class ParsePdf {
    class FontRenderFilter extends RenderFilter {
        public boolean allowText(TextRenderInfo renderInfo) {
            // Just get all text ... we could filder by font.contains("") etc.
            return true;
        }
    }

    public String getPdfText(byte[] pdfcontent) {
        String pdfText = "";
        try {
            PdfReader pdfReader = new PdfReader(pdfcontent);
            Rectangle rect = new Rectangle(36, 750, 559, 806);
            RenderFilter regionFilter = new RegionTextRenderFilter(rect);
            FontRenderFilter fontFilter = new FontRenderFilter();
            TextExtractionStrategy strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), regionFilter, fontFilter);
            pdfText = PdfTextExtractor.getTextFromPage(pdfReader, 1, strategy);
            pdfReader.close();
        } catch (Exception e) {
            // we just return nothing
        }
        return pdfText;
    }
}
