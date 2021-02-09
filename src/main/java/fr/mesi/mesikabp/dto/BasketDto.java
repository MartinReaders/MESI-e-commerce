package fr.mesi.mesikabp.dto;

import java.util.Objects;
import java.util.Set;

public class BasketDto {

    private Long id;

    private Set<LinkBasketProductDto> products;

    private UserDto user;

    public BasketDto() {
    }

    public BasketDto(Long id, Set<LinkBasketProductDto> products, UserDto user) {
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

    public Set<LinkBasketProductDto> getProducts() {
        return products;
    }

    public void setProducts(Set<LinkBasketProductDto> products) {
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
                Objects.equals(products, basketDto.products) &&
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
