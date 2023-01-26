import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class WebPage {

    protected String url;
    protected ArrayList<Satelite> satelites;

    protected WebPage(String url){
        this.url = url;
        satelites = new ArrayList<Satelite>();
        DownloadPage();
    }

    /**ArrayList<Setelite> satelity;

     dzielimy tabelę na wiersze, z każdego zczytujemy dane
     dla każdego wiersza w tablicy:
     satelity.add(new Satelite(paramtetry pobrane z tablict));
     return satelity;*/

    public abstract void DownloadPage();

    public ArrayList<Satelite> getSatelites(){
        return satelites;
    }

    public void PrintData(){
        for (Satelite sat : satelites){
            sat.PrintData();
        }
    }

    public void PrintData(int amount) {
        if(satelites.size() < amount){
            System.out.println("Error, not enough satelites stored");
            return;
        }
        for(int i = 0; i < amount; i++){
            satelites.get(i).PrintData();
        }
    }

    public void SortByPosition(){
        Collections.sort(satelites, new Comparator<Satelite>() {
            @Override
            public int compare(Satelite o1, Satelite o2) {
                return Float.valueOf(o2.GetPosiiton()).compareTo(o1.GetPosiiton());
            }
        });
    }

    public void SortByName(){
        Collections.sort(satelites, new Comparator<Satelite>() {
            @Override
            public int compare(Satelite o1, Satelite o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

}
