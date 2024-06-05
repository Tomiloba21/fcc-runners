package com.tomiloba.runners.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

/**
 * @project runners
 * @Author <h3 style="color: green; padding: 0px;"> Tomiloba</h3>
 * @since 6/1/2024
 */
public record Run(

        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location)
{

    public Run{
        if (!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed on must be after Started on");
        }

    }
}
