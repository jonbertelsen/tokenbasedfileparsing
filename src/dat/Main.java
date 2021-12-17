package dat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public final static String START = "START";
    public final static String SLUT = "SLUT";
    public final static String ID = "ID";
    public final static String NAVN = "NAVN";


    public static void main(String[] args) {

        List<Kunde> kunderList = indlæsKunder("kunder.txt");
        udskrivKunder(kunderList);
        gemKunder(kunderList, "kunder.txt");

    }

    private static List<Kunde> indlæsKunder(String filnavn)
    {
        List<Kunde> kundeListe = new ArrayList<>();

        File kundeFil = new File(filnavn);
        int id = 0;
        String navn = "";
        String linie = "";
        String token = "";

        try (Scanner scanner = new Scanner(kundeFil))
        {
            while (scanner.hasNext())
            {
                linie = scanner.nextLine();
                switch (linie)
                {
                    case START: token = START; break;
                    case ID: token = ID; break;
                    case NAVN: token = NAVN; break;
                    case SLUT: kundeListe.add(new Kunde(id, navn)); break;
                    default:
                        switch (token)
                        {
                            case ID: id = Integer.parseInt(linie); break;
                            case NAVN: navn = linie; break;
                        }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return kundeListe;
    }

    private static void gemKunder(List<Kunde> kunderList, String kundeFil)
    {
        try (PrintWriter writer = new PrintWriter(new File(kundeFil)))
        {
            for (Kunde kunde : kunderList)
            {
                writer.println(START);
                writer.println(ID);
                writer.println(kunde.getId());
                writer.println(NAVN);
                writer.println(kunde.getNavn());
                writer.println(SLUT);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    private static void udskrivKunder(List<Kunde> kunderList)
    {
        for (Kunde kunder : kunderList)
        {
            System.out.println(kunder.toString());
        }
    }
}
