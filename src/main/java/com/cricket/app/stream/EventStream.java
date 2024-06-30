package com.cricket.app.stream;

import com.cricket.app.Event;
import com.cricket.app.exceptions.ServiceException;
import com.cricket.app.listener.StreamListerner;

import java.util.LinkedList;
import java.util.List;

/**
 * The interface for the Listener classes.
 *
 * @author rahul.r
 */
public abstract class EventStream {
    
    List<StreamListerner> listeners = new LinkedList<>();
    
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
    
    public void registerListener(StreamListerner listener) {
        listeners.add(listener);
    }
    
    public void fireEvent(Event event) {
        listeners.forEach(listerner -> listerner.handle(event));
    }
}
