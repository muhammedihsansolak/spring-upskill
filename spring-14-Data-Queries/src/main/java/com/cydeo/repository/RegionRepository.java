package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    //display all regions in Canada
    List<Region> findByCountry(String country);
    List<Region> getByCountry(String country);

    //display all regions with country name if includes 'united'
    List<Region> findByCountryContaining(String country);

    //display all regions with country name if includes 'united' in order(region)
    List<Region> getByCountryContainsOrderByRegionDesc(String country);

    //display top 2 regions in 'United States'
    List<Region> findTopByCountry(String country);
    List<Region> findTop2ByCountry(String country);

    List<Region> findTopByCountryContainsOrderByRegion(String country);


}
