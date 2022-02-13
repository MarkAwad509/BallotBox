package BLL.Model;

import java.time.LocalDate;
import java.util.List;

public class Ballot {
    private static int AUTO_ID = 0;
    private int id;
    private String title;
    private LocalDate start;
    private LocalDate end;
    private boolean isPublic, isAnonymous;
    private List<Candidate> candidates;
    private Forum forum;

    public Ballot(String title, LocalDate start, LocalDate end, boolean isPublic, boolean isAnonymous){
        this.id = AUTO_ID;
        this.title = title;
        this.start = start;
        this.end = end;
        this.isPublic = isPublic;
        this.isAnonymous = isAnonymous;
        AUTO_ID++;
    }

    public Ballot(String title, LocalDate start) {
        this.id = AUTO_ID;
        this.title = title;
        this.start = start;
        AUTO_ID++;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getStart() {
        return start;
    }
    public void setStart(LocalDate start) {
        this.start = start;
    }
    public LocalDate getEnd() {
        return end;
    }
    public void setEnd(LocalDate end) {
        this.end = end;
    }
    public boolean isPublic() {
        return isPublic;
    }
    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
    public boolean isAnonymous() {
        return isAnonymous;
    }
    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }
    public List<Candidate> getCandidates() {
        return candidates;
    }
    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }
    public Forum getForum() {
        return forum;
    }
    public void setForum(Forum forum) {
        this.forum = forum;
    }
}
