package Sockets;

import MVC.Controller;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Created by JordanHope on 3/18/2016.
 */
public class Server {

    private Executor theExecutor = Executors.newCachedThreadPool();
    private Controller theController = new Controller();

    public static void main(String[] args) {
            Server theServer = new Server();
            theServer.start();
        }
        private void start(){
            theController.mapCommand("Speak", new SpeakHandler());
            try {
                //a socket opened on the specified port
                //Port number does have to match between the server and the Client. I'll be using 8006.
                ServerSocket aListeningSocket = new ServerSocket(8006);
                while(true){
                    //wait for a connection
                    System.out.println("Waiting for client connection request.");
                    final Socket clientSocket = aListeningSocket.accept();
                    //shorthand for a runnable
                    this.theExecutor.execute(() -> {
                        try {
                            //This will be looking for the json stream from he client
                            JSONInputStream inFromClient = new JSONInputStream(clientSocket.getInputStream());
                            //This is the json that will be sent back.
                            JSONOutputStream outToClient = new JSONOutputStream(clientSocket.getOutputStream());

                            System.out.println("The Client has yet to make a request");
                            //this is taking the json from the client and insert it into a hashmap
                            HashMap aRequest = (HashMap) inFromClient.readObject();
                            aRequest.put("toClient", outToClient);

                            String aCommand = (String) aRequest.get("command");
                            theController.handleRequest(aCommand, aRequest);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
