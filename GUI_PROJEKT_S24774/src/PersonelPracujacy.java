import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonelPracujacy {
    Scanner scan = new Scanner(System.in);
    static List<Pracownik> pracownicy = new ArrayList();
    Pracownik kucharz1 = new Pracownik("Jan", "Kowalski", "531972300", RodzajPracownika.KUCHARZ, 1);
    Pracownik kucharz2 = new Pracownik("Grzegorz", "Bąk", "671278996", RodzajPracownika.KUCHARZ, 2);
    Pracownik kelner1 = new Pracownik("Marek", "Karaś", "773278563", RodzajPracownika.KELNER, 3);
    Pracownik dostawca1 = new Pracownik("Filip", "Kucharczyk", "593568345", RodzajPracownika.DOSTAWCA, 4);


    public PersonelPracujacy() {
        pracownicy.add(kucharz1);
        pracownicy.add(kucharz2);
        pracownicy.add(kelner1);
        pracownicy.add(dostawca1);
    }

    public void pokazPracownikow() {
        System.out.println(pracownicy);
    }

    public void pokazPracownika(){}

    public void dodajPracownika() {
        System.out.println("podaj imie: ");
        String imie = scan.nextLine();
        System.out.println("podaj nazwisko: ");
        String naziwsko = scan.nextLine();
        System.out.println("podaj numer telefonu: ");
        String numerTelefonu = scan.nextLine();
        System.out.println("""
                Wybierz stanowisko pracownika:
                1.Kucharz
                2.Kelner
                3.Dostawca
                """);
        RodzajPracownika stanowisko;
        int wybor = scan.nextInt();
        scan.nextLine();
        switch (wybor) {
            case 1 -> stanowisko = RodzajPracownika.KUCHARZ;
            case 2 -> stanowisko = RodzajPracownika.KELNER;
            case 3 -> stanowisko = RodzajPracownika.DOSTAWCA;
            default -> throw new IllegalStateException("Podano zły numer.");
        }
        int id = 1;
        try {


            while (id == pracownicy.get(id - 1).getIdPracownika()) {
                id++;
            }
        } catch (IndexOutOfBoundsException ignored) {
        }

        Pracownik pracownik = new Pracownik(imie, naziwsko, numerTelefonu, stanowisko, id);
        pracownicy.add(pracownik);
    }

    public void usunPracownika() {
        pokazPracownikow();
        System.out.println("Wybierz id pracownika do usuniecia: ");
        int wybraneId = scan.nextInt();
        scan.nextLine();
        pracownicy.removeIf(pracownik -> pracownik.getIdPracownika() == wybraneId);
        System.out.println("Pomyślnie usunieto pracownika.");

    }

    public static int iloscKucharzy() {
        int pomocnicza = 0;
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.getRodzajPracownika().equals(RodzajPracownika.KUCHARZ))
                pomocnicza++;
        }
        return pomocnicza;
    }
}
