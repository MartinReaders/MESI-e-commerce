package fr.mesi.MESIKABP.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "panier__produit")
public class LienPanierProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduitPanier")
    private Long id;

    @Column(name = "quantite")
    private Integer quantite;

    @ManyToOne
    @Column(name = "idPanier")
    private Panier panier;

    @ManyToOne
    @Column(name = "idProduit")
    private Produit produit;

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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LienPanierProduit that = (LienPanierProduit) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(quantite, that.quantite) &&
                Objects.equals(panier, that.panier) &&
                Objects.equals(produit, that.produit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantite, panier, produit);
    }

    @Override
    public String toString() {
        return "LienPanierProduit{" +
                "id=" + id +
                ", quantite=" + quantite +
                ", panier=" + panier +
                ", produit=" + produit +
                '}';
    }
}
