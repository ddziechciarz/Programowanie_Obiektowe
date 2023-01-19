import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        SatBeams satBeams = new SatBeams("https://satbeams.com/satellites?status=active");
        satBeams.PrintData();
    }
}