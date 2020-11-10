package com.cts.testAutomation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.testAutomation.entity.ApplicationDetails;

public interface AppDetailsDataRepository extends JpaRepository<ApplicationDetails, Integer>{

}
