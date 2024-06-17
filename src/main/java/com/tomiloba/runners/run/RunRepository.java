package com.tomiloba.runners.run;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 * @project runners
 * @Author <h3 style="color: green; padding: 0px;"> Tomiloba</h3>
 * @since 6/17/2024
 */
public interface RunRepository extends ListCrudRepository<Run, Integer> {
    List<Run> findAllByLocation(String location);
}
