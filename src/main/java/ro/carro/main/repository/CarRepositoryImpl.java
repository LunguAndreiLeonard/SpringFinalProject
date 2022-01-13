package ro.carro.main.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.carro.main.model.Brand;
import ro.carro.main.model.Car;

import java.util.List;
import java.util.UUID;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final JdbcTemplate jdbcTemplate;

    public CarRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Car insert(Car car) {
        car.setId(UUID.randomUUID().toString());

        jdbcTemplate.update("insert into cars values (?, ?, ?, ?, ?, ?)",
                car.getId(), car.getName(), car.getBrand().toString(), car.getPlate(), car.getDealershipId(), car.getOwnerId());

        return car;
    }

    @Override
    public void delete(String carId) {
        jdbcTemplate.update("delete from cars where id = ?", carId);

    }

    @Override
    public List<Car> findByDealershipId(String dealershipId) {
        return jdbcTemplate.query("select * from cars where dealership_id = ?", (rs, rowNo) -> {
            final var mapped = new Car();
            mapped.setId(rs.getString("id"));
            mapped.setName(rs.getString("name"));
            mapped.setBrand(Brand.valueOf(rs.getString("brand")));
            mapped.setPlate(rs.getString("plate"));
            mapped.setDealershipId(rs.getString("dealership_Id"));
            mapped.setOwnerId(rs.getString("ownerId"));
            return mapped;
        }, dealershipId);
        }
        @Override
        public List<Car> findByOwnerId(String ownerId){
            return jdbcTemplate.query("select * from cars where ownerId = ?", (rs, rowNo) -> {
               final var mapped = new Car();
                mapped.setId(rs.getString("id"));
                mapped.setName(rs.getString("name"));
                mapped.setBrand(Brand.valueOf(rs.getString("brand")));
                mapped.setPlate(rs.getString("plate"));
                mapped.setDealershipId(rs.getString("dealership_Id"));
                mapped.setOwnerId(rs.getString("ownerId"));
                return mapped;
            }, ownerId);
        }
    }


