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

    public Ballot(String title, LocalDate start, LocalDate end, boolean isPublic, boolean isAnonymous, List<Candidate> candidates){
        this.id = AUTO_ID;
        this.title = title;
        this.start = start;
        this.end = end;
        this.isPublic = isPublic;
        this.isAnonymous = isAnonymous;
        this.candidates = candidates;
        AUTO_ID++;
    }

    public Ballot(String title, LocalDate start) {
        this.id = AUTO_ID;
        this.title = title;
        this.start = start;
        AUTO_ID++;
    }

    public Ballot(String title, LocalDate start, LocalDate end, boolean isPublic, boolean isAnonymous) {
        this.id = AUTO_ID;
        this.title = title;
        this.start = start;
        this.end = end;
        this.isPublic = isPublic;
        this.isAnonymous = isAnonymous;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }
    public boolean isPublic() {
        return isPublic;
    }
    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    @Override
    public String toString() {
        return "Ballot{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", isPublic=" + isPublic +
                ", isAnonymous=" + isAnonymous +
                ", candidates=" + candidates +
                '}';
    }
}
