package turnBasedProgram;

import java.util.concurrent.TimeUnit;

public interface FormatMethods {
    static void pauseLine()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
