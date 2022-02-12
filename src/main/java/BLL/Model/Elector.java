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


    public Elector(String username, String pswd, int weight, String email){
        this.voterId = AUTO_ID;
        this.username = username;
        this.password = pswd;
        this.weight = weight;
        this.email = email;
        AUTO_ID++;
    }
}
