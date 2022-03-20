package BLL.Control;

import BLL.Model.Vote;

import java.time.LocalDate;

public class VoteController {

    public static void CreateVote(int SubjectID, LocalDate when, int rank)
    {
        Vote vote = new Vote(when, rank, SubjectID);
        //
    }
}
