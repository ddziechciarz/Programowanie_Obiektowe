import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphPanel extends JFrame {
    private static final Logger log = LogManager.getRootLogger();

    public GraphPanel(){
        log.info("Creating Graph Window");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(700, 400);
        this.setLayout(null);
        setResizable(false);
    }

}
