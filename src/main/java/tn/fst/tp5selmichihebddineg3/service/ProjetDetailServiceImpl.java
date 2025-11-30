package tn.fst.tp5selmichihebddineg3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import tn.fst.tp5selmichihebddineg3.entity.ProjetDetail;
import tn.fst.tp5selmichihebddineg3.repository.ProjetDetailRepository;

@Service
@AllArgsConstructor
public class ProjetDetailServiceImpl implements IProjetDetailService {

    ProjetDetailRepository projetDetailRepository;

    // ----------- CRUD -----------

    @Override
    public List<ProjetDetail> getAllProjetDetails() {
        return projetDetailRepository.findAll();
    }

    @Override
    public ProjetDetail getProjetDetailById(Long idProjetDetail) {
        return projetDetailRepository.findById(idProjetDetail).orElse(null);
    }

    @Override
    public ProjetDetail addProjetDetail(ProjetDetail projetDetail) {
        return projetDetailRepository.save(projetDetail);
    }

    @Override
    public ProjetDetail updateProjetDetail(ProjetDetail projetDetail) {
        return projetDetailRepository.save(projetDetail);
    }

    @Override
    public void deleteProjetDetail(Long idProjetDetail) {
        projetDetailRepository.deleteById(idProjetDetail);
    }
}
