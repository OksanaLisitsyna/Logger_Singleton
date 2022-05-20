import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger instance = null;
    protected int num = 1;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String msg) {
        System.out.println("[" + new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(new Date()) + " " + num++ + "] " + msg);
    }
}
