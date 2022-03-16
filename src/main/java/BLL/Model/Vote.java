package BLL.Model;

import java.time.LocalDate;

public class Vote{
    private static int AUTO_ID = 0;
    private int id;

    private LocalDate dateOfVote;
    private int rank;
    private int candidateId; //From relation between Candidate and vote

    public Vote(int candidateId, LocalDate when, int rank){
        this.id = AUTO_ID;
        this.candidateId=candidateId;
        this.dateOfVote = when;
        this.rank = rank;
        AUTO_ID++;
    }
}