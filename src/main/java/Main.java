import notepad.Notepad;
import payment.Payment;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Notepad.run();

        Payment payment = new Payment();

        payment.addProduct("product1", 1.2);
        payment.addProduct("product2", 1.2);
        payment.addProduct("product3", 4);

        payment.showProducts();
    }
}
