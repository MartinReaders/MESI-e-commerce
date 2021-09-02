package fr.mesi.mesikabp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product {

    // Column of Product

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idBrand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "idTypeProduct")
    private TypeProduct typeProduct;

    @ManyToOne
    @JoinColumn(name = "idStatusProduct")
    private StatusProduct statusProduct;

    @Column(name = "code")
    private String code;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Double price;

    @Column(name = "image")
    private String image;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "score")
    private Integer score;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private List<Basket> baskets;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "score_user_product",
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idUser"))
    private Set<User> users;

    // Constructor

    public Product() {

    }

    public Product(Long id, Brand brand, String model, Double price, String image, Integer quantity, String description) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.description = description;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public StatusProduct getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(StatusProduct statusProduct) {
        this.statusProduct = statusProduct;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(typeProduct, product.typeProduct) &&
                Objects.equals(statusProduct, product.statusProduct) &&
                Objects.equals(code, product.code) &&
                Objects.equals(model, product.model) &&
                Objects.equals(price, product.price) &&
                Objects.equals(image, product.image) &&
                Objects.equals(quantity, product.quantity) &&
                Objects.equals(description, product.description) &&
                Objects.equals(score, product.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, typeProduct, statusProduct, code, model, price, image, quantity, description, score, baskets);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand=" + brand +
                ", typeProduct=" + typeProduct +
                ", statusProduct=" + statusProduct +
                ", code='" + code + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", score=" + score +
                ", baskets=" + baskets +
                '}';
    }
}
