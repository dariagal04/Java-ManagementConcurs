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

public class ConcursServicesObjectProxy implements IConcursService {

    private String host;
    private int port;

    public ConcursServicesObjectProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Object sendRequest(Object request) throws Exception {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            out.writeObject(request);
            out.flush();

            return in.readObject();
        }
    }

    @Override
    public List<Inscriere> getInscrieriProba(int probaId) throws Exception {
        Object response = sendRequest("GET_INSCRIERI_PROBA:" + probaId);
        if (response instanceof ListInscrieriProbaDTO dto) {
            return dto.getInscrieriProbe();
        }
        throw new RuntimeException("Invalid response from server.");
    }

    @Override
    public PersoanaOficiu login(String username, String password) throws Exception {
        Object response = sendRequest("LOGIN:" + username + "," + password);
        if (response instanceof PersoanaOficiuDTO dto) {
            return dto.getPersoanaOficiu();
        }
        throw new RuntimeException("Login failed.");
    }

    // Alte metode pot fi adăugate aici la fel
}
