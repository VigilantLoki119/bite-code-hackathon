package com.cts.testAutomation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.testAutomation.entity.ApplicationDetails;

public interface AppConfigRepository extends JpaRepository<Integer, ApplicationDetails>{

	List<ApplicationDetails> saveAll(List<ApplicationDetails> appDetailsList);

}
