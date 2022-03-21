package BLL.Control;

import BLL.Model.Elector;
import DAL.InMemConcreteDAOs.InMemBallotDAO;
import DAL.InMemConcreteDAOs.InMemElectorDAO;

public class ElectorController {

    InMemElectorDAO ElecDAO;
    InMemBallotDAO ballotDAO;

    public void createElector(String username, String password, int weight, String email)
    {
        Elector elec = new Elector(username, password, weight, email);
        ElecDAO.create(elec);
    }

    public void linkElectorToBallot(int elector, int ballotID) {
        ballotDAO = new InMemBallotDAO();
        Elector elec = ElecDAO.getOne(elector).get();
        elec.getOpenPolls().add(ballotDAO.getOne(ballotID).get());
    }
}
