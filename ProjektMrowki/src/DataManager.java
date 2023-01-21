import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class DataManager extends UIManager implements ActionListener {

    private final String countryListURL = "https://www.antwiki.org/wiki/Diversity_by_Country";
    public DataManager(String appName, int width, int height){
        super(appName, width, height);
        countries = new ArrayList<Country>();

        showDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortData(sortBy);
                FillTable();
            }
        });
    }

    public void DownloadCountriesWithSpeciesNumber(){
        String country;
        int species, endemic;
        try{
            final Document document = Jsoup.connect(countryListURL).get();
            Element table = document.select("table").first();
            ArrayList<Element> rows = table.select("tr");

            for(int i = 1; i < rows.size(); i++){
                country = rows.get(i).select("td:eq(0)").text();
                species = Integer.valueOf(rows.get(i).select("td:eq(6)").text());
                endemic = Integer.valueOf(rows.get(i).select("td:eq(7)").text());

                countries.add(new Country(country, species, endemic));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void SortData(sortType type){
        if(type == sortType.SPECIES){
            Collections.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country o1, Country o2) {
                    return Integer.valueOf(o2.getSpeciesCount()).compareTo(o1.getSpeciesCount());
                }
            });
        }
        else if(type == sortType.ENDEMIC){
            Collections.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country o1, Country o2) {
                    return Integer.valueOf(o2.getEndemicSpeciesCount()).compareTo(o1.getEndemicSpeciesCount());
                }
            });

        }
        else if(type == sortType.ALPHABETICALLY){
            Collections.sort(countries, new Comparator<Country>() {
                @Override
                public int compare(Country o1, Country o2) {
                    return o1.getCountryName().compareTo(o2.getCountryName());
                }
            });
        }
        else{
            System.out.println("Wrong argument passed as a key to sort by");
        }
    }

    public void DisplayData(){
        for(Country country : countries){
            country.DisplayData();
        }
    }

    public ArrayList<Country> GetData(){
        return countries;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==showDataButton){
            System.out.println("button pressed");
        }
    }
}
