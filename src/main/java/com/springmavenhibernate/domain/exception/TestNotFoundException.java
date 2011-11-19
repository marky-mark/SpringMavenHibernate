package com.springmavenhibernate.domain.exception;

/**
 * Created by IntelliJ IDEA.
 * User: markkelly
 * Date: 25/08/2011
 * Time: 08:03
 * To change this template use File | Settings | File Templates.
 */
public final class TestNotFoundException extends RuntimeException{

    private Long id;

    public TestNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
