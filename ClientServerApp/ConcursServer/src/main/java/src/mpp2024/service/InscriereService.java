package src.mpp2024.service;

import src.mpp2024.domain.*;
import src.mpp2024.repo.DB.InscriereDBRepo;
import src.mpp2024.services.IConcursService;

import java.util.List;
import java.util.Map;

public class InscriereService implements IConcursService {

    private final InscriereDBRepo inscriereDBRepo;

    public InscriereService(InscriereDBRepo inscriereDBRepo) {
        this.inscriereDBRepo = inscriereDBRepo;
    }

    public Map<String, Map<String, Integer>> getCompetitionsWithParticipants() {
        return inscriereDBRepo.getCompetitionsWithParticipants();
    }

    public List<Participant> getParticipantsByProbaAndCategorie(NumeProba proba, CategorieVarsta categorie) {
        return inscriereDBRepo.getParticipantsByProbaAndCategorie(proba, categorie);
    }


    public boolean saveEntity(Inscriere inscriere) {
        return inscriereDBRepo.saveEntity(inscriere);
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
