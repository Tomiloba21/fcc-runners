package com.tomiloba.runners.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * @project runners
 * @Author <h3 style="color: green; padding: 0px;"> Tomiloba</h3>
 * @since 6/1/2024
 */

@RestController
@RequestMapping("/api/runs")
public class RunController {


    private final RunRepository runRepository;


    public RunController(RunRepository runRepository){
        this.runRepository = runRepository;
    }


    @GetMapping("")
    List<Run> findAll(){
        return runRepository.findAll();
    }


    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);

        if (run.isEmpty()){
            throw new RunNotFoundException();
        }
        return run.get();

    }
    //Post

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run){
        runRepository.save(run);
    }

    //update

    //put

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.save(run);

    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete( @PathVariable Integer id){
        runRepository.delete(runRepository.findById(id).get());
    }


    @GetMapping("/Location/{location}")
    List<Run> findByLocation(@PathVariable String location){
        return runRepository.findAllByLocation(location);
    }
}
