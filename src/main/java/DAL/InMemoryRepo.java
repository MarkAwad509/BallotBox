package DAL;

import BLL.Model.*;
import util.generatorModels;
import java.util.List;

public class InMemoryRepo {
    private static InMemoryRepo instance = null;

    private InMemoryRepo(){
        List<Ballot> ballots = generatorModels.ballotGenerator().list(5).get();
        List<Candidate> candidates = generatorModels.candidateGenerator().list(3).get();
        List<Elector> electors = generatorModels.electorGenerator().list(10).get();
        Forum forum = generatorModels.forumGenerator().get();
        List<Post> posts = generatorModels.postGenerator().list(3).get();
        List<Vote> votes = generatorModels.voteGenerator().list(3).get();

    }

    public static InMemoryRepo getInstance() {
        if(instance == null)
            instance = new InMemoryRepo();
        return instance;
    }
}