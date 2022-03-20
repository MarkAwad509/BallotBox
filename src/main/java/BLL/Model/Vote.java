package BLL.Model;

import java.time.LocalDate;

public class Vote{
    private static int AUTO_ID = 0;
    private int id;
    private LocalDate dateOfVote;
    private int rank;

    public Vote(LocalDate when, int rank, int candidateID, int voterID ){
        this.id = AUTO_ID;
        this.dateOfVote = when;
        this.rank = rank;
        AUTO_ID++;
    }

    public LocalDate getDateOfVote() {
        return dateOfVote;
    }

    public void setDateOfVote(LocalDate dateOfVote) {
        this.dateOfVote = dateOfVote;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
    }
}