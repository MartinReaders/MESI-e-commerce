package fr.mesi.mesikabp.dto;

import java.time.LocalDate;
import java.util.Objects;

public class OrderDto {

    private Long id;

    private UserDto user;

    private LocalDate date;

    private Double totalPrice;

    public OrderDto() {
    }

    public OrderDto(Long id, UserDto user, LocalDate date, Double totalPrice) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(id, orderDto.id) &&
                Objects.equals(user, orderDto.user) &&
                Objects.equals(date, orderDto.date) &&
                Objects.equals(totalPrice, orderDto.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, date, totalPrice);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
