package src.mpp2024.service;

import src.mpp2024.domain.Inscriere;
import src.mpp2024.domain.NumeProba;
import src.mpp2024.domain.PersoanaOficiu;
import src.mpp2024.repo.DB.NumeProbaDBRepo;
import src.mpp2024.services.IConcursService;

import java.util.List;

public class NumeProbaService implements IConcursService {

    private final NumeProbaDBRepo numeProbaDBRepo;

    public NumeProbaService(NumeProbaDBRepo numeProbaDBRepo) {
        this.numeProbaDBRepo = numeProbaDBRepo;
    }

    public NumeProba getNumeProba(String nume){
        return numeProbaDBRepo.getNumeProbaByName(nume);
    }

    @Override
    public PersoanaOficiu login(String username, String password) throws Exception {
        return null;
    }

    @Override
    public List<Inscriere> getInscrieriProba(int probaId) throws Exception {
        return List.of();
    }
}
