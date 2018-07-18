package com.steereengineering.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.steereengineering.model.PhoneList;

public interface PhoneListRepository extends JpaRepository<PhoneList, Long> {
	@Query(value = "select * from phone_list order by firstname", nativeQuery = true)
	 public List<PhoneList> getOrderByFirstname();
}
