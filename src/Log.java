import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

enum LOG_CODE {
    INFO, WARNING, ERROR
}

// Log class was created using Singleton pattern
public class Log {
    // Private static instance variable
    private static Log instance;
    private BufferedWriter writer;
    private final DateTimeFormatter formatObj;

    // Private constructor to prevent instantiation from outside
    private Log() {
        // Initialization code here
        formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        try {
            // Open a FileWriter in append mode
            writer = new BufferedWriter(new FileWriter("log.txt", true));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Public static method to get the instance of Log
    public static Log getInstance() {
        // Lazy initialization: create the instance only if it hasn't been created yet
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    // Public method to log an info message
    public void write(LOG_CODE code, String message) {
        // Get current date and time
        LocalDateTime dateTimeObj = LocalDateTime.now();
        // Format date time and convert to string
        String formattedDate = dateTimeObj.format(formatObj);
        // Log the message to file
        try {
            writer.write(String.format("[%s][%s]: %s", formattedDate, code, message));
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Public method to close the file writer
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
