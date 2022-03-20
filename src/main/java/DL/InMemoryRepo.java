package DL;

import BLL.Model.*;
import net.andreinc.mockneat.unit.time.LocalDates;
import util.generatorModels;

import java.time.LocalDate;
import java.util.List;

public class InMemoryRepo {
    private static InMemoryRepo instance = null;
    private generatorModels gm = new generatorModels();
    private List<Ballot> ballots;
    private List<Candidate> candidates;
    private List<Elector> electors;
    private List<Forum> forum;
    private List<Post> posts;
    private List<Vote> votes;

    private InMemoryRepo(){
//        this.candidates = gm.generateReusableCandidates();
//        this.electors = gm.generateReusableElectors();
//        this.votes = gm.generateReusableVotes();
        this.ballots = gm.ballotGenerator().list(1).get();
        this.forum = gm.forumGenerator().list(1).get();
        this.posts = gm.postGenerator().list(3).get();

        LocalDate date = LocalDate.of(2022, 3, 22);
        Vote v = new Vote(date, 1, 0 ); //h
        this.votes.add(v);
        Vote v1 = new Vote(date, 2, 1 ); //t
        this.votes.add(v1);
        Vote v2 = new Vote(date, 3, 0 ); //f
        this.votes.add(v2);
        Vote v3 = new Vote(date, 1, 3 ); //gm
        this.votes.add(v3);
        Vote v4 = new Vote(date, 2, 1 ); //t
        this.votes.add(v4);
        Vote v5 = new Vote(date, 3, 2 ); //f
        this.votes.add(v5);
        Vote v6 = new Vote(date, 1, 2 ); //f
        this.votes.add(v6);
        Vote v7 = new Vote(date, 2, 0 ); //h
        this.votes.add(v7);
        Vote v8 = new Vote(date, 3, 3 ); //gm
        this.votes.add(v8);
        Vote v9 = new Vote(date, 1, 1 ); //t
        this.votes.add(v9);
        Vote v10 = new Vote(date, 2, 1 ); //t
        this.votes.add(v10);
        Vote v11 = new Vote(date, 3, 0 ); //h
        this.votes.add(v11);

        Candidate h = new Candidate("H", "Honda", "", this.votes.stream().filter(c -> c.getCandidateID() == 0).toList() );
        Candidate t = new Candidate("T", "Toyota", "", this.votes.stream().filter(c -> c.getCandidateID() == 1).toList());
        Candidate f = new Candidate("F", "Ford", "", this.votes.stream().filter(c -> c.getCandidateID() == 2).toList());
        Candidate gm = new Candidate("GM", "General Motors", "", this.votes.stream().filter(c -> c.getCandidateID() == 3).toList());
        Elector e1 = new Elector("user1", "pass1", 1, "user1@ballotbox.com", );
        Elector e2 = new Elector("user2", "pass2", 1, "user2@ballotbox.com", );
        Elector e3 = new Elector("user3", "pass3", 1, "user3@ballotbox.com", );
    }

    public static InMemoryRepo getInstance() {
        if(instance == null)
            instance = new InMemoryRepo();
        return instance;
    }

    public List<Ballot> getBallots() {
        return ballots;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public List<Elector> getElectors() {
        return electors;
    }

    public List<Forum> getForum() {
        return forum;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Vote> getVotes() {
        return votes;
    }
}