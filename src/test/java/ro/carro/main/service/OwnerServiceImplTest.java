package ro.carro.main.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.carro.main.dto.cars.AddCarRequest;
import ro.carro.main.dto.dealerships.CreateRequestDealership;
import ro.carro.main.dto.owners.AddOwnerRequest;
import ro.carro.main.dto.owners.OwnerCollection;
import ro.carro.main.model.Brand;
import ro.carro.main.model.Car;
import ro.carro.main.model.Dealership;
import ro.carro.main.model.Owner;
import ro.carro.main.repository.CarRepository;
import ro.carro.main.repository.DealershipRepository;
import ro.carro.main.repository.OwnerRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceImplTest {


        @InjectMocks
        private OwnerServiceImpl ownerService;

        @Mock
        private OwnerRepository ownerRepo;

        @Mock
        private CarRepository carRepo;

        @Test
        void testCreateOwner() {
            //arrange
            final var request = new AddOwnerRequest("george", "072727272727");
            final var owner = new Owner();
            owner.setName(request.name());
            owner.setPhone(request.phone());


            when(ownerRepo.insert(any())).thenReturn(owner);

            //act
            final var result = ownerService.addOwner(request);

            //assert
            assertEquals(owner.getId(), result.ownerId());

        }


}
