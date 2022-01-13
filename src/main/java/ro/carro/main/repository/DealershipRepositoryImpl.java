package ro.carro.main.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.carro.main.model.Brand;
import ro.carro.main.model.Car;
import ro.carro.main.model.Dealership;
import ro.carro.main.model.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DealershipRepositoryImpl implements DealershipRepository {

    private final JdbcTemplate jdbcTemplate;

    public DealershipRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Dealership insert(Dealership dealership) {
        dealership.setId(UUID.randomUUID().toString());
        jdbcTemplate.update("insert into dealerships values (?, ?, ?, ?, ?)",
                dealership.getId(), dealership.getName(), dealership.getCity(), dealership.getAddress(), dealership.getOwnerId());
        return dealership;
    }

    @Override
    public void delete(String dealershipId) {
        jdbcTemplate.update("delete from dealerships where id = ?", dealershipId);
    }

    @Override
    public boolean exists(String dealershipId) {
        final var foundId = jdbcTemplate.queryForObject("select id from dealerships where id = ?", String.class, dealershipId);
        return foundId != null;
    }

    @Override
    public List<Dealership> findByOwnerId(String ownerId) {
        return jdbcTemplate.query("select * from dealerships where ownerId = ?", (rs, rowNo) -> {
            final var mapped = new Dealership();
            mapped.setId(rs.getString("id"));
            mapped.setName(rs.getString("name"));
            mapped.setCity(rs.getString("city"));
            mapped.setAddress(rs.getString("address"));
            return mapped;
        }, ownerId);
    }
        @Override
        public Optional<Dealership> read (String dealershipId){


            final var dealership = jdbcTemplate.queryForObject("select * from dealerships where id = ?",
                    (rs, rowNumber) -> {
                        final var mapped = new Dealership();
                        mapped.setId(rs.getString("id"));
                        mapped.setName(rs.getString("name"));
                        mapped.setCity(rs.getString("city"));
                        mapped.setAddress(rs.getString("address"));
                        return mapped;
                    }, dealershipId);

            return Optional.ofNullable(dealership);

        }
    }

