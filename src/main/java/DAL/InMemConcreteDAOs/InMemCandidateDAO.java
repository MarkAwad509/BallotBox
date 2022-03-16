package DAL.InMemConcreteDAOs;

import BLL.Model.Candidate;
import DAL.InMemDAO;
import DL.InMemoryRepo;
import java.util.List;
import java.util.Optional;

public class InMemCandidateDAO implements InMemDAO<Candidate> {
    @Override
    public List<Candidate> getAll() {
        return InMemoryRepo.getInstance().candidates;
    }

    @Override
    public Optional<Candidate> getOne(int id) {
        return InMemoryRepo.getInstance().candidates.stream().filter(c -> c.getId() == id).findFirst();
    }

    @Override
    public boolean update(int id, Candidate data) {
        if(InMemoryRepo.getInstance().candidates.stream().filter(c -> c.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().candidates.add(data);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(int id) {
        if(InMemoryRepo.getInstance().candidates.stream().filter(c -> c.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().candidates.remove(id);
            return true;
        }else return false;
    }
}

