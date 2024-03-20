package fr.gsb.rv.technique;
import fr.gsb.rv.entites.Visiteur;

public class Session {
    private static Session session;

    public Visiteur getLeVisiteur() {
        return leVisiteur;
    }

    public void setLeVisiteur(Visiteur leVisiteur) {
        this.leVisiteur = leVisiteur;
    }

    private Visiteur leVisiteur;

    private Session(Visiteur leVisiteur){
        this.leVisiteur = leVisiteur;
    }

    public static void ouvrir(Visiteur leVisiteur){
        if(session == null){
            session = new Session(leVisiteur);
        }
    }

    public static Session getSession(){
        return session;
    }

    public static void fermer(){
        session = null;
    }
}