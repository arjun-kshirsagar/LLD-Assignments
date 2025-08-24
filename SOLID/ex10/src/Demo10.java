public class Demo10 {
    public static void main(String[] args) {
        // Using ConsoleLogger
        Logger consoleLogger = new ConsoleLogger();
        ReportService consoleReportService = new ReportService(consoleLogger);
        consoleReportService.generate();
        
        // Using FileLogger (could be implemented similarly)
        Logger fileLogger = new FileLogger("app.log");
        ReportService fileReportService = new ReportService(fileLogger);
        fileReportService.generate();
    }
}
