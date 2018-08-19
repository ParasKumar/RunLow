package com.runlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.runlow.model.Driver;

@Repository
public interface BookingRepository extends JpaRepository<Driver, Integer>{

}
