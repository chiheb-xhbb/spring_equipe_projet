package tn.fst.tp5selmichihebddineg3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import tn.fst.tp5selmichihebddineg3.entity.Projet;
import tn.fst.tp5selmichihebddineg3.entity.ProjetDetail;
import tn.fst.tp5selmichihebddineg3.entity.Equipe;
import tn.fst.tp5selmichihebddineg3.repository.ProjetRepository;
import tn.fst.tp5selmichihebddineg3.repository.ProjetDetailRepository;
import tn.fst.tp5selmichihebddineg3.repository.EquipeRepository;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements IProjetService {

    ProjetRepository projetRepository;
    ProjetDetailRepository projetDetailRepository;
    EquipeRepository equipeRepository;

    // ----------- CRUD -----------

    @Override
    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }

    @Override
    public Projet getProjetById(Long idProjet) {
        return projetRepository.findById(idProjet).orElse(null);
    }

    @Override
    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public Projet updateProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void deleteProjet(Long idProjet) {
        projetRepository.deleteById(idProjet);
    }

    // ----------- AFFECTATION PROJETDETAIL → PROJET -----------

    @Override
    public void assignProjetDetailToProjet(Long idProjetDetail, Long idProjet) {
        ProjetDetail projetDetail = projetDetailRepository.findById(idProjetDetail).orElse(null);
        Projet projet = projetRepository.findById(idProjet).orElse(null);

        if (projet != null && projetDetail != null) {
            projet.setProjetDetail(projetDetail);
            projetRepository.save(projet);
        }
    }

    // ----------- DESAFFECTATION PROJETDETAIL ← PROJET -----------

    @Override
    public void removeProjetDetailFromProjet(Long idProjet) {
        Projet projet = projetRepository.findById(idProjet).orElse(null);

        if (projet != null && projet.getProjetDetail() != null) {
            projet.setProjetDetail(null);
            projetRepository.save(projet);
        }
    }

    // ----------- AFFECTATION PROJET → EQUIPE -----------

    @Override
    public void assignProjetToEquipe(Long idProjet, Long idEquipe) {
        Projet projet = projetRepository.findById(idProjet).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);

        if (projet != null && equipe != null) {
            projet.setEquipe(equipe);       // Projet est le fils
            projetRepository.save(projet); // Save link
        }
    }

    // ----------- DESAFFECTATION PROJET ← EQUIPE -----------

    @Override
    public void removeProjetFromEquipe(Long idProjet) {
        Projet projet = projetRepository.findById(idProjet).orElse(null);

        if (projet != null && projet.getEquipe() != null) {
            projet.setEquipe(null);         // Remove link
            projetRepository.save(projet);  // Save update
        }
    }
}
