package com.tomiloba.runners.run;

import org.springframework.stereotype.Component;

/**
 * @project runners
 * @Author <h3 style="color: green; padding: 0px;"> Tomiloba</h3>
 * @since 6/1/2024
 */
@Component
public class WelcomeMessage {

    public String getWelcomeMessage(){
        return "Welcome to spring Boot Application";
    }
}
