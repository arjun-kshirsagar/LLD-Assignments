public class MultiFunctionPrinter implements Printer, Scanner, FaxMachine {
    @Override
    public void print(String text) {
        System.out.println("Printing: " + text);
    }

    @Override
    public void scan(String dstPath) {
        System.out.println("Scanning to: " + dstPath);
    }

    @Override
    public void fax(String number) {
        System.out.println("Sending fax to: " + number);
    }
}
