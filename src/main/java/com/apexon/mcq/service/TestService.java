package com.apexon.mcq.service;
import com.apexon.mcq.entity.Test;
import com.apexon.mcq.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public Test createTest(Test test) {
        test.getSections().forEach(section -> section.setTest(test));
        return testRepository.save(test);
    }

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    public Optional<Test> getTestById(Long id) {
        return testRepository.findById(id);
    }
}


