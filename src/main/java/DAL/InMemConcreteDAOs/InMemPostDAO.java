package DAL.InMemConcreteDAOs;

import BLL.Model.Post;
import DAL.InMemDAO;
import DL.InMemoryRepo;
import java.util.List;
import java.util.Optional;

public class InMemPostDAO implements InMemDAO<Post> {

    @Override
    public void create(Post data) {
        InMemoryRepo.getInstance().getPosts().add(data);
    }

    @Override
    public List<Post> getAll() {
        return InMemoryRepo.getInstance().getPosts();
    }

    @Override
    public Optional<Post> getOne(int id) {
        return InMemoryRepo.getInstance().getPosts().stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public boolean update(int id, Post data) {
        if(InMemoryRepo.getInstance().getPosts().stream().filter(p -> p.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().getPosts().add(data);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(int id) {
        if(InMemoryRepo.getInstance().getPosts().stream().filter(p -> p.getId() == id).findFirst() != null) {
            InMemoryRepo.getInstance().getPosts().remove(id);
            return true;
        }else return false;
    }
}
