package com.cricket.app.stream;

import com.cricket.app.Event;
import com.cricket.app.enums.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * The concrete class for the UDP Event Stream.
 */
public class UDPEventStream extends EventStream {
    
    private static final Logger logger = LoggerFactory.getLogger(UDPEventStream.class);
    
    
    int port;
    private Thread runThread;
    
    public UDPEventStream(int port) {
        this.port = port;
    }
    
    @Override
    public void start() {
        
        runThread = new Thread(() -> listenOnSocket());
        runThread.start();
    }
    
    @Override
    public void destroy() {
        //Control using flags
        runThread.interrupt();
    }
    
    
    private void listenOnSocket() {
        try (DatagramSocket socket = new DatagramSocket(port)) {
            byte[] buffer = new byte[1024];
            
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String data = new String(packet.getData(), 0, packet.getLength());
                
                Event event = new Event();
                event.setMessage(data);
                fireEvent(event);
            }
        } catch (BindException e) {
            logger.error(Messages.SOCKET_BIND_ERROR.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
    
    
}
