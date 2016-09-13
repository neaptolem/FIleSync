/**
 * Created by andrian on 9/13/16.
 */
public class CustomFile{
    private String data;

    public CustomFile(){
        data="0";
    }

    public CustomFile(String data){
        this.data=data;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data=data;
    }
}
