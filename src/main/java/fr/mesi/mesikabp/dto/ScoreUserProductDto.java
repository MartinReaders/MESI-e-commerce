package fr.mesi.mesikabp.dto;

import java.util.Objects;

public class ScoreUserProductDto {

    private Long id;

    private UserDto user;

    private ProductDto product;

    private Boolean score;


    // Constructor

    public ScoreUserProductDto() {

    }

    public ScoreUserProductDto(Long id, UserDto user, ProductDto product, Boolean score) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.score = score;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public Boolean getScore() {
        return score;
    }

    public void setScore(Boolean score) {
        this.score = score;
    }


    // Override Methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoreUserProductDto)) return false;
        ScoreUserProductDto that = (ScoreUserProductDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getProduct(), that.getProduct()) &&
                Objects.equals(getScore(), that.getScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getProduct(), getScore());
    }

    @Override
    public String toString() {
        return "ScoreUserProductDto{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", score=" + score +
                '}';
    }
}
