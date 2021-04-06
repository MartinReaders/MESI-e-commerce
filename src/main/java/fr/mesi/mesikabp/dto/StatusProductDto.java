package fr.mesi.mesikabp.dto;

import java.util.Objects;

public class StatusProductDto {

    private Long id;

    private String statusProduct;

    // Constructor

    public StatusProductDto() {

    }

    public StatusProductDto(Long idStatusProduct, String statusProduct) {
        this.id = idStatusProduct;
        this.statusProduct = statusProduct;
    }

    // Getter & Setter

    public Long getIdStatusProduct() {
        return id;
    }

    public void setIdStatusProduct(Long idStatusProduct) {
        this.id = idStatusProduct;
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
        if (!(o instanceof StatusProductDto)) return false;
        StatusProductDto that = (StatusProductDto) o;
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
                "idStatusProduct=" + id +
                ", statusProduct='" + statusProduct + '\'' +
                '}';
    }
}
