import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import org.apache.logging.log4j.*;

public class UIManager{
    private static final Logger log = LogManager.getRootLogger();

    protected JFrame jFrame;
    protected JPanel utilsPanel;
    protected JPanel dataPanel;
    protected JTable table;
    protected JScrollPane scrollPane;

    protected JButton showDataButton;
    protected JButton showGraphButton;

    protected JComboBox comboBox;
    protected ArrayList<Country> countries;

    protected sortType sortBy = sortType.ALPHABETICALLY;

    private String[] columnNames = {"Country", "Species Count", "Endemic species count"};

    public UIManager(String appName, int width, int height){
        log.info("Creating GUI");

        jFrame = new JFrame();
        jFrame.setSize(width,height);
        jFrame.setTitle(appName);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        utilsPanel = new JPanel();
        utilsPanel.setSize(width, 2/5*height);
        jFrame.add(utilsPanel, BorderLayout.NORTH);

        String[] sorters = {"Alphabetical", "Species count", "Endemic species count"};
        comboBox = new JComboBox(sorters);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem() == sorters[0]){
                    sortBy = sortType.ALPHABETICALLY;
                }
                else if(comboBox.getSelectedItem() == sorters[1]){
                    sortBy = sortType.SPECIES;
                }
                else if(comboBox.getSelectedItem() == sorters[2]){
                    sortBy = sortType.ENDEMIC;
                }
                else{
                    log.info("Error while trying to change sorting type");
                }
                log.info("Changed sort type to " + sortBy);
            }
        });
        utilsPanel.add(comboBox);

        showDataButton = new JButton();
        showDataButton.setText("Sort Data");
        showDataButton.setBounds(200, 100, 100, 200);
        utilsPanel.add(showDataButton);

        dataPanel = new JPanel();
        dataPanel.setSize(width, 3/5*height);
        jFrame.add(dataPanel, BorderLayout.SOUTH);

    }

    public void AddTable(){
        log.info("Creating data table");

        Object[][] emptyTableData = new Object[countries.size()][columnNames.length];

        table = new JTable(emptyTableData, columnNames);
        table.setBounds(0,0,jFrame.getWidth(),jFrame.getHeight() * 3/5);
        scrollPane = new JScrollPane(table);
        dataPanel.add(scrollPane);
        table.setAutoCreateRowSorter(false);


        FillTable();
    }

    public void FillTable() {
        log.info("Filling a table with new data");
        for (int i = 0; i < countries.size(); i++) {
            table.setValueAt(countries.get(i).getCountryName(), i, 0);
            table.setValueAt(countries.get(i).getSpeciesCount(), i, 1);
            table.setValueAt(countries.get(i).getEndemicSpeciesCount(), i, 2);

        }
    }

    public void ShowUI(){

        jFrame.setVisible(true);
    }


}
