package BLL.Control;

import BLL.Model.Candidate;
import BLL.Model.Elector;
import BLL.Model.Vote;
import DAL.InMemConcreteDAOs.InMemCandidateDAO;
import DAL.InMemDAO;

import java.util.ArrayList;
import java.util.List;

public class CandidateController {
    InMemDAO candidateDAO= new InMemCandidateDAO();

    public void createCandidate(String name, String description, String image) {
        candidateDAO.create(new Candidate(name, description, image));
    }

    public int countVotesForCandidate(int candidateId) {
        Candidate pickedCandidate = (Candidate)candidateDAO.getOne(candidateId).get();
        List<Vote> allVotes = new ArrayList(pickedCandidate.getVotes());
        return (int)allVotes.stream().filter(x -> x.getRank()==1).count();
    }
}
