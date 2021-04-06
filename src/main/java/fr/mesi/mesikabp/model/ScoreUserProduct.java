package fr.mesi.mesikabp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "score_user_product")
public class ScoreUserProduct {

    // Column of ScoreUserProduct

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idScoreUserProduct")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User idUser;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product idProduct;

    @Column(name = "valeur")
    private Boolean score;

    // Constructor

    public ScoreUserProduct() {

    }

    public ScoreUserProduct(Long id, User idUser, Product idProduct, Boolean score) {
        this.id = id;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.score = score;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public Boolean getScore() {
        return score;
    }

    public void setScore(Boolean score) {
        this.score = score;
    }


    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreUserProduct that = (ScoreUserProduct) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(idUser, that.idUser) &&
                Objects.equals(idProduct, that.idProduct) &&
                Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, idProduct, score);
    }

    @Override
    public String toString() {
        return "ScoreUserProduct{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idProduct=" + idProduct +
                ", score=" + score +
                '}';
    }
}
