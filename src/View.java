/**
 * Created by andrian on 9/13/16.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class View extends Application{
    private TextPanel textArea= new TextPanel();
    private VBox vbox=new VBox(textArea);
    private Button btn=new Button();
    private Scene scene = new Scene(vbox, 300, 250);
    private Process process1=new Process();
    private CustomFile viewText=new CustomFile();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("fileChanger");
        btn.setText("Save");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewText.setData(textArea.getText());
                process1.changeFile(viewText);
            }
        });

        vbox.getChildren().add(btn);

        primaryStage.setScene(scene);
        primaryStage.show();

        process1.start();
        process1.addListener(textArea);
        setTextArea();
    }

    private void setTextArea(){
        textArea.setText(process1.getActiveFile().getData());
    }
}
