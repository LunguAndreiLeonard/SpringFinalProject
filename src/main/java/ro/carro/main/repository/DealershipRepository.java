package ro.carro.main.repository;

import ro.carro.main.model.Dealership;
import ro.carro.main.model.Payment;

import java.util.List;
import java.util.Optional;

public interface DealershipRepository {

    Dealership insert(Dealership dealership);
    void delete(String dealershipId);
    boolean exists(String dealershipId);
    List<Dealership> findByOwnerId(String ownerId);

    Optional<Dealership> read(String dealershipId);
}
