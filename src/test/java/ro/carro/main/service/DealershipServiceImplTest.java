package ro.carro.main.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Equals;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.carro.main.dto.cars.AddCarRequest;
import ro.carro.main.dto.dealerships.CreateRequestDealership;
import ro.carro.main.dto.dealerships.ReadDealershipResponse;
import ro.carro.main.model.Brand;
import ro.carro.main.model.Car;
import ro.carro.main.repository.CarRepository;
import ro.carro.main.model.Dealership;
import ro.carro.main.repository.DealershipRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DealershipServiceImplTest {

    @InjectMocks
    private DealershipServiceImpl dealershipService;

    @Mock
    private DealershipRepository dealershipRepo;

    @Mock
    private CarRepository carRepo;

    @Test
    void testCreateDealership() {
        //arrange
        final var request = new CreateRequestDealership("bavaria motors", "city","address");
        final var dealership = new Dealership();
        dealership.setName(request.name());
        dealership.setCity(request.city());
        dealership.setAddress(request.address());


        when(dealershipRepo.insert(any())).thenReturn(dealership);

        //act
        final var result = dealershipService.addDealership(request);

        //assert
        assertEquals(dealership.getId(), result.dealershipId());

    }

/*
    @Test
    void testReadDealership() {
        //arrange
        final var request = new ReadDealershipResponse("bavaria motors", "city", null);
        final var dealership = new Dealership();
        dealership.setName(request.name());
        dealership.setCity(request.city());

        when(dealershipRepo.insert(any())).thenReturn(dealership);

        //act
        final var result = dealershipService.readDealership(request);

        //assert
        assertEquals(dealership.getId(), result.dealershipId());

    }
*/
}