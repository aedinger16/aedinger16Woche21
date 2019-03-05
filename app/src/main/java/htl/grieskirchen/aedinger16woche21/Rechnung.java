package htl.grieskirchen.aedinger16woche21;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rechnung {

    private LocalDate date;
    private double betrag;
    private String category;
    private String incomeOrExpenditure;

    public Rechnung(LocalDate date, double betrag, String category, String incomeOrExpenditure) {
        this.date = date;
        this.betrag = betrag;
        this.category = category;
        this.incomeOrExpenditure = incomeOrExpenditure;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String toString() {
        if(incomeOrExpenditure.equals("Einnamen")){
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ": " + betrag + "€ erhalten \\(" + category + "\\)";
        }
        else{
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ": " + betrag + "€ ausgegeben (" + category + ")";
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIncomeOrExpenditure() {
        return incomeOrExpenditure;
    }

    public void setIncomeOrExpenditure(String incomeOrExpenditure) {
        this.incomeOrExpenditure = incomeOrExpenditure;
    }
}
