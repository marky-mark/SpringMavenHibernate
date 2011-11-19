package com.springmavenhibernate.repository.test;

import com.springmavenhibernate.domain.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: markkelly
 * Date: 17/08/2011
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public interface TestRepository extends JpaRepository<Test, Long> {

}

