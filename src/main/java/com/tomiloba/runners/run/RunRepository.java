package com.tomiloba.runners.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @project runners
 * @Author <h3 style="color: green; padding: 0px;"> Tomiloba</h3>
 * @since 6/1/2024
 */

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();



    Optional<Run> findById(Integer id){
        return runs.stream()
                .filter(run -> run.id() ==id)
                .findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    List<Run> findAll(){
        return runs;
    }

    void  update(Run run, Integer id){
        Optional<Run > existingRun = findById(id);

        if (existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete (Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }


    @PostConstruct
    private void init(){
        runs.add(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),

                LocalDateTime.now().plusMinutes(30),
                3,
                Location.INDOOR
        ));

        runs.add(new Run(2,
                "Wednesday Evening Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                3,
                Location.INDOOR
        ));


    }
}
