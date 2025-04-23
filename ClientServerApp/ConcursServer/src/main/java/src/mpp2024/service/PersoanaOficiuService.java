package src.mpp2024.service;

import src.mpp2024.domain.Inscriere;
import src.mpp2024.domain.PersoanaOficiu;
import src.mpp2024.repo.DB.PersoanaOficiuDBRepo;
import src.mpp2024.services.IConcursService;

import java.util.List;

public class PersoanaOficiuService implements IConcursService {

    private final PersoanaOficiuDBRepo persoanaOficiuDBRepo;

    public PersoanaOficiuService(PersoanaOficiuDBRepo persoanaOficiuDBRepo) {
        this.persoanaOficiuDBRepo = persoanaOficiuDBRepo;
    }

    public PersoanaOficiu authenticate(String username, String password) {

        PersoanaOficiu persoanaOficiu = persoanaOficiuDBRepo.getOneByUsername(username);
        if (persoanaOficiu != null && persoanaOficiu.getPassword().equals(password)) {
            return persoanaOficiu;
        }
        return null;
    }

    @Override
    public PersoanaOficiu login(String username, String password) throws Exception {
        return authenticate(username, password);
    }

    @Override
    public List<Inscriere> getInscrieriProba(int probaId) throws Exception {
        return List.of();
    }
}
