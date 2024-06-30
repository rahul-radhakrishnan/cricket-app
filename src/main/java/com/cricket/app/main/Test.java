package com.cricket.app.main;

import com.cricket.app.listener.RunStreamListener;
import com.cricket.app.listener.WicketStreamListener;
import com.cricket.app.services.CricketMatchManager;
import com.cricket.app.stream.UDPEventStream;

public class Test {
    
    public static void main(String[] args) {
    
        CricketMatchManager matchManager = new CricketMatchManager();
        
        UDPEventStream runStream = new UDPEventStream(12001);
        runStream.registerListener(new RunStreamListener(matchManager));
        runStream.start();
    
    
        UDPEventStream wicketStream = new UDPEventStream(12002);
        wicketStream.registerListener(new WicketStreamListener(matchManager));
        wicketStream.start();
        
        
    }
}
