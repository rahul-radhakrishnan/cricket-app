package com.cricket.app.listener;

import com.cricket.app.Event;
import com.cricket.app.exceptions.ServiceException;
import com.cricket.app.model.MatchEvent;
import com.cricket.app.services.CricketMatchManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/***
 * The concrete class which handles the streams with the wicket details.
 */

public class WicketStreamListener implements StreamListener {
    
    private static final Logger logger = LoggerFactory.getLogger(WicketStreamListener.class);
    
    private CricketMatchManager matchManager;
    
    private ObjectMapper mapper = new ObjectMapper();
    
    
    /**
     * Constructor
     * @param matchManager
     */
    public WicketStreamListener(CricketMatchManager matchManager) {
        
        this.matchManager = matchManager;
    }
    
    @Override
    public void handle(Event event) throws ServiceException {
        
        try {
            
            MatchEvent matchEvent =
                    mapper.readValue(event.getMessage(), MatchEvent.class);
            matchManager.updateWicket(matchEvent);
        } catch (Exception ex) {
            logger.error(ex.toString(), ex);
            throw new ServiceException(ex);
        }
        
    }
}
