package ro.carro.main.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.carro.main.model.Owner;

import java.util.Optional;
import java.util.UUID;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

    private final JdbcTemplate jdbcTemplate;

    public OwnerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Owner insert(Owner owner) {
        owner.setId(UUID.randomUUID().toString());
        jdbcTemplate.update("insert into owners value (?, ?, ?)",
                owner.getId(), owner.getName(), owner.getPhone());
        return owner;
    }

    @Override
    public boolean exists(String ownerId) {
        final var foundId = jdbcTemplate.queryForObject("select id from owners where id = ?", String.class, ownerId);
        return foundId != null;
    }

    @Override
    public Optional<Owner> read(String ownerId) {

        final var owner = jdbcTemplate.queryForObject("select * from owners where id = ?",
                (rs, rowNumber) -> {
                    final var mapped = new Owner();
                    mapped.setId(rs.getString("id"));
                    mapped.setName(rs.getString("name"));
                    mapped.setPhone(rs.getString("phone"));
                    return mapped;
                }, ownerId);

        return Optional.ofNullable(owner);
    }
}

