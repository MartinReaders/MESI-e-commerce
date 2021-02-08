package fr.mesi.mesikabp.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;


@Entity
public class Utilisateur implements UserDetails {

    // Column of Utilisateur

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUtilisateur")
    private Long id;

    @Column(name = "login")
    private String login;


    @Column(name = "password")
    private String password;


    @Column(name = "grade")
    private Integer grade;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private Integer telephone;

    @Column(name = "dateNaissance")
    private Date dateNaissance;

    @Column(name = "adresse1")
    private String adresse1;

    @Column(name = "adresse2")
    private String adresse2;

    @Column(name = "codePostale")
    private Integer codePostale;

    @Column(name = "ville")
    private String ville;

    @Column(name = "pays")
    private String pays;

    // Constructor

    public Utilisateur(){

    }
    public Utilisateur(Long id, String login, String password, Integer grade) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.grade = grade;
    }

    public Utilisateur(Long id, String login, String password, Integer grade, String nom, String prenom, String email, Integer telephone, Date dateNaissance, String adresse1, String adresse2, Integer codePostale, String ville, String pays) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.grade = grade;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.dateNaissance = dateNaissance;
        this.adresse1 = adresse1;
        this.adresse2 = adresse2;
        this.codePostale = codePostale;
        this.ville = ville;
        this.pays = pays;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public Integer getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(Integer codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    // Override Methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilisateur)) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getGrade(), that.getGrade()) &&
                Objects.equals(getNom(), that.getNom()) &&
                Objects.equals(getPrenom(), that.getPrenom()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getTelephone(), that.getTelephone()) &&
                Objects.equals(getDateNaissance(), that.getDateNaissance()) &&
                Objects.equals(getAdresse1(), that.getAdresse1()) &&
                Objects.equals(getAdresse2(), that.getAdresse2()) &&
                Objects.equals(getCodePostale(), that.getCodePostale()) &&
                Objects.equals(getVille(), that.getVille()) &&
                Objects.equals(getPays(), that.getPays());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getGrade(), getNom(), getPrenom(), getEmail(), getTelephone(), getDateNaissance(), getAdresse1(), getAdresse2(), getCodePostale(), getVille(), getPays());
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", dateNaissance=" + dateNaissance +
                ", adresse1='" + adresse1 + '\'' +
                ", adresse2='" + adresse2 + '\'' +
                ", codePostale=" + codePostale +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
