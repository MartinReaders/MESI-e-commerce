package fr.mesi.mesikabp.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "basket")
public class Basket {

    // Column of Basket

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBasket")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_basket",
        joinColumns = @JoinColumn(name = "idBasket"),
        inverseJoinColumns = @JoinColumn(name = "idProduct"))
    @JsonManagedReference
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;


    // Constructor

    public Basket() {

    }

    public Basket(Long id, List<Product> products, User user) {
        this.id = id;
        this.products = products;
        this.user = user;
    }

    // Getter & Setter

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Override Methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Basket)) return false;
        Basket basket = (Basket) o;
        return Objects.equals(getId(), basket.getId()) &&
                Objects.equals(getProducts(), basket.getProducts()) &&
                Objects.equals(getUser(), basket.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser());
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
