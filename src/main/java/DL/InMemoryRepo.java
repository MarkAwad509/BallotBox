package DL;

import BLL.Model.*;
import net.andreinc.mockneat.unit.time.LocalDates;
import util.generatorModels;

import java.time.LocalDate;
import java.util.ArrayList;
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
        this.candidates = new ArrayList();
        this.electors = new ArrayList();
        this.votes = new ArrayList();
        this.ballots = gm.ballotGenerator().list(1).get();
        this.forum = gm.forumGenerator().list(1).get();
        this.posts = gm.postGenerator().list(3).get();

        LocalDate date = LocalDate.of(2022, 3, 22);
        Vote v = new Vote(date, 1, 0);
        Vote v1 = new Vote(date, 1, 1);
        Vote v2 = new Vote(date, 1, 0);
        Vote v3 = new Vote(date, 2, 1);
        Vote v4 = new Vote(date, 2, 2);
        Vote v5 = new Vote(date, 2, 3);
        Vote v6 = new Vote(date, 3, 2);
        Vote v7 = new Vote(date, 3, 0);
        Vote v8 = new Vote(date, 3, 1);
        Vote v9 = new Vote(date, 4, 3);
        Vote v10 = new Vote(date, 4, 3);
        Vote v11 = new Vote(date, 4, 2);

        this.votes.add(v);
        this.votes.add(v1);
        this.votes.add(v2);
        this.votes.add(v3);
        this.votes.add(v4);
        this.votes.add(v5);
        this.votes.add(v6);
        this.votes.add(v7);
        this.votes.add(v8);
        this.votes.add(v9);
        this.votes.add(v10);
        this.votes.add(v11);

        Candidate h = new Candidate("H", "Honda", "", this.votes.stream().filter(c -> c.getCandidateID() == 0).toList());
        Candidate t = new Candidate("T", "Toyota", "", this.votes.stream().filter(c -> c.getCandidateID() == 1).toList());
        Candidate f = new Candidate("F", "Ford", "", this.votes.stream().filter(c -> c.getCandidateID() == 2).toList());
        Candidate gm = new Candidate("GM", "General Motors", "", this.votes.stream().filter(c -> c.getCandidateID() == 3).toList());

        this.candidates.add(h);
        this.candidates.add(t);
        this.candidates.add(f);
        this.candidates.add(gm);

        Elector e1 = new Elector("user1", "pass1", 1, "user1@ballotbox.com");
        Elector e2 = new Elector("user2", "pass2", 1, "user2@ballotbox.com");
        Elector e3 = new Elector("user3", "pass3", 1, "user3@ballotbox.com");

        this.electors.add(e1);
        this.electors.add(e2);
        this.electors.add(e3);
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