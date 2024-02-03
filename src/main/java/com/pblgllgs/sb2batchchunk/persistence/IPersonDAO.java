package com.pblgllgs.sb2batchchunk.persistence;

import com.pblgllgs.sb2batchchunk.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDAO extends CrudRepository<Person,Long> {
}
