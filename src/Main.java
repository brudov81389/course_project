import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Get the log instance
        Log log = Log.getInstance();
        log.write(LOG_CODE.INFO, "Hello and welcome!\n");

        Party restaurant = new Party(log);
        // Call party method
        restaurant.startParty();
        restaurant.finishParty();
        restaurant.calculateTips();
        // Close the log file and finish writing
        log.close();
    }
}