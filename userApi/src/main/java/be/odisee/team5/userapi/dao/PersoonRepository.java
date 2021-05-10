package be.odisee.team5.userapi.dao;


public interface PersoonRepository extends org.springframework.data.repository.CrudRepository<be.odisee.team5.userapi.domain.Persoon, Long> {
    public be.odisee.team5.userapi.domain.Persoon findPersoonByEmailadress(String emailAddress);
}
