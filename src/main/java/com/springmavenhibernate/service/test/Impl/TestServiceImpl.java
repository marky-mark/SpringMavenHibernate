package com.springmavenhibernate.service.test.Impl;

import com.springmavenhibernate.domain.entity.Test;
import com.springmavenhibernate.domain.exception.TestNotFoundException;
import com.springmavenhibernate.repository.test.TestRepository;
import com.springmavenhibernate.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: markkelly
 * Date: 25/08/2011
 * Time: 07:49
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public final class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public boolean exists(Long id) {
        return testRepository.exists(id);
    }

    @Override
    public Test getById(Long id) {
        Test entry = testRepository.findOne(id);
        if (entry != null) {
            return entry;
        }
        throw new TestNotFoundException(id);
    }

    @Override
    public void setName(Long id, String name) {

        try {
            Test entry = testRepository.findOne(id);
            entry.setName(name);
        }
        catch (TestNotFoundException e) {
            System.out.println("Exception Thrown it was not found you idiot");
        }
    }

    @Override
    public Test add(String name) {
        Test entry = new Test();
        entry.setName(name);
        testRepository.save(entry);
        return entry;
    }

    @Override
    public void remove(Long id) {
        testRepository.delete(id);
    }
}
