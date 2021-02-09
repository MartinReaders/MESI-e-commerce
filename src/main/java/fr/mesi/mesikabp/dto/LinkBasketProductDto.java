package fr.mesi.mesikabp.dto;


import java.util.Objects;

public class LinkBasketProductDto {

    private Long id;

    private Integer quantity;

    private BasketDto basket;

    private ProductDto product;

    public LinkBasketProductDto() {
    }

    public LinkBasketProductDto(Long id, Integer quantity, BasketDto basket, ProductDto product) {
        this.id = id;
        this.quantity = quantity;
        this.basket = basket;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BasketDto getBasket() {
        return basket;
    }

    public void setBasket(BasketDto basket) {
        this.basket = basket;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkBasketProductDto that = (LinkBasketProductDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(basket, that.basket) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, basket, product);
    }

    @Override
    public String toString() {
        return "LinkBasketProductDto{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", basket=" + basket +
                ", product=" + product +
                '}';
    }
}
