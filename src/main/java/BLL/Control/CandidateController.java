package BLL.Control;

import BLL.Model.Candidate;
import BLL.Model.Elector;
import BLL.Model.Vote;
import DAL.InMemConcreteDAOs.InMemCandidateDAO;
import DAL.InMemDAO;

import java.util.ArrayList;
import java.util.List;

public class CandidateController {
    InMemDAO candDAO= new InMemCandidateDAO();

    public void CreateCandidate(String name, String description, String image)
    {
        Candidate cand = new Candidate(name, description, image);
        candDAO.create(cand);
    }
    public int findNumberOfInFavorByCandidate(int candidateId)
    {
        //Initialize counter
        int counter=0;

        //get candidate with id in parameters
        Candidate pickedCandidate = (Candidate)candDAO.getOne(candidateId).get();

        //Put allVotes in a list
        List<Vote> allVotes = new ArrayList<Vote>(pickedCandidate.getVotes());

        //count every time one of the vote's rank is equal to 1. Cast to a int
        counter = (int)allVotes.stream().filter(x -> x.getRank()==1).count();
        return counter;
    }
}
