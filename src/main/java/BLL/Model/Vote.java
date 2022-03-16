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

    public int getId() {
        return id;
    }
}