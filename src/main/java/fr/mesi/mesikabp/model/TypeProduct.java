package fr.mesi.mesikabp.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class TypeProduct {

    // Column of TypeProduct

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTypeProduct")
    private Long id;

    @Column(name = "typeProduct")
    private String typeProduct;

    @Column(name = "familyProduct")
    private String familyProduct;

    // Constructor

    public TypeProduct(){

    }

    public TypeProduct(Long id, String typeProduct, String familyProduct) {
        this.id = id;
        this.typeProduct = typeProduct;
        this.familyProduct = familyProduct;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getFamilyProduct() {
        return familyProduct;
    }

    public void setFamilyProduct(String familyProduct) {
        this.familyProduct = familyProduct;
    }


    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeProduct that = (TypeProduct) o;
        return Objects.equals(id, that.id) && Objects.equals(typeProduct, that.typeProduct) && Objects.equals(familyProduct, that.familyProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeProduct, familyProduct);
    }

    @Override
    public String toString() {
        return "TypeProduct{" +
                "id=" + id +
                ", typeProduct='" + typeProduct + '\'' +
                ", familyProduct='" + familyProduct + '\'' +
                '}';
    }
}

