public class Danie {
    private int id;
    private String nazwa;
    private String opis;
    private int cena;
    private Dostepnosc dostepnosc;

    public Danie(int id, String nazwa, String opis, int cena, Dostepnosc dostepnosc) {
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
        this.dostepnosc = dostepnosc;
    }

    public void setDostepnosc(int n) {
        switch (n){
            case 1 -> this.dostepnosc = Dostepnosc.DOSTEPNE;
            case 2 -> this.dostepnosc = Dostepnosc.NIEDOSTEPNE;
            default -> {}
        }
    }

    @Override
    public String toString() {
        return "Danie{" +
               "id=" + id +
               ", nazwa='" + nazwa + '\'' +
               ", opis='" + opis + '\'' +
               ", cena=" + cena +
               ", dostepnosc=" + dostepnosc +
               '}';
    }

    public int getId() {
        return id;
    }

    public int getCena() {
        return cena;
    }

    public Dostepnosc getDostepnosc() {
        return dostepnosc;
    }
}
