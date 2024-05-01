package firas.l2dis2.cinema8jee.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MovieCategory")
public class MovieCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_id")
    private Integer categorieId;
    private String label;

//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    private List<Movie> movies;

    public MovieCategory() {
    }

    public MovieCategory(Integer id, String label) {
        this.categorieId = id;
        this.label = label;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "\nCategory id : " + categorieId + " label : " + label;
    }

    // getters and setters
}