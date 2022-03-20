package DL;

import BLL.Model.*;
import util.generatorModels;
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
        this.candidates = gm.generateReusableCandidates();
        this.electors = gm.generateReusableElectors();
        this.votes = gm.generateReusableVotes();
        this.ballots = gm.ballotGenerator().list(5).get();
        this.forum = gm.forumGenerator().list(1).get();
        this.posts = gm.postGenerator().list(3).get();
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