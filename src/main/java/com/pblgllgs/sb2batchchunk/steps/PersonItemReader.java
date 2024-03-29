package com.pblgllgs.sb2batchchunk.steps;
/*
 *
 * @author pblgl
 * Created on 03-02-2024
 *
 */

import com.pblgllgs.sb2batchchunk.entities.Person;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;

public class PersonItemReader extends FlatFileItemReader<Person> {

    public PersonItemReader() {
        setName("readPersons");
        setResource(new ClassPathResource("persons.csv"));
        setLinesToSkip(1);
        setEncoding(StandardCharsets.UTF_8.name());
        setLineMapper(getLineMapper());
    }

    private LineMapper<Person> getLineMapper() {
        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        String []columns = new String []{"name","lastname","age"};
        int [] indexFields =  new int[] {0,1,2};

        lineTokenizer.setNames(columns);
        lineTokenizer.setIncludedFields(indexFields);
        lineTokenizer.setDelimiter(",");

        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Person.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }


}
