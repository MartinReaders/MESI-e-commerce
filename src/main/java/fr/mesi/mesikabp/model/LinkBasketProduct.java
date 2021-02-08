package fr.mesi.mesikabp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "produit_panier")
public class LinkBasketProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduitPanier")
    private Long id;

    @Column(name = "quantite")
    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "idPanier")
    private Panier panier;

    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Product getProduit() {
        return product;
    }

    public void setProduit(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkBasketProduct that = (LinkBasketProduct) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(quantite, that.quantite) &&
                Objects.equals(panier, that.panier) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantite, panier, product);
    }

    @Override
    public String toString() {
        return "LienPanierProduit{" +
                "id=" + id +
                ", quantite=" + quantite +
                ", panier=" + panier +
                ", produit=" + product +
                '}';
    }
}
