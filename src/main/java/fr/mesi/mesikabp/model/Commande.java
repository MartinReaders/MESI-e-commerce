package fr.mesi.mesikabp.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Commande {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCommande")
    private Long idCommande;






    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;


    @Column(name = "date")
    private LocalDate date;


    @Column(name = "prixTotal")
    private Double prixTotal;


    public Commande(){

    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }



    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return idCommande.equals(commande.idCommande) &&

                utilisateur.equals(commande.utilisateur) &&
                date.equals(commande.date) &&
                prixTotal.equals(commande.prixTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommande, utilisateur, date, prixTotal);
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", utilisateur=" + utilisateur +
                ", date=" + date +
                ", prixTotal=" + prixTotal +
                '}';
    }

    public Commande(Long idCommande, Utilisateur utilisateur, LocalDate date, Double prixTotal) {
        this.idCommande = idCommande;
        this.utilisateur = utilisateur;
        this.date = date;
        this.prixTotal = prixTotal;
    }
}
