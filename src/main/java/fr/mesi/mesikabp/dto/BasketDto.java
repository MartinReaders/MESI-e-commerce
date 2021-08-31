package fr.mesi.mesikabp.dto;

import fr.mesi.mesikabp.model.Product;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BasketDto {

    private Long id;

    private List<Product> products;

    private UserDto user;

    public BasketDto() {
    }

    public BasketDto(Long id, List<Product> products, UserDto user) {
        this.id = id;
        this.products = products;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketDto basketDto = (BasketDto) o;
        return Objects.equals(id, basketDto.id) &&
                Objects.equals(user, basketDto.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, user);
    }

    @Override
    public String toString() {
        return "BasketDto{" +
                "id=" + id +
                ", products=" + products +
                ", user=" + user +
                '}';
    }
}
