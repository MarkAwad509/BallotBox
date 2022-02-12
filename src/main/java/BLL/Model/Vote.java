package BLL.Model;

import java.util.Date;

public class Vote{
    private static int AUTO_ID = 0;
    private int id;
    private Date dateOfVote;
    private int rank;
    private Candidate candidate;

    public Vote(Date when, int rank){
        this.id = AUTO_ID;
        this.dateOfVote = when;
        this.rank = rank;
        AUTO_ID++;
    }
}