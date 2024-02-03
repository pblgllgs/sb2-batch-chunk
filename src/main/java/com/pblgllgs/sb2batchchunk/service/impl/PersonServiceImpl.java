package com.pblgllgs.sb2batchchunk.service.impl;
/*
 *
 * @author pblgl
 * Created on 03-02-2024
 *
 */

import com.pblgllgs.sb2batchchunk.entities.Person;
import com.pblgllgs.sb2batchchunk.persistence.IPersonDAO;
import com.pblgllgs.sb2batchchunk.service.IpersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IpersonService {

    private final IPersonDAO iPersonDAO;
    @Override
    public Iterable<Person> saveAll(List<Person> personList) {
        return iPersonDAO.saveAll(personList);
    }
}
