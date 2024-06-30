package com.cricket.app.services;

import com.cricket.app.exceptions.ServiceException;
import com.google.gson.JsonObject;

public interface ScoreBoard {
    
    
    /**
     * Description:
     *
     * @param jsonObject
     * @return
     * @throws ServiceException
     */
    public void process(JsonObject jsonObject) throws ServiceException;
}
