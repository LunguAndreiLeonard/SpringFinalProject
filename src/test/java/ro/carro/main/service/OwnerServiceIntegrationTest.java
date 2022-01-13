package ro.carro.main.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.carro.main.dto.dealerships.CreateRequestDealership;
import ro.carro.main.dto.owners.AddOwnerRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OwnerServiceIntegrationTest {


        @Autowired
        private OwnerService ownerService;

        @Test
        void testAddAndGetByName() {
            //arrange
            final var request = new AddOwnerRequest("George", "072727272");

            //act
            final var addResult = ownerService.addOwner(request);
            final var read = ownerService.readOwner(addResult.ownerId());


            // assert
            assertTrue(read.isPresent());
            assertEquals(read.get().name(), request.name());
            assertEquals(read.get().phone(), request.phone());

            //assertEquals(request, read.get());


        }
    }

