package DAL.InMemConcreteDAOs;

import BLL.Model.Elector;
import DAL.InMemDAO;
import DL.InMemoryRepo;
import java.util.List;
import java.util.Optional;

public class InMemElectorDAO implements InMemDAO<Elector> {
    @Override
    public List<Elector> getAll() {
        return InMemoryRepo.getInstance().electors;
    }

    @Override
    public Optional<Elector> getOne(int id) {
        return InMemoryRepo.getInstance().electors.stream().filter(e -> e.getVoterId() == id).findFirst();
    }

    @Override
    public boolean update(int id, Elector data) {
        if(InMemoryRepo.getInstance().electors.stream().filter(e -> e.getVoterId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().electors.add(data);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(int id) {
        if(InMemoryRepo.getInstance().electors.stream().filter(e -> e.getVoterId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().electors.remove(id);
            return true;
        }else return false;
    }
}