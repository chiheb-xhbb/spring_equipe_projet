package tn.fst.tp5selmichihebddineg3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import tn.fst.tp5selmichihebddineg3.entity.Equipe;
import tn.fst.tp5selmichihebddineg3.entity.Projet;
import tn.fst.tp5selmichihebddineg3.repository.EquipeRepository;
import tn.fst.tp5selmichihebddineg3.repository.ProjetRepository;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {

    EquipeRepository equipeRepository;
    ProjetRepository projetRepository;

    // ----------- CRUD -----------

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipeById(Long idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public void deleteEquipe(Long idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    // ----------- AFFECTATION : assign Projet → Equipe -----------

    @Override
    public void assignProjetToEquipe(Long idProjet, Long idEquipe) {
        Projet projet = projetRepository.findById(idProjet).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);

        if (projet != null && equipe != null) {
            projet.setEquipe(equipe);       // Projet est le fils
            projetRepository.save(projet); // Save the update
        }
    }

    // ----------- DESAFFECTATION : remove Projet ← Equipe -----------

    @Override
    public void removeProjetFromEquipe(Long idProjet, Long idEquipe) {
        Projet projet = projetRepository.findById(idProjet).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);

        if (projet != null && equipe != null && projet.getEquipe() == equipe) {
            projet.setEquipe(null);         // Remove link
            projetRepository.save(projet);  // Save update
        }
    }
}
