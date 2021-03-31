package fr.mesi.mesikabp.dto;

import java.util.Objects;

public class CharacteristicsDto {

    private Long id;

    private Long idTypeProduct;

    private String title;

    // Constructor

    public CharacteristicsDto() {

    }

    public CharacteristicsDto(Long id, Long idTypeProduct, String title) {
        this.id = id;
        this.idTypeProduct = idTypeProduct;
        this.title = title;
    }


    // Getter & Setter

    public Long getIdcharacteristics() {
        return id;
    }

    public void setIdcharacteristics(Long idcharacteristics) {
        this.id = id;
    }

    public Long getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(Long idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacteristicsDto)) return false;
        CharacteristicsDto that = (CharacteristicsDto) o;
        return Objects.equals(id, that.id) && Objects.equals(idTypeProduct, that.idTypeProduct) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTypeProduct, title);
    }

    @Override
    public String toString() {
        return "characteristics{" +
                "idcharacteristics=" + id +
                ", idTypeProduct=" + idTypeProduct +
                ", title='" + title + '\'' +
                '}';
    }
}
