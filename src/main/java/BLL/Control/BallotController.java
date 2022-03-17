package BLL.Control;

import BLL.Model.*;
import DAL.InMemConcreteDAOs.*;
import DAL.InMemDAO;
import DL.InMemoryRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BallotController {
    InMemoryRepo Repository = InMemoryRepo.getInstance();
    InMemDAO<Ballot> ballotDAO = new InMemBallotDAO();
    InMemDAO<Candidate> candidateDAO = new InMemCandidateDAO();


    public Optional<Integer> findWinnerUsingMonoScan(int pollID){
        List<Integer> countedVotes = new ArrayList();
        Optional<Integer> winner;

        if(ballotDAO.getOne(pollID) != null){
            for (var c : Repository.candidates) {
                countedVotes.add(counter(Repository.votes, c.getId()));
            }
            winner = countedVotes.stream().max(Integer::compare);
            System.out.println(countedVotes.indexOf(winner));
            return winner;
        }
        else return null;
    }

    public Candidate findWinnerUsingPolyScan(int pollID){
        Candidate winner = null;

        return winner;
    }

    private int counter(List<Vote> allVotes, int candidateID){
        return (int)allVotes.stream().filter(vote -> vote.getCandidateID() == candidateID).count();
    }
}
