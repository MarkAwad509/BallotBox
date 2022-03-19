package BLL.Model;

import java.util.List;

public class Elector {
    private static int AUTO_ID = 0;
    private int voterId;
    private String username;
    private String password;
    private int weight;
    private String email;
    private List<Vote> votes;
    private List<Post> posts;
    private List<Ballot> openPolls;
    private List<Ballot> ownedPolls;

    public Elector(String username, String password, int weight, String email){
        this.voterId = AUTO_ID;
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.email = email;
        AUTO_ID++;
    }

    public Elector(String username, String password, int weight, String email, List<Vote> votes) {
        this.voterId = AUTO_ID;
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.email = email;
        this.votes = votes;
        AUTO_ID++;
    }


    public int getVoterId() {
        return voterId;
    }

    @Override
    public String toString() {
        return "Elector{" +
                "voterId=" + voterId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", weight=" + weight +
                ", email='" + email + '\'' +
                ", votes=" + votes +
                ", posts=" + posts +
                ", openPolls=" + openPolls +
                ", ownedPolls=" + ownedPolls +
                '}';
    }
}
