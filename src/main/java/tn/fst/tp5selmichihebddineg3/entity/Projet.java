package tn.fst.tp5selmichihebddineg3.entity;

import jakarta.persistence.*;

@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sujet;

    // ASSOCIATIONS

    @OneToOne
    private ProjetDetail projetDetail;

    @ManyToOne
    private Equipe equipe;

    // ----------- Constructeurs -----------

    public Projet() {}

    public Projet(Long id, String sujet) {
        this.id = id;
        this.sujet = sujet;
    }

    // ----------- Getters -----------

    public Long getId() {
        return id;
    }

    public String getSujet() {
        return sujet;
    }

    public ProjetDetail getProjetDetail() {
        return projetDetail;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    // ----------- Setters -----------

    public void setId(Long id) {
        this.id = id;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setProjetDetail(ProjetDetail projetDetail) {
        this.projetDetail = projetDetail;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
