import javax.swing.*;

public class UIManager {

    private JFrame jFrame;
    private JPanel options;
    private JPanel data;

    public UIManager(String appName, int width, int height){
        jFrame = new JFrame();
        jFrame.setSize(width,height);
        jFrame.setTitle(appName);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void ShowUI(){

        jFrame.setVisible(true);
    }

}
