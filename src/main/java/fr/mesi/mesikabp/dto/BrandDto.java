package fr.mesi.mesikabp.dto;

import java.util.Objects;

public class BrandDto {

    private Long id;

    private String libelle;

    private String colorBrand;

    private String image;

    private String description;


    // Constructor

    public BrandDto() {
    }

    public BrandDto(Long id, String libelle, String colorBrand, String image, String description) {
        this.id = id;
        this.libelle = libelle;
        this.colorBrand = colorBrand;
        this.image = image;
        this.description = description;
    }


    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getColorBrand() {
        return colorBrand;
    }

    public void setColorBrand(String colorBrand) {
        this.colorBrand = colorBrand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrandDto)) return false;
        BrandDto brandDto = (BrandDto) o;
        return Objects.equals(getId(), brandDto.getId()) &&
                Objects.equals(getLibelle(), brandDto.getLibelle()) &&
                Objects.equals(getColorBrand(), brandDto.getColorBrand()) &&
                Objects.equals(getImage(), brandDto.getImage()) &&
                Objects.equals(getDescription(), brandDto.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLibelle(), getColorBrand(), getImage(), getDescription());
    }

    @Override
    public String toString() {
        return "BrandDto{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", colorBrand='" + colorBrand + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
