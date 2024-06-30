package com.cricket.app.services;

import lombok.Data;


/**
 * The class which will have the current ball state.
 */
@Data
public class BallState {
    
    String name;
    int run = 0;
    int wicket = 0;
}
