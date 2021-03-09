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
    private String type;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorBrand() {
        return colorBrand;
    }

    public void setColorBrand(String colorBrand) {
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

    public Set<LinkBasketProduct> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<LinkBasketProduct> baskets) {
        this.baskets = baskets;
    }


    // Override Methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) &&
                Objects.equals(getCode(), product.getCode()) &&
                Objects.equals(getBrand(), product.getBrand()) &&
                Objects.equals(getModel(), product.getModel()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                Objects.equals(getImage(), product.getImage()) &&
                Objects.equals(getQuantity(), product.getQuantity()) &&
                Objects.equals(getType(), product.getType()) &&
                Objects.equals(getColor(), product.getColor()) &&
                Objects.equals(getColorBrand(), product.getColorBrand()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getRgb(), product.getRgb()) &&
                Objects.equals(getBaskets(), product.getBaskets());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getBrand(), getModel(), getPrice(), getImage(), getQuantity(), getType(), getColor(), getColorBrand(), getDescription(), getRgb(), getBaskets());
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
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", colorBrand='" + colorBrand + '\'' +
                ", description='" + description + '\'' +
                ", rgb=" + rgb +
                ", baskets=" + baskets +
                '}';
    }
}
