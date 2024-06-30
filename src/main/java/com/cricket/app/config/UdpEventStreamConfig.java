package com.cricket.app.config;


import com.cricket.app.listener.RunStreamListener;
import com.cricket.app.listener.WicketStreamListener;
import com.cricket.app.services.CricketMatchManager;
import com.cricket.app.stream.UDPEventStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/***
 * The configuration class which starts during the spring boot application bootup
 */
@Configuration
public class UdpEventStreamConfig {
    
    private static final Logger logger = LoggerFactory.getLogger(UdpEventStreamConfig.class);
    

    
    @Value("${sockets.ports}")
    String[] ports;
    
    @PostConstruct
    public void postConstruct() {
        logger.info("PostConstruct");
        CricketMatchManager matchManager = new CricketMatchManager();
    
        UDPEventStream runStream = new UDPEventStream(Integer.valueOf(ports[0]));
        runStream.registerListener(new RunStreamListener(matchManager));
        runStream.start();
    
    
        UDPEventStream wicketStream = new UDPEventStream(Integer.valueOf(ports[1]));
        wicketStream.registerListener(new WicketStreamListener(matchManager));
        wicketStream.start();
    }
    
}
