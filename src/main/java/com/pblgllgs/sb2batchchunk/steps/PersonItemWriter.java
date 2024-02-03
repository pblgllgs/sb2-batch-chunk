package com.pblgllgs.sb2batchchunk.steps;
/*
 *
 * @author pblgl
 * Created on 03-02-2024
 *
 */

import com.pblgllgs.sb2batchchunk.entities.Person;
import com.pblgllgs.sb2batchchunk.service.IpersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class PersonItemWriter implements ItemWriter<Person> {

    @Autowired
    private IpersonService ipersonService;

    @Override
    public void write(List<? extends Person> list) throws Exception {
        list.forEach(Person::toString);
        ipersonService.saveAll((List<Person>) list);
    }
}
