package DL;

import BLL.Model.*;
import util.generatorModels;
import java.util.List;

public class InMemoryRepo {
    private static InMemoryRepo instance = null;
    private generatorModels gm = new generatorModels();
    public List<Ballot> ballots = null;
    public List<Candidate> candidates = null;
    public List<Elector> electors = null;
    public List<Forum> forum = null;
    public List<Post> posts = null;
    public List<Vote> votes = null;

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

}