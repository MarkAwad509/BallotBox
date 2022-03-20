package DAL.InMemConcreteDAOs;

import BLL.Model.Vote;
import DAL.InMemDAO;
import DL.InMemoryRepo;
import java.util.List;
import java.util.Optional;

public class InMemVoteDAO implements InMemDAO<Vote> {
    @Override
    public List<Vote> getAll() {
        return InMemoryRepo.getInstance().getVotes();
    }

    @Override
    public Optional<Vote> getOne(int id) {
        return InMemoryRepo.getInstance().getVotes().stream().filter(v -> v.getId() == id).findFirst();
    }

    @Override
    public boolean update(int id, Vote data) {
        if(InMemoryRepo.getInstance().getVotes().stream().filter(v -> v.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().getVotes().add(data);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(int id) {
        if(InMemoryRepo.getInstance().getVotes().stream().filter(v -> v.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().getVotes().remove(id);
            return true;
        }else return false;
    }
}
