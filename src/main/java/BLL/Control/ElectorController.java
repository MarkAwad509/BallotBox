package BLL.Control;

import BLL.Model.Elector;
import DAL.InMemConcreteDAOs.InMemElectorDAO;

public class ElectorController {

    InMemElectorDAO ElecDAO;

    public void CreateElector(String username, String password, int weight, String email)
    {
        Elector elec = new Elector(username, password, weight, email);
        ElecDAO.create(elec);
    }

    public void LinkElectorToBallot(int ballotID) {

    }
}
