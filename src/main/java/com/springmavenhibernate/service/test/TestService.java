package com.springmavenhibernate.service.test;

import com.springmavenhibernate.domain.entity.Test;

/**
 * Created by IntelliJ IDEA.
 * User: markkelly
 * Date: 25/08/2011
 * Time: 07:48
 * To change this template use File | Settings | File Templates.
 */
public interface TestService {

    boolean exists(Long id);

    Test getById(Long id);

    void setName(Long id, String name);

    Test add(String name);

    void remove(Long id);
}
