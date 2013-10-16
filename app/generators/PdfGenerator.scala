package generators

import data_sources.ReportDataSource
import net.sf.jasperreports.engine.{JasperExportManager, JasperPrint, JasperFillManager}
import java.io.{File, OutputStream, FileOutputStream}
import play.api.Logger

/**
 * Generates a PDF from a DataSource.
 * It reads the compiled report template, generate a JasperPrint and returns a PDF (an array of bytes).
 *
 * @author Jorge Migueis
 */
case class PdfGenerator(source: ReportDataSource) extends ReportGenerator(source) {
  override protected def exportReportToFormat(print: JasperPrint): SuccessOrFailure = {
    PdfGenerator.exportReportToFormat(print)
  }
}

object PdfGenerator {
  val pdfFileLocation = "/Users/valtechuk/test.pdf"

  protected def exportReportToFormat(print: JasperPrint): SuccessOrFailure = {
    try {
      JasperExportManager.exportReportToPdfFile(print, pdfFileLocation)
      GenerationSuccess()
    } catch {
      case e: Exception => {
        Logger.error(e.getMessage)
        GenerationFailure()
      }
    }
  }
}
