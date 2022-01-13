package ro.carro.main.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.carro.main.model.Payment;

import java.util.List;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private final JdbcTemplate jdbcTemplate;

    public PaymentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Payment insert(Payment payment) {

        jdbcTemplate.update("insert into payments values(?, ?, ?, ?, ?)",
                payment.getId(), payment.getTitle(), payment.getDebt(), payment.getDetails(), payment.getOwnerId());
        return payment;
    }

    @Override
    public void delete(String paymentId) {
        jdbcTemplate.update("delete from payments where id = ?", paymentId);
    }

    @Override
    public List<Payment> findByOwnerId(String ownerId) {
        return jdbcTemplate.query("select * from payments where ownerId = ?", (rs, rowNo) -> {
            final var mapped = new Payment();
            mapped.setId(rs.getString("id"));
            mapped.setTitle(rs.getString("title"));
            mapped.setDebt(rs.getInt("debt"));
            mapped.setDetails(rs.getString("details"));
            mapped.setOwnerId(rs.getString("ownerId"));
            return mapped;
        }, ownerId);

    }
}
