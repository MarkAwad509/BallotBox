package BLL.Model;

import java.util.Date;
import java.util.List;
import net.andreinc.mockneat.*;

public class Ballot {
    private static int AUTO_ID = 0;
    private int id;
    private String title;
    private Date start;
    private Date end;
    private boolean isPublic, isAnonymous;
    private List<Candidate> candidates;
    private Forum forum;

    public Ballot(String title, Date start, Date end, boolean isPublic, boolean isAnonymous){
        this.id = AUTO_ID;
        this.title = title;
        this.start = start;
        this.end = end;
        this.isPublic = isPublic;
        this.isAnonymous = isAnonymous;
        AUTO_ID++;
    }
}
