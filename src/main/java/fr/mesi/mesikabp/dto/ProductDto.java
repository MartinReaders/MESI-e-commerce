package fr.mesi.mesikabp.dto;

import java.util.Objects;
import java.util.Set;

public class ProductDto {

    private Long id;

    private String code;

    private String brand;

    private String model;

    private Double price;

    private String image;

    private Integer quantity;

    private String type;

    private String color;

    private String colorBrand;

    private String description;

    private Boolean rgb;

    private Set<LinkBasketProductDto> baskets;

    public ProductDto() {
    }

    public ProductDto(Long id, String code, String brand, String model, Double price, String image, Integer quantity,
                      String type, String color, String colorBrand, String description, Boolean rgb,
                      Set<LinkBasketProductDto> baskets) {
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

    public Set<LinkBasketProductDto> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<LinkBasketProductDto> baskets) {
        this.baskets = baskets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(model, that.model) &&
                Objects.equals(price, that.price) &&
                Objects.equals(image, that.image) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(type, that.type) &&
                Objects.equals(color, that.color) &&
                Objects.equals(colorBrand, that.colorBrand) &&
                Objects.equals(description, that.description) &&
                Objects.equals(rgb, that.rgb) &&
                Objects.equals(baskets, that.baskets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, brand, model, price, image, quantity, type, color, colorBrand, description, rgb,
                baskets);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
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
                ", baskets='" + baskets + '\'' +
                '}';
    }
}
