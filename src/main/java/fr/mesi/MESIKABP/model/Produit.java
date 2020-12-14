package fr.mesi.MESIKABP.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduit")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "marque")
    private String marque;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "type")
    private Integer type;

    @OneToMany(mappedBy = "produit")
    private Set<LienPanierProduit> paniers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Objects.equals(id, produit.id) &&
                Objects.equals(code, produit.code) &&
                Objects.equals(marque, produit.marque) &&
                Objects.equals(prix, produit.prix) &&
                Objects.equals(quantite, produit.quantite) &&
                Objects.equals(type, produit.type) &&
                Objects.equals(paniers, produit.paniers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, marque, prix, quantite, type, paniers);
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                ", type=" + type +
                ", paniers=" + paniers +
                '}';
    }
}
