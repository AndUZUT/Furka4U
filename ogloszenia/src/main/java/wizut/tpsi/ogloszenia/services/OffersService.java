
package wizut.tpsi.ogloszenia.services;

import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import wizut.tpsi.ogloszenia.jpa.BodyStyle;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;
import wizut.tpsi.ogloszenia.jpa.FuelType;
import wizut.tpsi.ogloszenia.jpa.Offer;
import wizut.tpsi.ogloszenia.jpa.OfferFilter;


@Service
@Transactional
public class OffersService {

    @PersistenceContext
    private EntityManager em;

        
    public CarManufacturer getCarManufacturer(int id) {
        return em.find(CarManufacturer.class, id);
    }
    
    public CarModel getModel(int id) {
        return em.find(CarModel.class, id);
    }

    public List<CarManufacturer> getCarManufacturers() {
    String jpql = "select cm from CarManufacturer cm order by cm.name";
    TypedQuery<CarManufacturer> query = em.createQuery(jpql, CarManufacturer.class);
    List<CarManufacturer> result = query.getResultList();
    return result;
    
    
    //return em.createQuery("select cm from CarManufacturer cm order by cm.name", CarManufacturer.class).getResultList();
}
    
    public List<BodyStyle> getBodyStyles() {
    String jpql = "select bs from BodyStyle bs order by bs.name";
    TypedQuery<BodyStyle> query = em.createQuery(jpql, BodyStyle.class);
    List<BodyStyle> result = query.getResultList();
    return result;
    
   
}
    
    public List<FuelType> getFuelTypes() {
    String jpql = "select ft from FuelType ft order by ft.name";
    TypedQuery<FuelType> query = em.createQuery(jpql, FuelType.class);
    List<FuelType> result = query.getResultList();
    return result;
    
}
    
    
    public List<CarModel> getCarModels() {
        String jpql = "select cm from CarModel cm order by cm.manufacturer.name";

        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
 
        return query.getResultList();
}
    
    
    public List<Offer> getOffers(){
        
        String jpql = "select offers from Offer offers";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        return query.getResultList();
    }
    
    public List<Offer> getOffersByModel(int modelId){
    
        String jpql = "select offers from Offer offers where offers.model.id = :id order by offers.title";

        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", modelId);

        return query.getResultList();
         
    }
    
    public List<Offer> getOffersByManufacturer(int manufacturerId){
    
        String jpql = "select offers from Offer offers where offers.model.manufacturer.id = :id order by offers.title";

        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", manufacturerId);

        return query.getResultList();
         
    }
    
    
    public List<CarModel> getCarModelsByManufacturer(int manufacturerId){
        String jpql = "select cm from CarModel cm where cm.manufacturer.id = :id order by cm.name";

        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
        query.setParameter("id", manufacturerId);
        return query.getResultList();
    }
    
    
    public Offer getOffer(int id) {
        return em.find(Offer.class, id);
    }
    
    


    public Offer createOffer(Offer offer) {
    em.persist(offer);
    return offer;
    }
    
    public List<Offer> getOffers (OfferFilter filter){
        
        String jpql = "select offers from Offer offers where ";
        if(filter.getModelId() != null)
        {
            jpql = jpql + "offers.model.id = :id1 and ";
        }
        if(filter.getManufacturerId() != null)
        {
            jpql = jpql + "offers.model.manufacturer.id = :id2 and ";
        }
        if(filter.getFuelTypeId() != null)
        {
            jpql = jpql + "offers.fuelType.id = :fuelTypeId and ";
        }
        if (filter.getYearMax() != null)
        {
            jpql = jpql + "offers.year <= :yearTo and ";
        }
        if (filter.getYearMin() != null)
        {
            jpql = jpql + "offers.year >= :yearFrom order by offers.title";
        }
        else
        {
            jpql = jpql + "offers.year >= 1980 order by offers.title";
        }
        
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        
        if(filter.getModelId() != null)
        {
            query.setParameter("id1", filter.getModelId());
        }
        if(filter.getManufacturerId() != null)
        {
            query.setParameter("id2", filter.getManufacturerId());
        }
        if(filter.getFuelTypeId() != null)
        {
            query.setParameter("fuelTypeId", filter.getFuelTypeId());
        }
        if(filter.getYearMax() != null)
        {
            query.setParameter("yearTo", filter.getYearMax());
        }
        if(filter.getYearMin() != null)
        {
            query.setParameter("yearFrom", filter.getYearMin());
        }

        return query.getResultList();
    }
    
    public Offer deleteOffer(Integer id) {
        Offer offer = em.find(Offer.class, id);
        em.remove(offer);
        return offer;
    }
    
    public Offer saveOffer(Offer offer) {
    return em.merge(offer);
}
   
}
