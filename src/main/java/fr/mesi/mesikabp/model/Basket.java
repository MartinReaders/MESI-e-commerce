package fr.mesi.mesikabp.model;



import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "basket")
public class Basket {

    // Column of Basket

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBasket")
    private Long id;

    @OneToMany(mappedBy = "basket")
    private Set<LinkBasketProduct> products;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;


    // Constructor

    public Basket() {

    }

    public Basket(Long id, Set<LinkBasketProduct> products, User user) {
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

    public Set<LinkBasketProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<LinkBasketProduct> products) {
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
        return Objects.hash(getId(), getProducts(), getUser());
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", products=" + products +
                ", user=" + user +
                '}';
    }
}
