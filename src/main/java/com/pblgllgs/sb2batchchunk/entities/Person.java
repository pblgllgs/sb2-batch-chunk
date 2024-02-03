package com.pblgllgs.sb2batchchunk.entities;
/*
 *
 * @author pblgl
 * Created on 03-02-2024
 *
 */

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    @Column(name = "create_at")
    private String createAt;

}
