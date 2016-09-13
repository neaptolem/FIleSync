/**
 * Created by andrian on 9/13/16.
 */
public class Process extends Thread{
    private volatile FileController fCtrl=new FileController();

    public void run(){
        while(true){
            fCtrl.compare();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeFile(CustomFile file){
        fCtrl.setActive(file);
    }

    public CustomFile getActiveFile(){
        return fCtrl.getActive();
    }

    //method for patern observer
    public void addListener(FileChangeListener toAdd){
        fCtrl.addListener(toAdd);
    }

}
