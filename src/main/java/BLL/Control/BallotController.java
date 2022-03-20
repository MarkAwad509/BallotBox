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


    public Optional<Candidate> findWinnerUsingMonoScan(int pollID){
        List<Integer> countedVotes = new ArrayList();

        if(ballotDAO.getOne(pollID) != null){
            for (var c : Repository.getCandidates()) {
                countedVotes.add(counter(Repository.getVotes(), c.getId()));
            }
            Optional<Integer> winningVotesCount = countedVotes.stream().max(Integer::compare);
            int winnerId = countedVotes.indexOf(winningVotesCount.get());
            Optional<Candidate> winner =  candidateDAO.getOne(winnerId);

            return winner;
        }
        else return null;
    }

//    public Optional<Candidate> findWinnerUsingPolyScan(int pollID){
//        Optional<Candidate> winner = new Candidate();
//        return winner;
//    }

    private int counter(List<Vote> allVotes, int candidateID){
        return (int)allVotes.stream().filter(vote -> vote.getCandidateID() == candidateID).count();
    }
}
