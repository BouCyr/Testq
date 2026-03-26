import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LessonStorageService {
    private final String storageDirectory;

    public LessonStorageService(String classroomName) {
        this.storageDirectory = "src/main/resources/lessons/" + classroomName;
        createStorageDirectory();
    }

    private void createStorageDirectory() {
        try {
            Files.createDirectories(Paths.get(storageDirectory));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveLesson(String lessonId, String lessonContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(storageDirectory + "/" + lessonId + ".json"))) {
            writer.write(lessonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadLesson(String lessonId) {
        StringBuilder lessonContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(storageDirectory + "/" + lessonId + ".json"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lessonContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lessonContent.toString();
    }

    public void deleteLesson(String lessonId) {
        try {
            Files.deleteIfExists(Paths.get(storageDirectory + "/" + lessonId + ".json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}