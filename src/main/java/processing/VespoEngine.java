package processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VespoEngine {

    private static String[] command;

    public VespoEngine(String[] command) {
        VespoEngine.command = command;
    }

    public void exec() throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(command);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }

    }
    
    public static void encodeMP4() throws IOException {
        VespoEngine vb = new VespoEngine(new String[]{"./ffmpeg/bin/ffmpeg.exe "});
        vb.exec();
    }

}
