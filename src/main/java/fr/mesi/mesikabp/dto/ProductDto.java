package fr.mesi.mesikabp.dto;

import fr.mesi.mesikabp.model.Basket;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ProductDto {

    // Column of Product

    private Long id;

    private BrandDto brand;

    private TypeProductDto typeProduct;

    private StatusProductDto statusProduct;

    private String code;

    private String model;

    private Double price;

    private String image;

    private Integer quantity;

    private String description;

    private Integer score;

    private List<Basket> baskets;


    // Constructor

    public ProductDto() {

    }

    public ProductDto(Long id, BrandDto brand, TypeProductDto typeProduct, StatusProductDto statusProduct, String code, String model, Double price, String image, Integer quantity, String description, Integer score, List<Basket> baskets) {
        this.id = id;
        this.brand = brand;
        this.typeProduct = typeProduct;
        this.statusProduct = statusProduct;
        this.code = code;
        this.model = model;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.description = description;
        this.score = score;
        this.baskets = baskets;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    public TypeProductDto getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProductDto typeProduct) {
        this.typeProduct = typeProduct;
    }

    public StatusProductDto getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(StatusProductDto statusProduct) {
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

    // Override Methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getBrand(), that.getBrand()) &&
                Objects.equals(getTypeProduct(), that.getTypeProduct()) &&
                Objects.equals(getStatusProduct(), that.getStatusProduct()) &&
                Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getModel(), that.getModel()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getImage(), that.getImage()) &&
                Objects.equals(getQuantity(), that.getQuantity()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getScore(), that.getScore());
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
