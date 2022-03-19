package FEL;

import BLL.Control.BallotController;
import BLL.Model.Candidate;
import DAL.InMemDAO;
import DL.InMemoryRepo;

public class main {
    public static void main(String[] args) {
        InMemoryRepo Repository = InMemoryRepo.getInstance();
        BallotController bc = new BallotController();

        for (var b:Repository.ballots) System.out.println(b.toString());
        for (var b:Repository.candidates) System.out.println(b.toString());
        for (var b:Repository.electors) System.out.println(b.toString());
        for (var b:Repository.forum) System.out.println(b.toString());
        for (var b:Repository.posts) System.out.println(b.toString());
        for (var b:Repository.votes) System.out.println(b.toString());

        if(Repository != null)
            System.out.println("Repo is all-good!");

        System.out.println("Winner is" + 0+ " and has " + bc.findWinnerUsingMonoScan(1).get() + " votes.");
    }
}
