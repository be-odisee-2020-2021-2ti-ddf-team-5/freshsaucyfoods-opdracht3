package be.odisee.team5.userapi.service;

import be.odisee.team5.userapi.domain.Persoon;

import java.util.List;


public interface PersoonService {
    public Persoon getPersoonDetailsById(int id);
    public int processPersoon(Persoon persoon);
    public void deletePersoon(int id);
    public List<Persoon> getAllPersonen();
}
