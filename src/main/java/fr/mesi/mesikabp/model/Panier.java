package fr.mesi.mesikabp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "panier")
    private Set<LinkBasketProduct> produits;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<LinkBasketProduct> getProduits() {
        return produits;
    }

    public void setProduits(Set<LinkBasketProduct> produits) {
        this.produits = produits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panier panier = (Panier) o;
        return Objects.equals(id, panier.id) &&
                Objects.equals(produits, panier.produits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produits);
    }

    @Override
    public String toString() {
        return "Panier{" +
                "id=" + id +
                ", produits=" + produits +
                '}';
    }
}
