package com.cricket.app.listener;

import com.cricket.app.Event;
import com.cricket.app.exceptions.ServiceException;

public interface StreamListener {
    
    public void handle(Event event) throws ServiceException;
}
