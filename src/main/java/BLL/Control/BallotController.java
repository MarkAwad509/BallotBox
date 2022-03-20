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

    public void CreateBallot(String title, LocalDate start, LocalDate end, boolean isPublic, boolean isAnonymous)
    {
        Ballot ballot = new Ballot(title, start, end, isPublic, isAnonymous);
        ballotDAO.create(ballot);
    }

    public Optional<Candidate> findWinnerUsingMonoScan(int pollID){
        List<Integer> countedVotes = new ArrayList<>();

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

    public void findWinnerUsingPolyScan(int pollID){
        /*Todo
         * 1. count first choice
         * 2. put in hashMap   //ex: H:5 T:4 F:3 GM:2
         * 3. if loser = 1st choice, eliminate choice (2nd choice -> 1st choice) //GM = dead, toyota was second choice for both, toyota +2 -> H:5 T:6 F:3
         * 4. repeat... //F lost, 2nd choices were 2H, 1T -> H:7 T:6
         *              //T lost, Honda won (comparison only when data structure has 2 elements)
         */
        Optional<Candidate> winner;
        Map<String, Integer> countedVotes = new HashMap();

        //1.
        //2.
        for (var c : Repository.getCandidates())
            countedVotes.put(c.getName(), counter(Repository.getVotes(), c.getId()));



        int i = 0;
        //return winner;
    }

    private int counter(List<Vote> allVotes, int candidateID){
            return (int) allVotes.stream().filter(vote -> vote.getCandidateID() == candidateID).count();
    }
}
