package src.mpp2024.service;

import src.mpp2024.domain.Inscriere;
import src.mpp2024.domain.Participant;
import src.mpp2024.domain.PersoanaOficiu;
import src.mpp2024.repo.DB.ParticipantiDBRepo;
import src.mpp2024.services.IConcursService;

import java.util.List;

public class ParticipantiService implements IConcursService {

    private final ParticipantiDBRepo participantiDBRepo;

    public ParticipantiService(ParticipantiDBRepo participantiDBRepo) {
        this.participantiDBRepo = participantiDBRepo;
    }

    public boolean saveEntity(Participant participant) {
        return participantiDBRepo.saveEntity(participant);
    }

    public Participant getParticipantByNume(String nume) {
        return participantiDBRepo.getParticipantByName(nume);
    }

    public Participant getParticipantByCNP(String cnp) {
        return participantiDBRepo.getParticipantByCNP(cnp);
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
