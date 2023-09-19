package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryTest implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public QueryTest(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("findByCountry: "+regionRepository.findByCountry("Canada"));

        System.out.println("findByCountryContaining: "+regionRepository.findByCountryContaining("United"));

        System.out.println("getByCountryContainsOrderByRegionDesc: "+regionRepository.getByCountryContainsOrderByRegionDesc("United"));

        System.out.println("findTop2ByCountry: "+regionRepository.findTop2ByCountry("United States"));

        System.out.println("findTopByCountryContainsOrderByRegion: "+regionRepository.findTopByCountryContainsOrderByRegion("United States"));

        System.out.println("------------DEPARTMENT-----------");

        System.out.println("findByDepartment: "+departmentRepository.findByDepartment("Furniture"));

        System.out.println("getByDivision: "+departmentRepository.getByDivision("Health"));

        System.out.println("findByDivisionEndingWith: "+departmentRepository.findByDivisionEndingWith("ics"));

        System.out.println("getDistinctTop3ByDivisionContaining: "+departmentRepository.getDistinctTop3ByDivisionContaining("Hea"));



    }
}
