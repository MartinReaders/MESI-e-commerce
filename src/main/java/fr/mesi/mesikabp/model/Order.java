package fr.mesi.mesikabp.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "allOrder")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrder")
    private Long idOrder;


    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;


    @Column(name = "date")
    private LocalDate date;


    @Column(name = "totalPrice")
    private Double totalPrice;


    public Order(){

    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
        Order order = (Order) o;
        return idOrder.equals(order.idOrder) &&

                user.equals(order.user) &&
                date.equals(order.date) &&
                totalPrice.equals(order.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, user, date, totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", user=" + user +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public Order(Long idOrder, User user, LocalDate date, Double totalPrice) {
        this.idOrder = idOrder;
        this.user = user;
        this.date = date;
        this.totalPrice = totalPrice;
    }
}
