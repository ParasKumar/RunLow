package com.runlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.runlow.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
	/*Spring Data will pass method parameters to the query in the same order they appear in the method declaration
	 * 
	 * Note : for more info about @Query visit : http://www.baeldung.com/spring-data-jpa-query
	 * Alternative way for below method is as : 
	 *  @Query(	value = "SELECT * FROM driver d WHERE d.user_id = :user_id", nativeQuery = true)
	 *	Driver findDriverByUserId(@Param("user_id")Integer userId);
	 * */
	@Query(	value = "SELECT * FROM driver d WHERE d.user_id = ?1", nativeQuery = true)
	Driver findDriverByUserId(Integer userId);

}
