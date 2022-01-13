package ro.carro.main.repository;

import ro.carro.main.model.Owner;

import java.util.Optional;

public interface OwnerRepository {

    Owner insert(Owner owner);

    boolean exists(String ownerId);

    Optional<Owner> read(String ownerId);
}
