package BLL.Control;

import BLL.Model.Vote;

import java.time.LocalDate;

public class VoteController {

    public static Vote CreateVote(int SubjectID, LocalDate when, int rank)
    {
        return new Vote(when, rank, SubjectID);
    }
}
