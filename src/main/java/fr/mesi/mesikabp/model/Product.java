package fr.mesi.mesikabp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product {

    // Column of Product

    // Replace  produit = code, brand, model, price, image, quantity, type, color, colorBrand, description
    // By       product = code, brand, model, price, image, quantity, type, colorBrand, description

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Double price;

    @Column(name = "image")
    private String image;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "type")
    private Integer type;

    @Column(name = "color")
    private String color;

    @Column(name = "colorBrand")
    private String colorBrand;

    @Column(name = "description")
    private String description;

    @Column(name = "rgb")
    private Boolean rgb;

    @OneToMany(mappedBy = "product")
    private Set<LinkBasketProduct> baskets;

    // Constructor

    public Product() {

    }

    public Product(Long id, String code, String brand, String model, Double price, String image, Integer quantity, Integer type, String color, String colorBrand, String description, Boolean rgb, Set<LinkBasketProduct> baskets) {
        this.id = id;
        this.code = code;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.type = type;
        this.color = color;
        this.colorBrand = colorBrand;
        this.description = description;
        this.rgb = rgb;
        this.baskets = baskets;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMarque() {
        return brand;
    }

    public void setMarque(String brand) {
        this.brand = brand;
    }

    public Double getPrix() {
        return price;
    }

    public void setPrix(Double price) {
        this.price = price;
    }

    public Integer getQuantite() {
        return quantity;
    }

    public void setQuantite(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getModele() {
        return model;
    }

    public void setModele(String model) {
        this.model = model;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCouleur() {
        return color;
    }

    public void setCouleur(String color) {
        this.color = color;
    }

    public String getCouleurMarque() {
        return colorBrand;
    }

    public void setCouleurMarque(String colorBrand) {
        this.colorBrand = colorBrand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRgb() {
        return rgb;
    }

    public void setRgb(Boolean rgb) {
        this.rgb = rgb;
    }

    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) &&
                Objects.equals(getCode(), product.getCode()) &&
                Objects.equals(getMarque(), product.getMarque()) &&
                Objects.equals(getModele(), product.getModele()) &&
                Objects.equals(getPrix(), product.getPrix()) &&
                Objects.equals(getImage(), product.getImage()) &&
                Objects.equals(getQuantite(), product.getQuantite()) &&
                Objects.equals(getType(), product.getType()) &&
                Objects.equals(getCouleur(), product.getCouleur()) &&
                Objects.equals(getCouleurMarque(), product.getCouleurMarque()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getRgb(), product.getRgb()) &&
                Objects.equals(baskets, product.baskets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getMarque(), getModele(), getPrix(), getImage(), getQuantite(), getType(), getCouleur(), getCouleurMarque(), getDescription(), getRgb(), baskets);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", type=" + type +
                ", color='" + color + '\'' +
                ", colorBrand='" + colorBrand + '\'' +
                ", description='" + description + '\'' +
                ", rgb=" + rgb +
                ", baskets=" + baskets +
                '}';
    }
}
