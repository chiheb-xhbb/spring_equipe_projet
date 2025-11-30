package tn.fst.tp5selmichihebddineg3.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class ProjetDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String technologie;
    private Long cout;
    private Date dateDebut;

    @OneToOne(mappedBy = "projetDetail")
    private Projet projet;

    // ------- Constructeurs -------

    public ProjetDetail() {}

    public ProjetDetail(Long id, String description, String technologie, Long cout, Date dateDebut) {
        this.id = id;
        this.description = description;
        this.technologie = technologie;
        this.cout = cout;
        this.dateDebut = dateDebut;
    }

    // ------- Getters -------

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnologie() {
        return technologie;
    }

    public Long getCout() {
        return cout;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Projet getProjet() {
        return projet;
    }

    // ------- Setters -------

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTechnologie(String technologie) {
        this.technologie = technologie;
    }

    public void setCout(Long cout) {
        this.cout = cout;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
