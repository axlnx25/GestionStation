package entities;

public class Utilisateur extends Personne {
    private static int compteur = 0; // ID automatique
    private String role;
    private String motDePasse;

        public Utilisateur(String nom, String prenom, String role, String motDePasse) {
            this.identifiant = ++compteur;
            this.nom = nom;
            this.prenom = prenom;
            this.role = role;
            this.motDePasse = motDePasse;
        }

    public String getMotDePasse() {
        return motDePasse;
    }

    public int getId() {
            return identifiant;
        }
        public String getNom() {
            return nom;
        }
        public String getPrenom() {
            return prenom;
        }
        public String getRole() {
            return role;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }
        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }
        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "ID: " + identifiant +
                    " | Nom: " + nom +
                    " | Prénom: " + prenom +
                    " | Role: " + role;
        }
    }

