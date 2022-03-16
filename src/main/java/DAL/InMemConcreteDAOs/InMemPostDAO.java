package DAL.InMemConcreteDAOs;

import BLL.Model.Post;
import DAL.InMemDAO;
import DL.InMemoryRepo;
import java.util.List;
import java.util.Optional;

public class InMemPostDAO implements InMemDAO<Post> {
    @Override
    public List<Post> getAll() {
        return InMemoryRepo.getInstance().posts;
    }

    @Override
    public Optional<Post> getOne(int id) {
        return InMemoryRepo.getInstance().posts.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public boolean update(int id, Post data) {
        if(InMemoryRepo.getInstance().posts.stream().filter(p -> p.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().posts.add(data);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(int id) {
        if(InMemoryRepo.getInstance().posts.stream().filter(p -> p.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().posts.remove(id);
            return true;
        }else return false;
    }
}
