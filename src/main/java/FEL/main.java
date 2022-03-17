package FEL;

import DL.InMemoryRepo;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        InMemoryRepo Repository = InMemoryRepo.getInstance();

        for (var b:Repository.ballots) System.out.println(b.toString());
        for (var b:Repository.candidates) System.out.println(b.toString());
        for (var b:Repository.electors) System.out.println(b.toString());
        for (var b:Repository.forum) System.out.println(b.toString());
        for (var b:Repository.posts) System.out.println(b.toString());
        for (var b:Repository.votes) System.out.println(b.toString());

        if(Repository != null)
            System.out.println("all-good!");
    }
}
