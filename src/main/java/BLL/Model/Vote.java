package BLL.Model;

import java.time.LocalDate;

public class Vote{
    private static int AUTO_ID = 0;
    private int id;
    private LocalDate dateOfVote;
    private int rank;
    private int candidateID;

    public Vote(LocalDate when, int rank, int candidateID){
        this.id = AUTO_ID;
        this.dateOfVote = when;
        this.rank = rank;
        this.candidateID = candidateID;
        AUTO_ID++;
    }

    public int getCandidateID() {
        return candidateID;
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

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", dateOfVote=" + dateOfVote +
                ", rank=" + rank +
                ", candidateID=" + candidateID +
                '}';
    }
}