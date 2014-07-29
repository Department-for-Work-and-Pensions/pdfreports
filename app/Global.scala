import java.net.InetAddress

import generators.ReportGenerator
import org.slf4j.MDC
import play.api.{Logger, Application, GlobalSettings}
import play.api.mvc._
import monitoring.RenderingServiceMonitorRegistration
import monitor.MonitorFilter
import monitor._
import app.ConfigProperties._

object Global extends WithFilters(MonitorFilter) with RenderingServiceMonitorRegistration with GlobalSettings with ReportGenerator {

  override def onStart(app: Application) {
    MDC.put("httpPort", getProperty("http.port", "Value not set"))
    MDC.put("hostName", Option(InetAddress.getLocalHost.getHostName).getOrElse("Value not set"))
    MDC.put("envName", getProperty("env.name", "Value not set"))
    MDC.put("appName", getProperty("app.name", "Value not set"))
    Logger.info("RS (RenderingService) is now starting.")
    super.onStart(app)

    registerReporters()

    // compile jasper reports if they are not already compiled
    Logger.info("Calling compile reports")
    compileAllReports()
    Logger.info("RS (RenderingService) started.")
  }

  override def onStop(app: Application) {
    super.onStop(app)
    Logger.info("RS (RenderingService) Stopped") // used for operations, do not remove
  }
}