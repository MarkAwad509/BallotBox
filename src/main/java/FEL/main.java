package FEL;

import DL.InMemoryRepo;

public class main {
    public static void main(String[] args) {
        InMemoryRepo Repository = InMemoryRepo.getInstance();
        if(Repository != null)
            System.out.println("all-good!");
    }
}
