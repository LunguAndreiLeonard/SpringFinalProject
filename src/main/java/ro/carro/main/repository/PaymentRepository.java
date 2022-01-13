package ro.carro.main.repository;

import ro.carro.main.model.Payment;

import java.util.List;

public interface PaymentRepository {

    Payment insert(Payment payment);
    void delete(String paymentId);
    List<Payment> findByOwnerId(String ownerId);
}
