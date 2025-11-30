package tn.fst.tp5selmichihebddineg3.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import tn.fst.tp5selmichihebddineg3.entity.Projet;
import tn.fst.tp5selmichihebddineg3.service.IProjetService;

@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetRestController {

    IProjetService projetService;

    // ----------- CRUD -----------

    // GET all projets
    // http://localhost:8089/tp5/projet/get-all
    @GetMapping("/get-all")
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }

    // GET projet by ID
    // http://localhost:8089/tp5/projet/get/{projet-id}
    @GetMapping("/get/{projet-id}")
    public Projet getProjetById(@PathVariable("projet-id") Long idProjet) {
        return projetService.getProjetById(idProjet);
    }

    // ADD projet
    // http://localhost:8089/tp5/projet/add
    @PostMapping("/add")
    public Projet addProjet(@RequestBody Projet projet) {
        return projetService.addProjet(projet);
    }

    // UPDATE projet
    // http://localhost:8089/tp5/projet/update
    @PutMapping("/update")
    public Projet updateProjet(@RequestBody Projet projet) {
        return projetService.updateProjet(projet);
    }

    // DELETE projet
    // http://localhost:8089/tp5/projet/delete/{projet-id}
    @DeleteMapping("/delete/{projet-id}")
    public void deleteProjet(@PathVariable("projet-id") Long idProjet) {
        projetService.deleteProjet(idProjet);
    }

    // ----------- AFFECTATION : ProjetDetail → Projet -----------

    // http://localhost:8089/tp5/projet/assign-detail/{detail-id}/{projet-id}
    @PutMapping("/assign-detail/{detail-id}/{projet-id}")
    public void assignProjetDetailToProjet(
            @PathVariable("detail-id") Long idProjetDetail,
            @PathVariable("projet-id") Long idProjet) {

        projetService.assignProjetDetailToProjet(idProjetDetail, idProjet);
    }

    // ----------- DESAFFECTATION : remove ProjetDetail ← Projet -----------

    // http://localhost:8089/tp5/projet/remove-detail/{projet-id}
    @PutMapping("/remove-detail/{projet-id}")
    public void removeProjetDetailFromProjet(@PathVariable("projet-id") Long idProjet) {
        projetService.removeProjetDetailFromProjet(idProjet);
    }

    // ----------- AFFECTATION : Projet → Equipe -----------

    // http://localhost:8089/tp5/projet/assign-equipe/{projet-id}/{equipe-id}
    @PutMapping("/assign-equipe/{projet-id}/{equipe-id}")
    public void assignProjetToEquipe(
            @PathVariable("projet-id") Long idProjet,
            @PathVariable("equipe-id") Long idEquipe) {

        projetService.assignProjetToEquipe(idProjet, idEquipe);
    }

    // ----------- DESAFFECTATION : Projet ← Equipe -----------

    // http://localhost:8089/tp5/projet/remove-equipe/{projet-id}
    @PutMapping("/remove-equipe/{projet-id}")
    public void removeProjetFromEquipe(@PathVariable("projet-id") Long idProjet) {
        projetService.removeProjetFromEquipe(idProjet);
    }
}
