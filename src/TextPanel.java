import javafx.scene.control.TextArea;

/**
 * Created by andrian on 9/13/16.
 */
//class for patern observer
class TextPanel extends TextArea implements FileChangeListener{
    @Override
    public void fileChange(String s) {
        this.setText(s);
    }
}
