package be.odisee.team5.userapi.dao;


import be.odisee.team5.userapi.domain.Persoon;
import org.springframework.data.repository.CrudRepository;

public interface PersoonRepository extends CrudRepository<Persoon, Integer> {
    public Persoon findPersoonByEmailadress(String emailAddress);
    public  Persoon findById(int id);
}
