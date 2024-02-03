package com.pblgllgs.sb2batchchunk.steps;
/*
 *
 * @author pblgl
 * Created on 03-02-2024
 *
 */

import com.pblgllgs.sb2batchchunk.entities.Person;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonItemProcessor implements ItemProcessor<Person,Person> {
    @Override
    public Person process(Person person) throws Exception {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        person.setCreateAt(formatter.format(time));
        return person;
    }
}
