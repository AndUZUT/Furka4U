package wizut.tpsi.ogloszenia.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;

@Service
public class OffersService {
    @PersistenceContext
    private EntityManager em;

    public CarManufacturer getCarManufacturer(int id) {
        return em.find(CarManufacturer.class, id);
    }
    
    public CarModel getModel(int id)
    {
        return em.find(CarModel.class, id);
    }
}
