package com.cts.testAutomation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.testAutomation.entity.EnvDetails;

public interface EnvConfigRepository extends JpaRepository<Integer, EnvDetails>{

	List<EnvDetails> saveAll(List<EnvDetails> envDetailsList);

}
