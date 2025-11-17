package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Steps",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber.json",  // JSON report
                "junit:target/cucumber-reports/cucumber.xml", // JUnit XML report (TestNG compatible)
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", // Allure plugin for Cucumber 7.x
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
//        private VideoRecording recorder = new VideoRecording();
//
//        @BeforeTest
//        public void startRecording() {
//                try {
//                        String filePath = "C:\\Users\\Shahroze.Janjua\\IdeaProjects\\One_Window\\target\\output.mp4";
//                        recorder.startRecording(filePath);
//                        if (recorder.isRecording()) {
//                                System.out.println("Screen recording has started successfully.");
//                        } else {
//                                System.out.println("Failed to start screen recording.");
//                        }
//                } catch (IOException e) {
//                        System.out.println("Failed to start screen recording: " + e.getMessage());
//                }
//        }
//
//        @AfterTest
//        public void stopRecording() {
//                try {
//                        recorder.stopRecording();
//                        if (!recorder.isRecording()) {
//                                System.out.println("Screen recording stopped successfully.");
//                        } else {
//                                System.out.println("Failed to stop screen recording.");
//                        }
//                } catch (Exception e) {
//                        System.out.println("Failed to stop screen recording: " + e.getMessage());
//                }
//        }
//
//        @Test
//        public void testRecordingStatus() {
//                // This is just a basic test to verify if recording status can be checked.
//                if (recorder.isProcessAlive()) {
//                        System.out.println("FFmpeg process is alive and recording.");
//                } else {
//                        System.out.println("FFmpeg process is not running.");
//                }
//        }
}