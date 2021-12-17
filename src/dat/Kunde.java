package dat;

public class Kunde
{
    private int id;
    private String navn;

    public Kunde(int id, String navn)
    {
        this.id = id;
        this.navn = navn;
    }

    public int getId()
    {
        return id;
    }

    public String getNavn()
    {
        return navn;
    }

    @Override
    public String toString()
    {
        return "Kunde{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                '}';
    }
}
