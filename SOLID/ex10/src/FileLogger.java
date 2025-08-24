import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileLogger implements Logger {
    private final String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            String logEntry = String.format("[%s] %s%n", 
                LocalDateTime.now(), message);
            writer.write(logEntry);
            System.out.println("[FileLogger] Logged to " + filePath + ": " + message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
