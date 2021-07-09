package processing;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class VideoRuntime {

    public synchronized static boolean processInput() {
        clearCanvas();
        return executeBatchfile();
    }

    private static void clearCanvas() {
        new File("./processing/sourcevideo.mov").delete();
        new File("./processing/input.mov").delete();
        new File("./processing/out.mp4").delete();
    }

    public static boolean executeBatchfile() {
        try {
            Runtime.getRuntime().exec("run.bat");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
