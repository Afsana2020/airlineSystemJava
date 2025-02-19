public class PaymentPage {
    private double totalPrice;
    private boolean paymentCompleted = false;

    public PaymentPage(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPaymentCompleted() {
        return paymentCompleted;
    }

    public String processPayment(String cardNumber, String cvv, String pin, String promoCode, String payDate) {
        if (cardNumber.isEmpty() || cvv.isEmpty() || pin.isEmpty() || promoCode.isEmpty() || payDate.isEmpty()) {
            return "Please fill in all the fields before proceeding with payment.";
        }

        if (paymentCompleted) {
            return "Payment has already been completed. You cannot make another payment.";
        }

        double discount = promoCode.equals("NIK") ? totalPrice * 0.10 : 0;
        double finalPrice = totalPrice - discount;

        paymentCompleted = true;
        return "Payment completed successfully!\nFinal Amount: $" + finalPrice +
                " (Discount applied: " + (discount > 0 ? "10%" : "None") + ")";
    }
}
