import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadWriteFiles {
    private String path;
    private String content;

    private String contentOutput;

    public ReadWriteFiles() {
    }

    public void chooseFilePath() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            this.path = selectedFile.getAbsolutePath();
            this.content = Files.readString(Path.of(path));
        }
    }

    public void chooseFilePathWrite() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            this.path = selectedFile.getAbsolutePath() + ".txt";
            writeFile(path);
        }
    }


    public String getContent() {
        return content;
    }

    public String getContentOutput() {
        return contentOutput;
    }

    public void writeFile(String path) {
        try {
            Files.deleteIfExists(Paths.get(path));
            Files.write(Paths.get(path), this.content.getBytes(), StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public String getPath() {
        if(path == null){
            path = " ";
        }
        return path;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContentOutput(String content) {
        this.contentOutput = content;
    }

}