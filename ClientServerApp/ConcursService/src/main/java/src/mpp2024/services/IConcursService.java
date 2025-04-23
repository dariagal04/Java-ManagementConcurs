package src.mpp2024.services;

import src.mpp2024.domain.Inscriere;
import src.mpp2024.domain.PersoanaOficiu;

import java.util.List;

public interface IConcursService {

    /**
     * Autentifică o persoană de la oficiu.
     *
     * @param username Numele de utilizator
     * @param password Parola
     * @return Persoana autentificată
     * @throws Exception dacă autentificarea eșuează
     */
    PersoanaOficiu login(String username, String password) throws Exception;

    /**
     * Returnează toate înscrierile pentru o probă dată.
     *
     * @param probaId ID-ul probei
     * @return Lista cu înscrierile
     * @throws Exception dacă apare o eroare la accesarea datelor
     */
    List<Inscriere> getInscrieriProba(int probaId) throws Exception;

    // Alte metode pot fi adăugate, de exemplu:
    // void inscriereCopil(Copil copil, List<Proba> probe) throws Exception;
    // List<Proba> getProbeDisponibile();
    // List<Categorie> getCategoriiDisponibile();
}
