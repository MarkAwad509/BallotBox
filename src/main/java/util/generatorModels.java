package util;

import BLL.Model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import net.andreinc.mockneat.abstraction.MockUnit;
import static net.andreinc.mockneat.types.enums.StringType.*;
import static net.andreinc.mockneat.unit.objects.Constructor.constructor;
import static net.andreinc.mockneat.unit.text.Strings.strings;
import static net.andreinc.mockneat.unit.time.LocalDates.localDates;
import static net.andreinc.mockneat.unit.types.Bools.bools;
import static net.andreinc.mockneat.unit.types.Ints.ints;
import static net.andreinc.mockneat.unit.user.Emails.emails;
import static net.andreinc.mockneat.unit.user.Names.names;

public class generatorModels {
    List<Vote> votes = new ArrayList();
    List<Candidate> candidates = new ArrayList();

    public List<Vote> generateReusableVotes(){
        int numberOfVotes = candidates.size() *3; //setup for PolyScan

        this.votes = voteGenerator().list(numberOfVotes).get();
        return votes;
    }

    public List<Candidate> generateReusableCandidates(){
        this.candidates = candidateGenerator().list(3).get();
        return candidates;
    }


    public MockUnit<Ballot> ballotGenerator(){
        return constructor(Ballot.class).params(
                strings().size(15).type(HEX),
                localDates().past(LocalDate.of(2020, 1, 1)),
                localDates().future(LocalDate.of(2025, 12, 31)),
                bools(),
                bools(),
                this.votes
        );
    }

    private MockUnit<Candidate> candidateGenerator(){
        //String fullName = names().first() + " " + names().last();
        return constructor(Candidate.class).params(
                names().first(),
                strings().size(40).type(LETTERS),
                strings(),
                this.votes
        );
    }

    public MockUnit<Elector> electorGenerator(){
        return constructor(Elector.class).params(
                strings().size(6).type(LETTERS),
                strings().size(10).type(ALPHA_NUMERIC),
                ints().range(50, 200),
                emails().domain("ballotbox.com")
        );
    }

    public MockUnit<Forum> forumGenerator() {
        return constructor(Forum.class).params(
                strings().size(20),
                localDates()
        );
    }

    public MockUnit<Post> postGenerator(){
        return constructor(Post.class).params(
                localDates(),
                strings().size(20)
        );
    }

    public MockUnit<Vote> voteGenerator(){
        return constructor(Vote.class).params(
                localDates().thisYear(),
                ints().range(1,3),
                ints().range(0, candidates.size())
        );
    }
}