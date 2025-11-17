package define;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ScreenRecorder {

    private Process process;
    private String ffmpegPath = "ffmpeg"; // Path to FFmpeg executable (make sure it's in your PATH)

    public void startRecording(String outputFile) throws IOException, InterruptedException {
        String command = String.format("%s -f gdigrab -framerate 120 -i desktop %s", ffmpegPath, outputFile);
        process = new ProcessBuilder(command.split(" ")).start();
//        process = Runtime.getRuntime().exec(command);

//        process.waitFor();
        System.out.println("Recording started");
    }

    public void stopRecording() throws IOException {
        if (process != null) {
            process.destroy();
            System.out.println("Recording stopped");
        }
    }
}
