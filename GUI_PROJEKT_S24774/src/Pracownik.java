public class Pracownik {
    private String imie;
    private String nazwisko;
    private RodzajPracownika rodzajPracownika;
    private String numerTelefonu;
    private int idPracownika;
    public Pracownik(String imie, String nazwisko, String numerTelefonu, RodzajPracownika rodzajPracownika , int idPracownika){

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rodzajPracownika = rodzajPracownika;
        this.numerTelefonu = numerTelefonu;
        this.idPracownika = idPracownika;
    }

    public int getIdPracownika() {
        return idPracownika;
    }

    public RodzajPracownika getRodzajPracownika() {
        return rodzajPracownika;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
               "imie='" + imie + '\'' +
               ", nazwisko='" + nazwisko + '\'' +
               ", rodzajPracownika=" + rodzajPracownika +
               ", numerTelefonu='" + numerTelefonu + '\'' +
               ", idPracownika=" + idPracownika +
               '}';
    }
}
