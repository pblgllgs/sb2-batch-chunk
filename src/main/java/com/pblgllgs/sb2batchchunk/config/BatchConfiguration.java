package com.pblgllgs.sb2batchchunk.config;
/*
 *
 * @author pblgl
 * Created on 02-02-2024
 *
 */

import com.pblgllgs.sb2batchchunk.entities.Person;
import com.pblgllgs.sb2batchchunk.steps.PersonItemProcessor;
import com.pblgllgs.sb2batchchunk.steps.PersonItemReader;
import com.pblgllgs.sb2batchchunk.steps.PersonItemWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public PersonItemReader personItemReader(){
        return new PersonItemReader();
    }

    @Bean
    public PersonItemWriter personItemWriter(){
        return new PersonItemWriter();
    }

    @Bean
    public PersonItemProcessor personItemProcessor(){return new PersonItemProcessor();}

    @Bean
    public Step readFile(){
        return stepBuilderFactory.get("readFile")
                .<Person, Person>chunk(10)
                .reader(personItemReader())
                .processor(personItemProcessor())
                .writer(personItemWriter())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(1);
        taskExecutor.setMaxPoolSize(5);
        taskExecutor.setQueueCapacity(5);
        return taskExecutor;
    }

    @Bean
    public Job job(){
        return jobBuilderFactory.get("readFileWithChunk")
                .start(readFile())
                .build();
    }
}
