package fr.mesi.mesikabp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "statusProduct")
public class StatusProduct {

    // Column of StatusProduct

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatusProduct;

    @Column(name = "statusProduct")
    private String statusProduct;

    // Constructor

    public StatusProduct() {

    }

    public StatusProduct(Long idStatusProduct, String statusProduct) {
        this.idStatusProduct = idStatusProduct;
        this.statusProduct = statusProduct;
    }

    // Getter & Setter

    public Long getIdStatusProduct() {
        return idStatusProduct;
    }

    public void setIdStatusProduct(Long idStatusProduct) {
        this.idStatusProduct = idStatusProduct;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatusProduct)) return false;
        StatusProduct that = (StatusProduct) o;
        return Objects.equals(getIdStatusProduct(), that.getIdStatusProduct()) &&
                Objects.equals(getStatusProduct(), that.getStatusProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdStatusProduct(), getStatusProduct());
    }

    @Override
    public String toString() {
        return "StatusProduct{" +
                "idStatusProduct=" + idStatusProduct +
                ", statusProduct='" + statusProduct + '\'' +
                '}';
    }
}
