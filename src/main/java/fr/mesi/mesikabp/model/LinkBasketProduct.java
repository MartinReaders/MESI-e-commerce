package fr.mesi.mesikabp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_basket")
public class LinkBasketProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProductBasket")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "idBasket")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;

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

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkBasketProduct that = (LinkBasketProduct) o;
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
        return "LienBasketProduct{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", basket=" + basket +
                ", product=" + product +
                '}';
    }
}
