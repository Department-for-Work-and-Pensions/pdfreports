package gov.dwp.carers.pdfrenderer.generators.circs;

import gov.dwp.carers.pdfrenderer.controllers.PdfServiceApplication;
import gov.dwp.carers.pdfrenderer.generators.HtmlGenerator;
import gov.dwp.carers.pdfrenderer.generators.HtmlSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;

/**
 * Created by peterwhitehead on 09/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class HtmlFunctionalCasesCircsTest extends HtmlSpecification {
    private static final Logger LOGGER = LoggerFactory.getLogger(HtmlFunctionalCasesCircsTest.class);

    @Inject
    private HtmlGenerator htmlGenerator;

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    @Test
    public void testChangeOfCircumstancesFunctionalCases() throws Exception {
        final File allFiles = new File(jrxmlLocation);
        Arrays.asList(allFiles.listFiles()).stream().filter(f -> f.isDirectory()).forEach(folder -> {
            try {
                for (int i = 1; i <= 13; i++) {
                    LOGGER.info("changeOfCircumstancesFunctionalCases for version =" + folder.getName() + " test case=" + i);
                    createAndGenerateCircsHtml(folder.getName(), i, htmlGenerator);
                }

                for (int i = 20; i <= 37; i++) {
                    LOGGER.info("changeOfCircumstancesFunctionalCases for version =" + folder.getName() + " test case=" + i);
                    createAndGenerateCircsHtml(folder.getName(), i, htmlGenerator);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}