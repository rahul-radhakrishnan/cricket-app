package com.cricket.app.stream;

import com.cricket.app.Event;
import com.cricket.app.exceptions.ServiceException;
import com.cricket.app.listener.RunStreamListener;
import com.cricket.app.listener.StreamListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * The interface for the Listener classes.
 *
 * @author rahul.r
 */
public abstract class EventStream {
    
    private static final Logger logger = LoggerFactory.getLogger(EventStream.class);
    
    
    List<StreamListener> listeners = new LinkedList<>();
    
    /**
     * Description:
     *
     * @return
     * @throws ServiceException
     */
    public abstract void start() throws ServiceException;
    
    
    public abstract void destroy() throws ServiceException;
    
    
    /**
     * Description:
     *
     * @return
     * @throws ServiceException
     */
    
    public void registerListener(StreamListener listener) {
        listeners.add(listener);
    }
    
    public void fireEvent(Event event) {
        listeners.forEach(listerner -> {
            try {
                listerner.handle(event);
            } catch (ServiceException e) {
                logger.error(e.getMessage(), e);
            }
        });
        
    }
}
