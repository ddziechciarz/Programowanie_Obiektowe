import java.io.*;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) throws IOException {
        Properties p = getProperties();

        int minValue = Integer.parseInt(p.getProperty("minValue"));
        int maxValue = Integer.parseInt(p.getProperty("maxValue"));
        int repeatMin = Integer.parseInt(p.getProperty("repeatMin"));
        int repeatMax = Integer.parseInt(p.getProperty("repeatMax"));
        int percent = Integer.parseInt(p.getProperty("percent"));

        double currentPercent = 0.;
        int correctTotal = 0;
        int attemptsTotal = 0;



        while (true) {
            if (attemptsTotal >= repeatMin) {
                if (currentPercent >= percent) {
                    System.out.printf("Congratulations! You achieved %d%%\n", Math.round(currentPercent));
                    break;
                }
                if (attemptsTotal > repeatMax) {
                    System.out.printf("Congratulations! You achieved %d%%\n", Math.round(currentPercent));
                    break;
                }
            }

            int n1 = randInt(minValue, maxValue), n2 = randInt(minValue, maxValue);
            System.out.printf("%d * %d = ", n1, n2);

            Scanner scanner = new Scanner(System.in);
            int answear = 0;
            try {
                answear = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException");
                System.exit(1);
            }

            if (answear == n1 * n2) { ++correctTotal; }
            ++attemptsTotal;
            currentPercent = (double)correctTotal / attemptsTotal * 100;
        }
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        File file = null;
        try {
            file = new File("setup.properties");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        if (!file.exists()) {

            properties.setProperty("minValue", "1");
            properties.setProperty("maxValue", "10");
            properties.setProperty("repeatMin", "10");
            properties.setProperty("repeatMax", "25");
            properties.setProperty("percent", "70");

            properties.store(new FileWriter("setup.properties"), "Multiplication Table settings");
        }

        FileReader reader = new FileReader(file);
        properties.load(reader);

        return properties;
    }

    private static int randInt(int min, int max) {
        Random rn = new Random();
        return rn.nextInt((max - min)) + min;
    }
}
