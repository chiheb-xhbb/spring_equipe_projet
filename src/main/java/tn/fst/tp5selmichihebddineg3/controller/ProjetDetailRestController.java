package tn.fst.tp5selmichihebddineg3.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import tn.fst.tp5selmichihebddineg3.entity.ProjetDetail;
import tn.fst.tp5selmichihebddineg3.service.IProjetDetailService;

@RestController
@AllArgsConstructor
@RequestMapping("/projet-detail")
public class ProjetDetailRestController {

    IProjetDetailService projetDetailService;

    // ----------- CRUD -----------

    // GET all ProjetDetails
    // http://localhost:8089/tp5/projet-detail/get-all
    @GetMapping("/get-all")
    public List<ProjetDetail> getAllProjetDetails() {
        return projetDetailService.getAllProjetDetails();
    }

    // GET ProjetDetail by ID
    // http://localhost:8089/tp5/projet-detail/get/{detail-id}
    @GetMapping("/get/{detail-id}")
    public ProjetDetail getProjetDetailById(@PathVariable("detail-id") Long idDetail) {
        return projetDetailService.getProjetDetailById(idDetail);
    }

    // ADD ProjetDetail
    // http://localhost:8089/tp5/projet-detail/add
    @PostMapping("/add")
    public ProjetDetail addProjetDetail(@RequestBody ProjetDetail projetDetail) {
        return projetDetailService.addProjetDetail(projetDetail);
    }

    // UPDATE ProjetDetail
    // http://localhost:8089/tp5/projet-detail/update
    @PutMapping("/update")
    public ProjetDetail updateProjetDetail(@RequestBody ProjetDetail projetDetail) {
        return projetDetailService.updateProjetDetail(projetDetail);
    }

    // DELETE ProjetDetails
    // http://localhost:8089/tp5/projet-detail/delete/{detail-id}
    @DeleteMapping("/delete/{detail-id}")
    public void deleteProjetDetail(@PathVariable("detail-id") Long idDetail) {
        projetDetailService.deleteProjetDetail(idDetail);
    }
}
