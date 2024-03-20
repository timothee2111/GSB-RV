package fr.gsb.rv.modeles;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fr.gsb.rv.entites.MainActivity;
import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.entites.RapVisite;
import fr.gsb.rv.technique.Session;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ModeleGSB extends MainActivity {

    private static ModeleGSB modele = null;
    private List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
    private List<RapVisite> lesRapports = new ArrayList<RapVisite>();

    private ModeleGSB(){
        super();
        this.peupler();
    }

    public static ModeleGSB getInstance(){
        if( ModeleGSB.modele == null ){
            modele = new ModeleGSB();
        }
        return ModeleGSB.modele;
    }

    public List<Visiteur> getLesVisiteurs() {
        return lesVisiteurs;
    }

    public void setLesVisiteurs(List<Visiteur> lesVisiteurs) {
        this.lesVisiteurs = lesVisiteurs;
    }

    public List<RapVisite> getLesRapports() {
        return lesRapports;
    }

    public void setLesRapports(List<RapVisite> lesRapports) {
        this.lesRapports = lesRapports;
    }

    private void peupler(){
        this.lesVisiteurs.add( new Visiteur("a131","azerty","Villechalane","Louis") );
        this.lesVisiteurs.add( new Visiteur("b13","azerty","Bentot","Pascal") );
        this.lesVisiteurs.add( new Visiteur("b16","azerty","Bioret","Luc") );
        this.lesVisiteurs.add( new Visiteur("a17","azerty","Andre","David") );

        this.lesRapports.add(new RapVisite( 1, "20/11/2023", "20/11/2023","Villechalane","Mr.Bienvenu","don d'echantillons","J'ai trop kiffé cette visite",7));
        this.lesRapports.add(new RapVisite( 2, "20/11/2023", "20/11/2023","Villechalane","Mr.Honoré","visite de courtoisie","Nul à souhait",2));
        this.lesRapports.add(new RapVisite( 3, "20/1/2023", "20/11/2023","Villechalane","Mr.Gambo","don d'echantillons","Pas foufou",4));
        this.lesRapports.add(new RapVisite( 4, "20/1/2023", "20/11/2023","Villechalane","Mr.Diabaté","pour le plaisir","sa fait plaisir",10));
    }

    public Visiteur seConnecter(String matricule, String mdp){

        for( Visiteur unVisiteur : this.lesVisiteurs ){
            if( unVisiteur.getMatricule().equals(matricule) && unVisiteur.getMdp().equals(mdp) ){
                return unVisiteur ;
            }
        }

        return null ;

    }

    public boolean enregistrerRapport(String dateVisite, String praticien, String motif, String bilan, String coeffConf) {
        // Obtenez le visiteur connecté à partir de la session
        Visiteur visiteurConnecte = Session.getSession().getLeVisiteur();

        // Vérifiez si le visiteur est connecté
        if (visiteurConnecte != null) {
            // Obtenez la date actuelle
            String dateSaisie = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

            // Créez le nouveau rapport de visite
            RapVisite rapport = new RapVisite(
                    lesRapports.size() + 1, // Numéro de la fiche (auto-incrémenté)
                    dateVisite, // Date de visite saisie dans le formulaire
                    dateSaisie, // Date de saisie (date actuelle)
                    visiteurConnecte.getNom() + " " + visiteurConnecte.getPrenom(), // Nom complet du visiteur
                    praticien, // Nom du praticien visité saisi dans le formulaire
                    motif, // Motif de la visite saisi dans le formulaire
                    bilan, // Bilan saisi dans le formulaire
                    Integer.parseInt(coeffConf) // Coeff confiance saisi dans le formulaire
            );

            // Ajoutez le nouveau rapport à la liste des rapports
            lesRapports.add(rapport);

            // Retournez true pour indiquer que l'enregistrement a réussi
            return true;
        } else {
            // Retournez false si aucun visiteur n'est connecté
            return false;
        }
    }


    public ArrayList<RapVisite> FiltrationRV(String annee, String mois){
        ArrayList<RapVisite> Retour = new ArrayList<>();
        for(int i=0; i < this.lesRapports.size(); i++){
            if(lesRapports.get(i).extractMonth().equals(mois) && lesRapports.get(i).extractYear().equals(annee)){
                Retour.add(lesRapports.get(i));
            }
        }
        return Retour;
    }

    public RapVisite getRapportByNum(int numRapport) {
        for (RapVisite rapport : lesRapports) {
            if (rapport.getNumRV() == numRapport) {
                return rapport;
            }
        }
        return null;
    }
}
