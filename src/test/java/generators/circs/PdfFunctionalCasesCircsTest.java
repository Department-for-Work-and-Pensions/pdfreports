package generators.circs;

import controllers.PdfServiceApplication;
import generators.PdfGenerator;
import generators.PdfSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by peterwhitehead on 06/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringApplicationConfiguration(classes = PdfServiceApplication.class)   // 2
public class PdfFunctionalCasesCircsTest extends PdfSpecification {
    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    @Inject
    private PdfGenerator pdfGenerator;

    @Test
    public void circsFunctionalTest() throws Exception {
        File allFiles = new File(jrxmlLocation);
        List<File> list = Arrays.asList(allFiles.listFiles());
        list.parallelStream().filter(f -> f.isDirectory()).forEach(folder -> {
            try {
                for (int i = 1; i <= 9; i++) {
                    String pdfFileLocation = "functionalTestCase" + i + "_circs_testGeneratorResultIsSuccess.pdf";
                    String source = new String(Files.readAllBytes(Paths.get(getClass().getResource("/" + folder.getName() + "/circs/c3_functional" + i + "_circs.xml").toURI())));
                    testGeneratorResultIsSuccess(pdfFileLocation, source, pdfGenerator);
                }
            } catch (Exception e) { throw new RuntimeException(e); }
        });
    }
}
