import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.net.MailManager;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.util.ArrayList;

public class GraphPanel{
    private static final Logger log = LogManager.getRootLogger();
    static DefaultCategoryDataset data;
    static JFreeChart jChart;
    private JFrame jFrame;
    ChartFrame chartFrame;

    public GraphPanel(){
        log.info("Creating Graph Window");
        data = new DefaultCategoryDataset();
        jChart = ChartFactory.createBarChart(
                "Species count in countries",
                "Country name",
                "Species count",
                data,
                PlotOrientation.VERTICAL,
                true, true, true
        );
        CategoryPlot plot = jChart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI/4.0));
        plot.setRangeGridlinePaint(Color.black);

        chartFrame = new ChartFrame("Species",jChart, true);
        chartFrame.setVisible(false);
        chartFrame.setSize(700,550);


    }

    public boolean isVisable(){
        return chartFrame.isVisible();
    }

    public void setVisable(boolean b){
        chartFrame.setVisible(b);
    }

    public void setData(ArrayList<Country> countries, int size){
        data.clear();
        for(int i = 0; i < size; i++){
            data.addValue(countries.get(i).getSpeciesCount(), "Species Count", countries.get(i).getCountryName());
            data.addValue(countries.get(i).getEndemicSpeciesCount(), "Endemic species Count", countries.get(i).getCountryName());
        }
        log.info("new data set");
    }



}
