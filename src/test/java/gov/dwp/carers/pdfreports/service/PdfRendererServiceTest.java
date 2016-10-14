package gov.dwp.carers.pdfreports.service;


import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import gov.dwp.carers.pdfrenderer.controllers.PdfServiceApplication;
import gov.dwp.carers.pdfrenderer.service.PdfRendererService;
import gov.dwp.carers.pdfreports.testdata.ClaimBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by peterwhitehead on 11/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class PdfRendererServiceTest {
    ParsePdf parsePdf=new ParsePdf();

    class FontRenderFilter extends RenderFilter {
        public boolean allowText(TextRenderInfo renderInfo) {
            String font = renderInfo.getFont().getPostscriptFontName();
            return true;
        }
    }

    @Inject
    private PdfRendererService pdfRendererService;

    @Test
    public void acceptValidXMLAndGenerateAPDF() throws Exception {
//        byte[] status = pdfRendererService.generatePdf(ClaimBuilder.goodClaim());
//        String pdftext=parsePdf.getPdfText(status);
//        assertThat((pdftext).contains("NINO"), is(true));
    }
}