package generators

import org.specs2.mutable._
import data_sources.XmlDataSource
import test_data.{XMLData, ClaimBuilder}

import java.io.File
import com.itextpdf.text.pdf.parser.{PdfReaderContentParser, SimpleTextExtractionStrategy}


/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 * @author Jorge Migueis
 */
class PdfGeneratorSpec extends Specification with Before {
  override def before = {
    val pdfFile = new File(PdfGenerator.pdfFileLocation)
    if (pdfFile.exists()) {
      pdfFile.delete()
    }
  }

  "PdfGenerator" should {
    "PdfGenerator should be reject xml that does not contain DWPCAClaim or DWPCACircs" in {
      val xml = ClaimBuilder.buildBadClaim
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationFailure]
    }

    "PdfGenerator should be handle valid xml and return success" in {
      val xml = ClaimBuilder.buildGoodClaim
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }


    "PdfGenerator should create a PDF file" in {
      val xml = ClaimBuilder.buildGoodClaim
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue
    }


    "PdfGenerator should be handle functionalTestCase1 and return success" in {
      val xml = ClaimBuilder.functionalTestCase1
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    "PdfGenerator should create functionalTestCase1 PDF file" in {
      val xml = ClaimBuilder.functionalTestCase1
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "PdfGenerator should be handle functionalTestCase2 and return success" in {
      val xml = ClaimBuilder.functionalTestCase2
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    "PdfGenerator should create functionalTestCase2 PDF file" in {
      val xml = ClaimBuilder.functionalTestCase2
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "PdfGenerator should be handle functionalTestCase3 and return success" in {
      val xml = ClaimBuilder.functionalTestCase3
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    "PdfGenerator should create functionalTestCase3 PDF file" in {
      val xml = ClaimBuilder.functionalTestCase3
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "PdfGenerator should be handle functionalTestCase4 and return success" in {
      val xml = ClaimBuilder.functionalTestCase4
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    "PdfGenerator should create functionalTestCase4 PDF file" in {
      val xml = ClaimBuilder.functionalTestCase4
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "PdfGenerator should be handle functionalTestCase5 and return success" in {
      val xml = ClaimBuilder.functionalTestCase5
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    "PdfGenerator should create functionalTestCase5 PDF file" in {
      val xml = ClaimBuilder.functionalTestCase5
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "PdfGenerator should be handle functionalTestCase6 and return success" in {
      val xml = ClaimBuilder.functionalTestCase6
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    "PdfGenerator should create functionalTestCase6 PDF file" in {
      val xml = ClaimBuilder.functionalTestCase6
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "PdfGenerator should be handle functionalTestCase7 and return success" in {
      val xml = ClaimBuilder.functionalTestCase7
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    "PdfGenerator should create functionalTestCase7 PDF file" in {
      val xml = ClaimBuilder.functionalTestCase7
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "PdfGenerator should be handle functionalTestCase8 and return success" in {
      val xml = ClaimBuilder.functionalTestCase8
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    "PdfGenerator should create functionalTestCase8 PDF file" in {
      val xml = ClaimBuilder.functionalTestCase8
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "PdfGenerator should be handle functionalTestCase9 and return success" in {
      val xml = ClaimBuilder.functionalTestCase9
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    "PdfGenerator should create functionalTestCase9 PDF file" in {
      val xml = ClaimBuilder.functionalTestCase9
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue
    }


    "Extract PDF" in {
      val xmlTestCase9 = ClaimBuilder.functionalTestCase9
      val dataSource = new XmlDataSource(xmlTestCase9)
      PdfGenerator(dataSource).generateFrom()
      val pdfFile = new File(PdfGenerator.pdfFileLocation)
      pdfFile.exists() must beTrue

      val reader = new com.itextpdf.text.pdf.PdfReader(PdfGenerator.pdfFileLocation)
      val parser = new PdfReaderContentParser(reader)

      val content: Seq[String] = for (i <- 1 to reader.getNumberOfPages()) yield {
        val strategy = parser.processContent(i, new SimpleTextExtractionStrategy())

        strategy.getResultantText()
      }
      reader.close()

      val xmlData = XMLData.functionalTestCase9(xmlTestCase9)
      val totalContent = content.mkString("\n")
      println(totalContent)
      println("content.length: " + totalContent.length)

      val iterator = xmlData.iterator

      while (iterator.hasNext) {
        val seqData = iterator.next()
        totalContent.contains(seqData) must beTrue
      }
    }
  }
}

