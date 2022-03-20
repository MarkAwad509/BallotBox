package DAL.InMemConcreteDAOs;

import BLL.Model.Ballot;
import DAL.InMemDAO;
import DL.InMemoryRepo;
import java.util.List;
import java.util.Optional;

public class InMemBallotDAO implements InMemDAO<Ballot> {
    @Override
    public List<Ballot> getAll() {
        return InMemoryRepo.getInstance().getBallots();
    }

    @Override
    public Optional<Ballot> getOne(int id) {
        return InMemoryRepo.getInstance().getBallots().stream().filter(b -> b.getId() == id).findFirst();
    }

    @Override
    public boolean update(int id, Ballot data) {
        if(InMemoryRepo.getInstance().getBallots().stream().filter(b -> b.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().getBallots().add(data);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(int id) {
        if(InMemoryRepo.getInstance().getBallots().stream().filter(b -> b.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().getBallots().remove(id);
            return true;
        }else return false;
    }
}
