package tn.fst.tp5selmichihebddineg3.service;

import tn.fst.tp5selmichihebddineg3.entity.ProjetDetail;
import java.util.List;

public interface IProjetDetailService {

    // CRUD
    List<ProjetDetail> getAllProjetDetails();
    ProjetDetail getProjetDetailById(Long idProjetDetail);
    ProjetDetail addProjetDetail(ProjetDetail projetDetail);
    ProjetDetail updateProjetDetail(ProjetDetail projetDetail);
    void deleteProjetDetail(Long idProjetDetail);
}
