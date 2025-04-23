package src.mpp2024.service;

import src.mpp2024.domain.CategorieVarsta;
import src.mpp2024.domain.Inscriere;
import src.mpp2024.domain.PersoanaOficiu;
import src.mpp2024.repo.DB.CategorieDBRepo;
import src.mpp2024.services.IConcursService;

import java.util.List;
//import src.mpp2024.services.IConcursService;
//import src.mpp2024.services.IConcursService;

public class CategorieService implements IConcursService {

    private final CategorieDBRepo categorieDBRepo;

    public CategorieService(CategorieDBRepo categorieDBRepo) {
        this.categorieDBRepo = categorieDBRepo;
    }

    public CategorieVarsta getCategorie(int id) {
        return categorieDBRepo.getOne(id);
    }

    public CategorieVarsta getCategorieVarstaByAgeGroup(int min, int max) {
        return categorieDBRepo.getCategorieVarstaByAgeGroup(min, max);
    }

    public CategorieVarsta getCategorieVarstaByAge(int varsta) {
        return categorieDBRepo.getCategorieVarstaByAge(varsta);
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
