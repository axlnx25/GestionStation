package entities;

public class Authentification {
    private GestionUtilisateur listeUsers = new GestionUtilisateur();

    public boolean login(String username, String password) {
        for (Utilisateur u : listeUsers.getUtilisateurs()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("CONNEXION REUSSIE");
                return true;
            }
        }
        System.out.println("Username ou Password incorrect");
        return false;
    }

    public void logout() {
        System.out.println("DECONNEXION REUSSIE");
    }
}
