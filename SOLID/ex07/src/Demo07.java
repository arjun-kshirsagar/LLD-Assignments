public class Demo07 {
    public static void main(String[] args) {
        // Basic printer can only print
        System.out.println("=== Basic Printer ===");
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print("Hello World");
        
        // Multi-function printer can do everything
        System.out.println("\n=== Multi-function Printer ===");
        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print("Document");
        mfp.scan("/scans/document1.pdf");
        mfp.fax("123-456-7890");
    }
}
