package src.mpp2024.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import src.mpp2024.objectProtocol.ConcursClientObjectWorker;
import src.mpp2024.services.IConcursService;

import java.net.Socket;

public class ConcursObjectConcurrentServer extends AbsConcurrentServer{
    private IConcursService concursServiceCategorie;
    private IConcursService concursServiceInscriere;
    private IConcursService concursServiceNumeProba;
    private IConcursService concursServiceParticipant;
    private IConcursService concursServicePersoanaOficiu;

    private static Logger logger = LogManager.getLogger(ConcursObjectConcurrentServer.class);
    public ConcursObjectConcurrentServer(int port, IConcursService concursServiceCategorie, IConcursService concursServiceInscriere, IConcursService concursServiceNumeProba, IConcursService concursServiceParticipant, IConcursService concursServicePersoanaOficiu) {
        super(port);
        this.concursServiceCategorie = concursServiceCategorie;
        this.concursServiceInscriere = concursServiceInscriere;
        this.concursServiceNumeProba = concursServiceNumeProba;
        this.concursServiceParticipant = concursServiceParticipant;
        this.concursServicePersoanaOficiu = concursServicePersoanaOficiu;
    }

    @Override
    protected Thread createWorker(Socket client){
        ConcursClientObjectWorker worker = new ConcursClientObjectWorker(concursServiceCategorie,concursServiceInscriere,  concursServiceNumeProba,concursServiceParticipant,concursServicePersoanaOficiu, client);
        Thread tw = new Thread(worker.toString());
        return tw;
    }
}
