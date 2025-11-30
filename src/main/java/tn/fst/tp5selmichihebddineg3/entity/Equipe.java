package tn.fst.tp5selmichihebddineg3.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Enumerated(EnumType.STRING)
    private Domaine domaine;

    // ASSOCIATIONS
    @OneToMany(mappedBy = "equipe")
    private List<Projet> projets;

    // ----------- Constructeurs -----------

    public Equipe() {}

    public Equipe(Long id, String nom, Domaine domaine) {
        this.id = id;
        this.nom = nom;
        this.domaine = domaine;
    }

    // ----------- Getters -----------

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    // ----------- Setters -----------

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
}
