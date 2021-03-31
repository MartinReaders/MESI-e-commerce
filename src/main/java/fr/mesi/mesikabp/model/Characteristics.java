package fr.mesi.mesikabp.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class Characteristics {

    // Column of Characteristics

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcharacteristics")
    private Long idcharacteristics;

    @Column(name = "idTypeProduct")
    private Long idTypeProduct;

    @Column(name = "title")
    private String title;

    // Constructor

    public Characteristics() {

    }

    public Characteristics(Long idcharacteristics, Long idTypeProduct, String title) {
        this.idcharacteristics = idcharacteristics;
        this.idTypeProduct = idTypeProduct;
        this.title = title;
    }

    // Getter & Setter

    public Long getIdcharacteristics() {
        return idcharacteristics;
    }

    public void setIdcharacteristics(Long idcharacteristics) {
        this.idcharacteristics = idcharacteristics;
    }

    public Long getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(Long idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Override Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Characteristics)) return false;
        Characteristics that = (Characteristics) o;
        return Objects.equals(idcharacteristics, that.idcharacteristics) && Objects.equals(idTypeProduct, that.idTypeProduct) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcharacteristics, idTypeProduct, title);
    }

    @Override
    public String toString() {
        return "characteristics{" +
                "idcharacteristics=" + idcharacteristics +
                ", idTypeProduct=" + idTypeProduct +
                ", title='" + title + '\'' +
                '}';
    }
}
