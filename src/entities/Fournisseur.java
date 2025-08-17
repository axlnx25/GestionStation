package entities;

import java.util.Scanner;

public class Fournisseur extends Personne {
    Scanner sc = new Scanner(System.in);

    public Fournisseur() {
        System.out.print("Entrez id fournisseur: " );
        this.identifiant = sc.nextInt();
        System.out.print("Entrez nom fournisseur: " );
        this.nom = sc.next();
        System.out.print("Entrez prenom fournisseur: " );
        this.prenom = sc.next();
        System.out.print("Entrez adresse fournisseur: " );
        this.adresse = sc.next();
        System.out.print("Entrez telephone fournisseur: " );
        this.telephone = sc.next();
    }

//    suite du code à implementer, en cours ...

}
