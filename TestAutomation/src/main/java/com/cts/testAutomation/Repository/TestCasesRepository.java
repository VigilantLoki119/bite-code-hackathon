package com.cts.testAutomation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.testAutomation.entity.TestCases;

public interface TestCasesRepository extends JpaRepository<TestCases, Integer> {

	List<TestCases> findByAppIdAndPageId(int appId,int pageId);
}
