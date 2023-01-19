import java.util.ArrayList;

public abstract class WebPage {

    String url;
    protected WebPage(String url){
        this.url = url;
    }

    /**ArrayList<Setelite> satelity;

     dzielimy tabelę na wiersze, z każdego zczytujemy dane
     dla każdego wiersza w tablicy:
     satelity.add(new Satelite(paramtetry pobrane z tablict));
     return satelity;*/

    public abstract ArrayList<Satelite> downloadPage();

    public abstract void PrintData();

}
