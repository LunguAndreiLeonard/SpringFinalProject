
package ro.carro.main.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.carro.main.dto.cars.AddCarRequest;
import ro.carro.main.dto.dealerships.CreateRequestDealership;
import ro.carro.main.model.Brand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DealershipServiceImplIntegrationTest {

  @Autowired
private DealershipService dealershipService;

  @Test
void testAddAndGetByName() {
  //arrange
      final var request = new CreateRequestDealership("bavaria motors", "city", "address");

      //act
      final var addResult = dealershipService.addDealership(request);
      final var read = dealershipService.readDealership(addResult.dealershipId());

      //assert
      assertTrue(read.isPresent());
      assertEquals(read.get().name(), request.name());
      assertEquals(read.get().city(), request.city());



  }
}