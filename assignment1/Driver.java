import java.io.FileOutputStream;
import java.io.PrintStream;

public class Driver {

    public static void main(String[] args) {
        PrintStream out = null;

        try {
            String mode = (args.length > 0) ? args[0].trim().toLowerCase() : "sync";

            // change filenames to whatever PA1 requires
            String outFile = mode.equals("unsync") ? "pa1-unsynchronized.txt"
                                                  : "pa1-synchronized.txt";

            out = new PrintStream(new FileOutputStream(outFile));
            System.setOut(out);
            System.setErr(out);

            System.out.println("Starting the Network Simulation (mode=" + mode + ")");
            System.out.println("Writing output to: " + outFile);
            System.out.println();

            Network network = new Network("network");
            network.start();

            Server server = new Server();
            server.start();

            Client sender = new Client("sending");
            Client receiver = new Client("receiving");

            sender.start();
            receiver.start();

            sender.join();
            receiver.join();
            server.join();
            network.join();

            System.out.println();
            System.out.println("Simulation finished");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Driver interrupted: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}

