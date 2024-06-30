package com.cricket.app.services.impl;

import com.cricket.app.exceptions.ServiceException;
import com.cricket.app.services.ScoreBoard;
import com.google.gson.JsonObject;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ScoreBoardImpl implements ScoreBoard {
    
    
    private  ConcurrentSkipListMap<Double, Integer> runMap ;
    private  ConcurrentHashMap<Double, Boolean> wicketMap ;
    
    /**
     * Description:
     *
     * @param jsonObject
     * @return
     * @throws ServiceException
     */
    public void process(JsonObject jsonObject) throws ServiceException{
    
    }
}
