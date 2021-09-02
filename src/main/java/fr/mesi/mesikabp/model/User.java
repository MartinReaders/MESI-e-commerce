package fr.mesi.mesikabp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
public class User {

    // Column of Utilisateur

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")

    private Long id;

    @Column(name = "login")
    private String login;


    @Column(name = "password")
    private String password;


    @Column(name = "grade")
    private Integer grade;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dateBirth")
    private LocalDate dateBirth;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "image")
    private String image;

    @ManyToMany(mappedBy = "users")
    private Set<Product> products;

    // Constructor

    public User(){

    }

    public User(Long id, String login, String password, Integer grade, String lastName, String firstName,
                String email, String phone, LocalDate dateBirth, String address1, String address2, String zipCode,
                String city, String country, String image) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.grade = grade;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.dateBirth = dateBirth;
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.image = image;
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

    public String getPassword() {
        return password;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User that = (User) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getGrade(), that.getGrade()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getDateBirth(), that.getDateBirth()) &&
                Objects.equals(getAddress1(), that.getAddress1()) &&
                Objects.equals(getAddress2(), that.getAddress2()) &&
                Objects.equals(getZipCode(), that.getZipCode()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getImage(), that.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getGrade(), getLastName(), getFirstName(), getEmail(), getPhone(), getDateBirth(), getAddress1(), getAddress2(), getZipCode(), getCity(), getCountry(), getImage());
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", dateBirth=" + dateBirth +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", zipCode=" + zipCode +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

}
