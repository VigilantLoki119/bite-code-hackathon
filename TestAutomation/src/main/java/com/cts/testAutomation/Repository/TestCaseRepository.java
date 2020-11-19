package com.cts.testAutomation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.testAutomation.entity.TestCase;

public interface TestCaseRepository extends JpaRepository<TestCase, Integer> {

	List<TestCase> findByAppIdAndPageId(int appId,int pageId);
	TestCase findByTestCaseId(int testCaseId); 
}
