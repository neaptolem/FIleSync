import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Handler;

/**
 * Created by andrian on 9/13/16.
 */
public class FileController{
    private List<FileChangeListener> listener=new ArrayList<FileChangeListener>();
    private String fileName="sync.txt";
    private CustomFile archive;
    private CustomFile active;

    public FileController(){
        active=new CustomFile(readFromFile());
        archive=new CustomFile(readFromFile());
    }

    private boolean isChange(){
        return ! Objects.equals(archive.getData(),active.getData() );
    }

    //function for compare CustomFile
    public void compare(){
        active.setData(readFromFile());
        if (isChange()) backup();
    }

    //save active to archive file
    private void backup(){
        archive.setData(active.getData());
        changeViewFile(active.getData());
    }


    public void setActive(CustomFile file){
        active=file;
        writeToFile(file.getData());
    }

    public CustomFile getActive(){
        return active;
    }

    private  void writeToFile(String text){
        try {
            try (BufferedWriter writer=Files.newBufferedWriter(Paths.get(fileName))){
                writer.write(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile(){
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            return content;
        } catch (IOException e) {
            return archive.getData();
        }
    }

    //method for patern observer
    public void addListener(FileChangeListener toAdd){
        listener.add(toAdd);
    }

    //method for patern observer
    public void changeViewFile(String s){
        for(FileChangeListener item : listener)
            item.fileChange(s);
    }
}
