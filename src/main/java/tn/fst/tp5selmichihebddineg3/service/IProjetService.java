package tn.fst.tp5selmichihebddineg3.service;

import tn.fst.tp5selmichihebddineg3.entity.Projet;
import java.util.List;

public interface IProjetService {

    // CRUD
    List<Projet> getAllProjets();
    Projet getProjetById(Long idProjet);
    Projet addProjet(Projet projet);
    Projet updateProjet(Projet projet);
    void deleteProjet(Long idProjet);

    // Affectation ProjetDetail → Projet
    void assignProjetDetailToProjet(Long idProjetDetail, Long idProjet);

    // Désaffectation ProjetDetail ← Projet
    void removeProjetDetailFromProjet(Long idProjet);

    // Affectation Projet → Equipe
    void assignProjetToEquipe(Long idProjet, Long idEquipe);

    // Désaffectation Projet ← Equipe
    void removeProjetFromEquipe(Long idProjet);

    Projet addProjetAndProjetDetailAndAssign(Projet projet);

    Projet addProjetAndAssignExistingProjetDetail(Long idProjetDetail, Projet projet);


}
