public interface Taxation {
    double totalWithTax(double subtotal);
}

class TaxationImpl implements Taxation {
    @Override
    public double totalWithTax(double subtotal) {
        return subtotal + subtotal * 0.18;
    }
}
