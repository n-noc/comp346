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
        network.start();

        Server server = new Server();
        server.start();

        Client client = new Client("sending");
        client.start();


        try {
            client.join();
            server.join();
            network.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Simulation finished");
    }
}

