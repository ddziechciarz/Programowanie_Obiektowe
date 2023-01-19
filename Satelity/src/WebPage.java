import java.util.ArrayList;

public abstract class WebPage {

    protected String url;
    protected ArrayList<Satelite> satelites;

    protected WebPage(String url){
        this.url = url;
        satelites = new ArrayList<Satelite>();
    }

    /**ArrayList<Setelite> satelity;

     dzielimy tabelę na wiersze, z każdego zczytujemy dane
     dla każdego wiersza w tablicy:
     satelity.add(new Satelite(paramtetry pobrane z tablict));
     return satelity;*/

    public abstract void downloadPage();

    public abstract void PrintData();

}
