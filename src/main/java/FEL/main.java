package FEL;

import BLL.Control.BallotController;
import BLL.Model.Candidate;
import DL.InMemoryRepo;

public class main {
    public static void main(String[] args) {
        InMemoryRepo Repository = InMemoryRepo.getInstance();
        BallotController bc = new BallotController();

        System.out.println(Repository.getBallots().toString());
        for (var c:Repository.getCandidates()) System.out.println(c.toString());
        for (var e:Repository.getElectors()) System.out.println(e.toString());
        System.out.println(Repository.getForum().toString());
        for (var p:Repository.getPosts()) System.out.println(p.toString());
        for (var v:Repository.getVotes()) System.out.println(v.toString());

        if(Repository != null)
            System.out.println("Repo is all-good!");

        Candidate winner1 = bc.findWinnerUsingMonoScan(1).get();
        System.out.println("MonoScan winner is " + winner1.getName() + ". They have " + 13 + " votes.");

        bc.findWinnerUsingPolyScan(1);

        //String winner2 = bc.findWinnerUsingPolyScan(1).get().getName();
        //System.out.println("PolyScan winner is " + winner2 + ". They have " + 13 + " votes.");
    }
}
