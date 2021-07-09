package processing;

import java.io.File;
import java.io.IOException;

public class VideoProcessor {

    public VideoProcessor() {}

    public void cutInputFile() throws IOException {
        Runtime.getRuntime().exec("./ffmpeg/bin/ffmpeg.exe -i video.mp4 -i cut.mp4 -ss 00:00:00 -to 00:00:02 -c copy processedInput.mp4");
    }

    public void mergeClips() throws IOException {
        Runtime.getRuntime().exec("./ffmpeg/bin/ffmpeg.exe  -f concat -safe 0 -i todo.txt -c copy output.mp4");
    }

    public static void mergeClipsStep() throws IOException, InterruptedException {
        System.out.println("Step 1");
        Runtime.getRuntime().exec("./ffmpeg/bin/ffmpeg.exe -i processedInput.mp4 -c copy -f mpegts input1.ts").waitFor();
        System.out.println("Step 2");
        Runtime.getRuntime().exec("./ffmpeg/bin/ffmpeg.exe -i cutInput.mp4 -c copy -f mpegts input2.ts").waitFor();
        System.out.println("Step 3");
        Runtime.getRuntime().exec("./ffmpeg/bin/ffmpeg.exe -i \"concat:input1.ts|input2.ts\" -c copy discord.mp4").waitFor();
        System.out.println("Finished merging.");
    }

    public void initStitch() throws IOException {
        Runtime.getRuntime().exec("./ffmpeg/bin/ffmpeg.exe -i cut.mp4 -ss 00:00:00 -to 00:00:10 -c copy cutInput.mp4");
    }

    public static void cleanUp() {
        File container = new File("./cutInput.mp4");
        container.delete();
        container = new File("./processedInput.mp4");
        container.delete();
    }

}
