package com.tomiloba.runners.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
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


//    private static final Logger log = LoggerFactory.getLogger(RunRepository.class);

    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll(){
        return jdbcClient.sql("select * from run")
                .query(Run.class)
                .list();
    }
}
