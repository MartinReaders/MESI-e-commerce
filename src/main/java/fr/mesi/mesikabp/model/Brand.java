package fr.mesi.mesikabp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "brand")
public class Brand {

    // Column of Brand

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrand;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "colorBrand")
    private String colorBrand;

    // Constructor

    public Brand() {
    }

    public Brand(Long idBrand, String libelle, String colorBrand) {
        this.idBrand = idBrand;
        this.libelle = libelle;
        this.colorBrand = colorBrand;
    }


    // Getter & Setter

    public Long getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Long idBrand) {
        this.idBrand = idBrand;
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

    // Override Methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand)) return false;
        Brand brand = (Brand) o;
        return Objects.equals(getIdBrand(), brand.getIdBrand()) &&
                Objects.equals(getLibelle(), brand.getLibelle()) &&
                Objects.equals(getColorBrand(), brand.getColorBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdBrand(), getLibelle(), getColorBrand());
    }

    @Override
    public String toString() {
        return "Brand{" +
                "idBrand=" + idBrand +
                ", libelle='" + libelle + '\'' +
                ", colorBrand='" + colorBrand + '\'' +
                '}';
    }
}
