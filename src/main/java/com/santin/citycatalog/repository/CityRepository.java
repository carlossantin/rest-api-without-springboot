package com.santin.citycatalog.repository;

import com.santin.citycatalog.dto.CityDto;
import com.santin.citycatalog.entity.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public City add(City city) {
        return this.entityManager.merge(city);
    }

    @Transactional
    public void update(CityDto cityDto) {
        City city = this.findById(cityDto.getId());
        logger.info("Updating city from {} to {}", city, cityDto);
        city.setName(cityDto.getName());

        this.entityManager.persist(city);
    }

    public List<City> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM City c");
        return (List<City>)query.getResultList();
    }

    public City findById(Long id) {
        return this.entityManager.find(City.class, id);
    }
}
