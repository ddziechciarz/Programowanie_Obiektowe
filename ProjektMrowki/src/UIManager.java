import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class UIManager {

    private JFrame jFrame;
    private JPanel options;
    private JPanel utilsPanel;
    private JPanel dataPanel;
    private JTable table;
    private JScrollPane scrollPane;

    private String[] columnNames = {"Country", "Species Count", "Endemic species count"};

    public UIManager(String appName, int width, int height){
        jFrame = new JFrame();
        jFrame.setSize(width,height);
        jFrame.setTitle(appName);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        utilsPanel = new JPanel();
        utilsPanel.setSize(width, 2/5*height);
        jFrame.add(utilsPanel, BorderLayout.SOUTH);

        dataPanel = new JPanel();
        dataPanel.setSize(width, 3/5*height);
        jFrame.add(dataPanel, BorderLayout.SOUTH);

    }

    public void AddTable(ArrayList<Country> data){

        table = new JTable(data.size(), columnNames.length);
        table.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight() * 3/5);
        scrollPane = new JScrollPane(table);
        dataPanel.add(scrollPane);


        FillTable(data);
    }

    public void FillTable(ArrayList<Country> data){
        for(int i = 0; i < data.size(); i++){
            table.setValueAt(data.get(i).getCountryName(), i, 0);
            table.setValueAt(data.get(i).getSpeciesCount(), i, 1);
            table.setValueAt(data.get(i).getEndemicSpeciesCount(), i, 2);
        }
    }


    public void ShowUI(){

        jFrame.setVisible(true);
    }

}
