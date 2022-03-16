package DAL.ConcreteDAOs;

import BLL.Model.Ballot;
import DAL.InMemDAO;
import DAL.InMemoryRepo;
import java.util.List;
import java.util.Optional;

public class InMemoBallotDAO implements InMemDAO<Ballot> {

    @Override
    public List<Ballot> getAll() {
        return InMemoryRepo.getInstance().ballots;
    }

    @Override
    public Optional<Ballot> getOne(int id) {
        return InMemoryRepo.getInstance().ballots.stream().filter(b -> b.getId() == id).findFirst();
    }

    @Override
    public boolean update(int id, Ballot data) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        InMemoryRepo.getInstance().ballots.remove(id);
        return true;
    }
}
