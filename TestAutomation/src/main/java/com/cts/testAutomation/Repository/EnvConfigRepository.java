package com.cts.testAutomation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.testAutomation.entity.EnvDetails;

public interface EnvConfigRepository extends JpaRepository<EnvDetails,Integer>{

	EnvDetails findByEnvId(int envId);

}
