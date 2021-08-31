package fr.mesi.mesikabp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Product> productList;

    // Constructor

    public Brand() {

    }


    public Brand(Long idBrand, String libelle, String colorBrand, String image, String description) {
        this.idBrand = idBrand;
        this.libelle = libelle;
        this.colorBrand = colorBrand;
        this.image = image;
        this.description = description;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand)) return false;
        Brand brand = (Brand) o;
        return Objects.equals(getIdBrand(), brand.getIdBrand()) &&
                Objects.equals(getLibelle(), brand.getLibelle()) &&
                Objects.equals(getColorBrand(), brand.getColorBrand()) &&
                Objects.equals(getImage(), brand.getImage()) &&
                Objects.equals(getDescription(), brand.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdBrand(), getLibelle(), getColorBrand(), getImage(), getDescription());
    }

    @Override
    public String toString() {
        return "Brand{" +
                "idBrand=" + idBrand +
                ", libelle='" + libelle + '\'' +
                ", colorBrand='" + colorBrand + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
