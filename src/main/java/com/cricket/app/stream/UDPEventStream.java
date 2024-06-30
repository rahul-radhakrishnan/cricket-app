package com.cricket.app.stream;

import com.cricket.app.Event;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEventStream extends EventStream {
    
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
