package htl.grieskirchen.aedinger16woche21;

import java.time.LocalDate;

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

    @Override
    public String toString() {
        return date.
    }
}
