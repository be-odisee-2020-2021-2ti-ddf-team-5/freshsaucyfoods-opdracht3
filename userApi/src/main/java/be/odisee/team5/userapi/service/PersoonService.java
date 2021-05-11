package be.odisee.team5.userapi.service;

import be.odisee.team5.userapi.domain.Persoon;


public interface PersoonService {
    public Persoon getPersoonDetailsById(int id);
    public int processPersoon(Persoon persoon);
    public void deletePersoon(int id);
}
