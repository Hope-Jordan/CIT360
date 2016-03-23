package Sockets;

import MVC.Handler;
import org.quickconnectfamily.json.JSONOutputStream;

import java.util.HashMap;

/**
 * Created by JordanHope on 3/20/2016.
 */
public class SpeakHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> dataMap){
        try {
            JSONOutputStream outToClient = (JSONOutputStream) dataMap.remove("toClient");
            //confirming the message from the client
            System.out.println("Just got: " + dataMap + " from client");
            //replacing the command "speak" with the done command to send the string back to the client
            dataMap.put("command", "Done");
            System.out.println("Responding to the Client");
            outToClient.writeObject(dataMap);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
