
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class Driver {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Starting the Network Simulation");
    	
    	 /*******************************************************************************************************************************************
    	  * TODO : implement all the operations of main class - activate network and start client (sending & receiving) and server 																					*
    	  ******************************************************************************************************************************************/
        Network network = new Network("network");

        Server server = new Server();
        Client client = new Client("sending");

        Thread serverThread = new Thread(() -> server.run());
        Thread clientThread = new Thread(() -> client.run());

         
        serverThread.start();
        clientThread.start();

        try {
            clientThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
    }
        network.disconnect(network.getClientIP());

        try{
            serverThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
}
}
