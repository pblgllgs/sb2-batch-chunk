package com.pblgllgs.sb2batchchunk.service;

import com.pblgllgs.sb2batchchunk.entities.Person;

import java.util.List;

public interface IpersonService {

    Iterable<Person> saveAll(List<Person> personList);
}
