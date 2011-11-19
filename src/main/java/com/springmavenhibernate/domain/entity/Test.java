package com.springmavenhibernate.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: markkelly
 * Date: 16/08/2011
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    public final String getName() {
        return name;
    }

    public final Long getId() {
        return id;
    }

    public final void setName(String name) {
        this.name = name;
    }
}
