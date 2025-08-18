package entities;
import java.util.*;

public class Authentification {
    private final String username = "admin";   // identifiant par défaut
    private final String password = "545";    // mot de passe par défaut
    private boolean estConnecte = false;

    public boolean login(Scanner sc) {
        System.out.print("Nom d'utilisateur: ");
        String user = sc.nextLine();
        System.out.print("Mot de passe: ");
        String pass = sc.nextLine();

        if (user.equals(username) && pass.equals(password)) {
            estConnecte = true;
            System.out.println(" Connexion réussie !");
        } else {
            System.out.println("Identifiants incorrects !");
        }
        return estConnecte;
    }

    public void logout() {
        estConnecte = false;
        System.out.println(" Déconnecté avec succès !");
    }

    public boolean isConnecte() {
        return estConnecte;
    }
}
