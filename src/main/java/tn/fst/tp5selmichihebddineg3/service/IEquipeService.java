package tn.fst.tp5selmichihebddineg3.service;

import tn.fst.tp5selmichihebddineg3.entity.Equipe;
import java.util.List;

public interface IEquipeService {

    // CRUD
    List<Equipe> getAllEquipes();
    Equipe getEquipeById(Long idEquipe);
    Equipe addEquipe(Equipe equipe);
    Equipe updateEquipe(Equipe equipe);
    void deleteEquipe(Long idEquipe);

    // Affectation / Désaffectation
    void assignProjetToEquipe(Long idProjet, Long idEquipe);
    void removeProjetFromEquipe(Long idProjet, Long idEquipe);
}
