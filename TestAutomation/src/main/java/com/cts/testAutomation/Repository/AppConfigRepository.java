package com.cts.testAutomation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.testAutomation.entity.ApplicationDetails;

public interface AppConfigRepository extends JpaRepository<ApplicationDetails,Integer>{

	ApplicationDetails findByAppId(int id);

}
