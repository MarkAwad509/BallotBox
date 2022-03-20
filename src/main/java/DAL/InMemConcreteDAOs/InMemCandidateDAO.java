package DAL.InMemConcreteDAOs;

import BLL.Model.Candidate;
import DAL.InMemDAO;
import DL.InMemoryRepo;
import java.util.List;
import java.util.Optional;

public class InMemCandidateDAO implements InMemDAO<Candidate> {
    @Override
    public void create(Candidate cand) {
        InMemoryRepo.getInstance().getCandidates().add(cand);
    }

    @Override
    public List<Candidate> getAll() {
        return InMemoryRepo.getInstance().getCandidates();
    }

    @Override
    public Optional<Candidate> getOne(int id) {
        return InMemoryRepo.getInstance().getCandidates().stream().filter(c -> c.getId() == id).findFirst();
    }

    @Override
    public boolean update(int id, Candidate data) {
        if(InMemoryRepo.getInstance().getCandidates().stream().filter(c -> c.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().getCandidates().add(data);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(int id) {
        if(InMemoryRepo.getInstance().getCandidates().stream().filter(c -> c.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().getCandidates().remove(id);
            return true;
        }else return false;
    }
}

