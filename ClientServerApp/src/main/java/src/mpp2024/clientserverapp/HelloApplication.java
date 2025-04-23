package src.mpp2024.clientserverapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.mpp2024.clientserverapp.OficiuController;
import src.mpp2024.repo.DB.*;
import src.mpp2024.service.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HelloApplication extends Application {

    private CategorieService categorieService;
    private InscriereService inscriereService;
    private NumeProbaService numeProbaService;
    private ParticipantiService participantiService;
    private PersoanaOficiuService persoanaOficiuService;


    @Override
    public void start(Stage stage) throws IOException {
        Properties props = new Properties();
        try {
            props.load(new FileReader("bd.config"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config " + e);
        }

        CategorieDBRepo categorieDBRepo = new CategorieDBRepo(props);
        InscriereDBRepo inscriereDBRepo = new InscriereDBRepo(props);
        NumeProbaDBRepo numeProbaDBRepo = new NumeProbaDBRepo(props);
        ParticipantiDBRepo participantiDBRepo = new ParticipantiDBRepo(props);
        PersoanaOficiuDBRepo persoanaOficiuDBRepo = new PersoanaOficiuDBRepo(props);

        this.categorieService = new CategorieService(categorieDBRepo);
        this.inscriereService = new InscriereService(inscriereDBRepo);
        this.numeProbaService = new NumeProbaService(numeProbaDBRepo);
        this.participantiService = new ParticipantiService(participantiDBRepo);
        this.persoanaOficiuService = new PersoanaOficiuService(persoanaOficiuDBRepo);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        OficiuController ctr = fxmlLoader.getController();
        ctr.setServices(categorieService, inscriereService, numeProbaService, participantiService, persoanaOficiuService);

        stage.setTitle("LOGIN");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}