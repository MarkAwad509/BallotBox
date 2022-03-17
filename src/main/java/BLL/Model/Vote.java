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