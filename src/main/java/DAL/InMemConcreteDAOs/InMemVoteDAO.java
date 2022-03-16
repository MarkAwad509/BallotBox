package DAL.InMemConcreteDAOs;

import BLL.Model.Vote;
import DAL.InMemDAO;
import DL.InMemoryRepo;
import java.util.List;
import java.util.Optional;

public class InMemVoteDAO implements InMemDAO<Vote> {
    @Override
    public List<Vote> getAll() {
        return InMemoryRepo.getInstance().votes;
    }

    @Override
    public Optional<Vote> getOne(int id) {
        return InMemoryRepo.getInstance().votes.stream().filter(v -> v.getId() == id).findFirst();
    }

    @Override
    public boolean update(int id, Vote data) {
        if(InMemoryRepo.getInstance().votes.stream().filter(v -> v.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().votes.add(data);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(int id) {
        if(InMemoryRepo.getInstance().votes.stream().filter(v -> v.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().votes.remove(id);
            return true;
        }else return false;
    }
}
