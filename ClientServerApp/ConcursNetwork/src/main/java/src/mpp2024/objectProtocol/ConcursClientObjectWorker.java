package src.mpp2024.objectProtocol;

import src.mpp2024.domain.Inscriere;
import src.mpp2024.domain.PersoanaOficiu;
import src.mpp2024.dto.ListInscrieriProbaDTO;
import src.mpp2024.dto.PersoanaOficiuDTO;
import src.mpp2024.services.IConcursService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ConcursClientObjectWorker {
    private IConcursService serverCategorie;
    private IConcursService serverInscriere;
    private IConcursService serverNumeProba;
    private IConcursService serverParticipant;
    private IConcursService serverPersoanaOficiu;
    private Socket connection;

    public ConcursClientObjectWorker(IConcursService serverCategorie,IConcursService serverInscriere, IConcursService serverNumeProba, IConcursService serverParticipant,IConcursService serverPersoanaOficiu, Socket connection) {
        this.serverCategorie = serverCategorie;
        this.serverInscriere = serverInscriere;
        this.serverNumeProba = serverNumeProba;
        this.serverParticipant = serverParticipant;
        this.serverPersoanaOficiu = serverPersoanaOficiu;
        this.connection = connection;
    }

    //@Override
    public void run() {
        try (ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
             ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream())) {

            Object request = input.readObject();

            if (request instanceof String command) {
                if (command.startsWith("LOGIN:")) {
                    String[] parts = command.substring(6).split(",");
                    PersoanaOficiu user = serverPersoanaOficiu.login(parts[0], parts[1]);
                    output.writeObject(new PersoanaOficiuDTO(user));
                    output.flush();
                } else if (command.startsWith("GET_INSCRIERI_PROBA:")) {
                    int probaId = Integer.parseInt(command.substring("GET_INSCRIERI_PROBA:".length()));
                    List<Inscriere> inscrieri = serverInscriere.getInscrieriProba(probaId);
                    output.writeObject(new ListInscrieriProbaDTO(inscrieri));
                    output.flush();
                } else {
                    output.writeObject("UNKNOWN_COMMAND");
                    output.flush();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
