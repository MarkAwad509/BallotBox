package DL;

import BLL.Model.*;
import util.generatorModels;
import java.util.List;

public class InMemoryRepo {
    private static InMemoryRepo instance = null;
    public List<Ballot> ballots = null;
    public List<Candidate> candidates = null;
    public List<Elector> electors = null;
    public List<Forum> forum = null;
    public List<Post> posts = null;
    public List<Vote> votes = null;

    private InMemoryRepo(){
        this.ballots = generatorModels.ballotGenerator().list(5).get();
        this.candidates = generatorModels.candidateGenerator().list(3).get();
        this.electors = generatorModels.electorGenerator().list(10).get();
        this.forum = generatorModels.forumGenerator().list(1).get();
        this.posts = generatorModels.postGenerator().list(3).get();
        this.votes = generatorModels.voteGenerator().list(3).get();

    }

    public static InMemoryRepo getInstance() {
        if(instance == null)
            instance = new InMemoryRepo();
        return instance;
    }

}