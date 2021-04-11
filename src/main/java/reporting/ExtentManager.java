package reporting;

// Created by K.Batuhan Arslan

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    public static ExtentReports createInstance() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-results/extent.html");
        ExtentReports extent = new ExtentReports();

        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("test-results/extent.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("test-results/extent.html");
        extent.attachReporter(htmlReporter);

        return extent;
    }

}