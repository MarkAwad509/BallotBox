package DAL.MongoConcreteDAOs;

import BLL.Model.Ballot;
import DAL.MongoDAO;

import java.util.List;
import java.util.Optional;

public class MongoBallotDAO implements MongoDAO<Ballot> {
    //connection
    //get all info from mongo
    //etc...
    @Override
    public void connect(String connectionString) {

    }

    @Override
    public List<Ballot> getAll() {
        return null;
    }

    @Override
    public Optional<Ballot> getOne(int id) {
        return Optional.empty();
    }

    @Override
    public boolean update(int id, Ballot data) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
