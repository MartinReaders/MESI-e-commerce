package fr.mesi.mesikabp.dto;

import java.util.Objects;

public class TypeProductDto {

    private Long id;

    private String typeProduct;

    private String familyProduct;

    // Constructor

    public TypeProductDto(){

    }

    public TypeProductDto(Long id, String typeProduct, String familyProduct) {
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
        TypeProductDto that = (TypeProductDto) o;
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

