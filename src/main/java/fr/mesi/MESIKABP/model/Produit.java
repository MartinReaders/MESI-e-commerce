package fr.mesi.MESIKABP.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Produit {

    // Column of Produit

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduit")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "marque")
    private String marque;

    @Column(name = "modele")
    private String modele;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "image")
    private String image;

    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "type")
    private Integer type;

    @Column(name = "couleur")
    private String couleur;

    @Column(name = "couleurMarque")
    private String couleurMarque;

    @Column(name = "description")
    private String description;

    @Column(name = "rgb")
    private Boolean rgb;

    @OneToMany(mappedBy = "produit")
    private Set<LienPanierProduit> paniers;

    // Constructor

    public Produit() {
    }

    public Produit(Long id, String code, String marque, String modele, Double prix, String image, Integer quantite, Integer type, String couleur, String couleurMarque, String description, Boolean rgb, Set<LienPanierProduit> paniers) {
        this.id = id;
        this.code = code;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
        this.type = type;
        this.couleur = couleur;
        this.couleurMarque = couleurMarque;
        this.description = description;
        this.rgb = rgb;
        this.paniers = paniers;
    }

    // Getter & Setter

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

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleurMarque() {
        return couleurMarque;
    }

    public void setCouleurMarque(String couleurMarque) {
        this.couleurMarque = couleurMarque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRgb() {
        return rgb;
    }

    public void setRgb(Boolean rgb) {
        this.rgb = rgb;
    }

    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produit)) return false;
        Produit produit = (Produit) o;
        return Objects.equals(getId(), produit.getId()) &&
                Objects.equals(getCode(), produit.getCode()) &&
                Objects.equals(getMarque(), produit.getMarque()) &&
                Objects.equals(getModele(), produit.getModele()) &&
                Objects.equals(getPrix(), produit.getPrix()) &&
                Objects.equals(getImage(), produit.getImage()) &&
                Objects.equals(getQuantite(), produit.getQuantite()) &&
                Objects.equals(getType(), produit.getType()) &&
                Objects.equals(getCouleur(), produit.getCouleur()) &&
                Objects.equals(getCouleurMarque(), produit.getCouleurMarque()) &&
                Objects.equals(getDescription(), produit.getDescription()) &&
                Objects.equals(getRgb(), produit.getRgb()) &&
                Objects.equals(paniers, produit.paniers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getMarque(), getModele(), getPrix(), getImage(), getQuantite(), getType(), getCouleur(), getCouleurMarque(), getDescription(), getRgb(), paniers);
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", prix=" + prix +
                ", image='" + image + '\'' +
                ", quantite=" + quantite +
                ", type=" + type +
                ", couleur='" + couleur + '\'' +
                ", couleurMarque='" + couleurMarque + '\'' +
                ", description='" + description + '\'' +
                ", rgb=" + rgb +
                ", paniers=" + paniers +
                '}';
    }
}
