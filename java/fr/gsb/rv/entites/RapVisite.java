package fr.gsb.rv.entites;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RapVisite extends RecyclerView.Adapter {
    private int numRV;
    private String date_visite;

    private String dateSaisie;
    private String visiteur;
    private String praticien;
    private String motif;
    private String bilan;
    private int coeffConf;

    public RapVisite(int numRV, String date_visite, String dateSaisie, String visiteur, String praticien, String motif, String bilan, int coeffConf) {
        this.numRV = numRV;
        this.date_visite = date_visite;
        this.dateSaisie = dateSaisie;
        this.visiteur = visiteur;
        this.praticien = praticien;
        this.motif = motif;
        this.bilan = bilan;
        this.coeffConf = coeffConf;
    }

    public String getDate_visite() {

        return date_visite;
    }

    public String getPraticien() {

        return praticien;
    }

    public String getMotif() {

        return motif;
    }

    public String getBilan() {

        return bilan;
    }

    public int getCoeffConf() {

        return coeffConf;
    }

    public int getNumRV() {
        return numRV;
    }

    public String getVisiteur() {
        return visiteur;
    }

    public String getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(String dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    public void setVisiteur(String visiteur) {
        this.visiteur = visiteur;
    }

    public void setNumRV(int numRV) {this.numRV = numRV;}

    public void setDate_visite(String date_visite) {
        this.date_visite = date_visite;
    }

    public void setPraticien(String praticien) {
        this.praticien = praticien;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public void setCoeffConf(int coeffConf) {
        this.coeffConf = coeffConf;
    }

    public String getDateVisite() {
        return date_visite;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public String extractYear(){
        String[] parts = date_visite.split("/");
        return parts[2];
    }

    public String extractMonth(){
        String[] parts = date_visite.split("/");
        return parts[1];
    }

    public String extractDay(){
        String[] parts = date_visite.split("/");
        return parts[0];
    }
}
