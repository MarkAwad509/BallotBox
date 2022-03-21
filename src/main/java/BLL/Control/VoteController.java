package BLL.Control;

import BLL.Model.Candidate;
import BLL.Model.Vote;
import DAL.InMemConcreteDAOs.InMemCandidateDAO;
import DAL.InMemConcreteDAOs.InMemVoteDAO;
import DAL.InMemDAO;
import DL.InMemoryRepo;

import java.time.LocalDate;
import java.util.List;

public class VoteController {

    InMemDAO<Vote> daoV = new InMemVoteDAO();
    InMemDAO<Candidate> daoC = new InMemCandidateDAO();

    public void createVote(int SubjectID, LocalDate when, int rank) {
        daoV.create(new Vote(when, rank, SubjectID));
    }
}
