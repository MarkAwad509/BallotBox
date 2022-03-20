package DAL.InMemConcreteDAOs;

import BLL.Model.Forum;
import DAL.InMemDAO;
import DL.InMemoryRepo;
import java.util.List;
import java.util.Optional;

public class InMemForumDAO implements InMemDAO<Forum> {
    @Override
    public List<Forum> getAll() {
        return InMemoryRepo.getInstance().getForum();
    }

    @Override
    public Optional<Forum> getOne(int id) {
        return InMemoryRepo.getInstance().getForum().stream().filter(f -> f.getId() == id).findFirst();
    }

    @Override
    public boolean update(int id, Forum data) {
        if(InMemoryRepo.getInstance().getForum().stream().filter(f -> f.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().getForum().add(data);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(int id) {
        if(InMemoryRepo.getInstance().getForum().stream().filter(f -> f.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().getForum().remove(id);
            return true;
        }else return false;
    }
}
