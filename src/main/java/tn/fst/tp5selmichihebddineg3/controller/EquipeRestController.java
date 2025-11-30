package tn.fst.tp5selmichihebddineg3.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import tn.fst.tp5selmichihebddineg3.entity.Equipe;
import tn.fst.tp5selmichihebddineg3.service.IEquipeService;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {

    IEquipeService equipeService;

    // ----------- CRUD -----------

    // GET all equipes
    // http://localhost:8089/tp5/equipe/get-all
    @GetMapping("/get-all")
    public List<Equipe> getAllEquipes() {
        return equipeService.getAllEquipes();
    }

    // GET equipe by ID
    // http://localhost:8089/tp5/equipe/get/{equipe-id}
    @GetMapping("/get/{equipe-id}")
    public Equipe getEquipeById(@PathVariable("equipe-id") Long idEquipe) {
        return equipeService.getEquipeById(idEquipe);
    }

    // ADD equipe
    // http://localhost:8089/tp5/equipe/add
    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe equipe) {
        return equipeService.addEquipe(equipe);
    }

    // UPDATE equipe
    // http://localhost:8089/tp5/equipe/update
    @PutMapping("/update")
    public Equipe updateEquipe(@RequestBody Equipe equipe) {
        return equipeService.updateEquipe(equipe);
    }

    // DELETE equipe
    // http://localhost:8089/tp5/equipe/delete/{equipe-id}
    @DeleteMapping("/delete/{equipe-id}")
    public void deleteEquipe(@PathVariable("equipe-id") Long idEquipe) {
        equipeService.deleteEquipe(idEquipe);
    }

    // ----------- AFFECTATION PROJET → EQUIPE -----------

    // http://localhost:8089/tp5/equipe/assign-projet/{projet-id}/{equipe-id}
    @PutMapping("/assign-projet/{projet-id}/{equipe-id}")
    public void assignProjetToEquipe(
            @PathVariable("projet-id") Long idProjet,
            @PathVariable("equipe-id") Long idEquipe) {

        equipeService.assignProjetToEquipe(idProjet, idEquipe);
    }

    // ----------- DESAFFECTATION PROJET ← EQUIPE -----------

    // http://localhost:8089/tp5/equipe/remove-projet/{projet-id}/{equipe-id}
    @PutMapping("/remove-projet/{projet-id}/{equipe-id}")
    public void removeProjetFromEquipe(
            @PathVariable("projet-id") Long idProjet,
            @PathVariable("equipe-id") Long idEquipe) {

        equipeService.removeProjetFromEquipe(idProjet, idEquipe);
    }
}
