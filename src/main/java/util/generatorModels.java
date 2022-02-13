package util;

import BLL.Model.*;
import net.andreinc.mockneat.abstraction.MockUnit;
import java.time.LocalDate;

import static net.andreinc.mockneat.types.enums.StringType.*;
import static net.andreinc.mockneat.unit.objects.Constructor.constructor;
import static net.andreinc.mockneat.unit.text.Strings.strings;
import static net.andreinc.mockneat.unit.time.LocalDates.localDates;
import static net.andreinc.mockneat.unit.types.Bools.bools;
import static net.andreinc.mockneat.unit.types.Ints.ints;
import static net.andreinc.mockneat.unit.user.Emails.emails;
import static net.andreinc.mockneat.unit.user.Names.names;

public class generatorModels {

    public static MockUnit<Ballot> ballotGenerator(){
        return constructor(Ballot.class).params(
                strings().size(15).type(HEX).get(),
                localDates().past(LocalDate.of(2020, 1, 1)).get(),
                localDates().future(LocalDate.of(2025, 12, 31)).get(),
                bools().get(),
                bools().get()
        );
    }

    public static MockUnit<Candidate> candidateGenerator(){
        return constructor(Candidate.class).params(
                names().first().get(),
                strings().size(40).type(LETTERS).get(),
                strings().get()
        );
    }

    public static MockUnit<Elector> electorGenerator(){
        return constructor(Elector.class).params(
                strings().size(6).type(LETTERS).get(),
                strings().size(10).type(ALPHA_NUMERIC).get(),
                ints().range(50, 200).get(),
                emails().domain("ballotbox.com").get()
        );
    }

    public static MockUnit<Forum> forumGenerator() {
        return constructor(Forum.class).params(
                strings().size(20).get(),
                localDates().get()
        );
    }

    public static MockUnit<Post> postGenerator(){
        return constructor(Post.class).params(
                localDates().get(),
                strings().size(20)
        );
    }

    public static MockUnit<Vote> voteGenerator(){
        return constructor(Vote.class).params(
                localDates().thisYear().get(),
                ints().get()
        );
    }
}