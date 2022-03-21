package BLL.Control;

import BLL.Model.*;
import DAL.InMemConcreteDAOs.*;
import DAL.InMemDAO;
import DL.InMemoryRepo;

import java.time.LocalDate;
import java.util.*;

public class BallotController {
    InMemoryRepo Repository = InMemoryRepo.getInstance();
    InMemDAO<Ballot> ballotDAO = new InMemBallotDAO();
    InMemDAO<Candidate> candidateDAO = new InMemCandidateDAO();
    CandidateController candidateController = new CandidateController();

    public void CreateBallot(String title, LocalDate start, LocalDate end, boolean isPublic, boolean isAnonymous)
    {
        Ballot ballot = new Ballot(title, start, end, isPublic, isAnonymous);
        ballotDAO.create(ballot);
    }

    public Optional<Candidate> findWinnerUsingMonoScan(int pollID){
        List<Integer> countedVotes = new ArrayList<>();

        if(ballotDAO.getOne(pollID) != null){
            for (var c : Repository.getCandidates())
                countedVotes.add(candidateController.countVotesForCandidate(c.getId()));

            int winningVoteCount = countedVotes.stream().max(Integer::compare).get();
            int winnerId = countedVotes.indexOf(winningVoteCount);
            return candidateDAO.getOne(winnerId);
        }
        else return null;
    }

    public Optional<Candidate> findWinnerUsingPolyScan(int pollID) {
        List<Integer> countedVotes = new ArrayList<>();

        if (ballotDAO.getOne(pollID) != null) {
            for (var c : Repository.getCandidates())
                countedVotes.add(candidateController.countVotesForCandidate(c.getId()));


            eliminateLoser(countedVotes);
            int winnerId = countedVotes.stream().findFirst().get();
            return candidateDAO.getOne(winnerId);
        }
        else return null;

    }

    private void eliminateLoser(List<Integer> countedVotes){
        if(countedVotes.size() == 1)
            return;

        var min = countedVotes.stream().min(Integer::compare);
        var loserId = countedVotes.indexOf(min.get());

        countedVotes.remove(loserId);
        eliminateLoser(countedVotes);
    }
}
