package ro.carro.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
    @Table(name = "payments")
    public final class Payment implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String id;

        private String title;

        private int debt;

        private String details;

        private String ownerId;

        public Payment() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getDebt() {
            return debt;
        }

        public void setDebt(int debt) {
            this.debt = debt;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id && debt == payment.debt && Objects.equals(title, payment.title) && Objects.equals(details, payment.details) && Objects.equals(ownerId, payment.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, debt, details, ownerId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", debt=" + debt +
                ", details='" + details + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
