import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.apache.logging.log4j.*;

public class UIManager{
    private static final Logger log = LogManager.getRootLogger();

    protected JFrame jFrame;
    protected JPanel buttonsPanel;
    protected JPanel sliderPanel;
    protected JPanel dataPanel;
    protected JTable table;
    protected JScrollPane scrollPane;
    protected JButton showDataButton;
    protected JButton showGraphButton;
    protected JComboBox comboBox;
    protected JSlider jSlider;
    protected JLabel jLabel;
    protected ArrayList<Country> countries;
    protected sortType sortBy = sortType.ALPHABETICALLY;

    private String[] columnNames = {"Country", "Species Count", "Endemic species count"};

    public UIManager(String appName, int width, int height){


        jFrame = new JFrame();
        jFrame.setSize(width,height);
        jFrame.setTitle(appName);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);

        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(0,0, width, height*1/10);
        buttonsPanel.setBackground(Color.BLUE);
        jFrame.add(buttonsPanel);

        sliderPanel = new JPanel();
        sliderPanel.setBounds(0,height*1/10,width,height*2/10);
        sliderPanel.setBackground(Color.GRAY);
        sliderPanel.setLayout(new BorderLayout());
        jFrame.add(sliderPanel);

        dataPanel = new JPanel();
        dataPanel.setBounds(0, height*3/10, width, height*7/10);
        dataPanel.setBackground(Color.GREEN);
        dataPanel.setLayout(new BorderLayout());
        jFrame.add(dataPanel);

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
        buttonsPanel.add(comboBox);

        showDataButton = new JButton();
        showDataButton.setText("Sort Data");
        //showDataButton.setBounds(200, 100, 100, 200);
        buttonsPanel.add(showDataButton, BorderLayout.NORTH);

        showGraphButton = new JButton();
        showGraphButton.setText("Show data on graph");
        buttonsPanel.add(showGraphButton, BorderLayout.NORTH);

        jLabel = new JLabel("Current value: 10");
        jLabel.setVerticalAlignment(JLabel.TOP);
        sliderPanel.add(jLabel);

        jSlider = new JSlider(JSlider.HORIZONTAL, 10, 246, 30);
        jSlider.setMajorTickSpacing(5);
        jSlider.setPreferredSize(new Dimension(300, 40));
        //sliderPanel.add(jSlider);



        log.info("GUI created successfully");

    }

    public void AddTable(){
        log.info("Creating data table");

        Object[][] emptyTableData = new Object[countries.size()][columnNames.length];

        table = new JTable(emptyTableData, columnNames);
        table.setBounds(0,0,jFrame.getWidth()-20,jFrame.getHeight() * 3/5-20);
        scrollPane = new JScrollPane(table);
        //scrollPane.setSize(jFrame.getWidth(), jFrame.getHeight()*3/5-100);

        dataPanel.add(scrollPane, BorderLayout.SOUTH);
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
