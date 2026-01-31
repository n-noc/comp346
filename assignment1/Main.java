public class Main {

    public static void main(String[] args) {
    	
        System.out.println("Starting the Banking Application");
    	
        // start the network
        Network newtwork= new Network("network");
        newtwork.start();

        // start the server
        Server server=new Server();
        server.start();

        
    }
}
