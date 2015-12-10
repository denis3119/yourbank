package com.yourbank.data.model;

import com.yourbank.data.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Yugov Alexandr.
 */
@Entity
public class User implements Identifiable {

    @Id
    private Long id;

    @Column
    private Long age;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
