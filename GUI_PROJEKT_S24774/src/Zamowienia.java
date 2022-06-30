import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Zamowienia extends Menu {

    List<List<Object>> wszystkieZamowienia = new ArrayList();
    List<List<Object>> zrealizowaneZamowienia = new ArrayList();
    List<String> infoZamowienie = new ArrayList<>();
    List<Danie> zamowienie = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private Random random = new Random();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    private int wyborId;
    private int cena;
    private int numerStolika;
    private String adresDostawy;
    private String godzinaZamowienia;
    private String wyborKoniec;
    private StatusZamowienia statusZamowienia;
    private StatusZamowienia rodzajZamowienia;
    private boolean czyDodano = false;


    public void pokazZamowieniaDoRealizacji() {
        System.out.println(wszystkieZamowienia);
    }

    public void pokazZamowieniaZrealizowane() {
        System.out.println(zrealizowaneZamowienia);
    }

    public void zlozZamowienie() {
        while (true) {
            System.out.println("Wybierz ID dania z menu.");
            Menu menu = new Menu();
            menu.pokazMenu();
            wyborId = scan.nextInt();
            scan.nextLine();

            for (Danie danie : kartaMenu) {
                if (danie.getId() == wyborId) {
                    if (danie.getDostepnosc() == Dostepnosc.NIEDOSTEPNE) {
                        System.out.println("Danie jest niedostepne, prosze wybrac inne.");
                        czyDodano = false;
                        continue;
                    }
                    zamowienie.add(danie);
                    cena += danie.getCena();
                    czyDodano = true;
                }
            }
            System.out.println(czyDodano ? "Pomyślnie dodano danie do zamówienia. Twoje zamówienie to: " + zamowienie : "");


            System.out.println("Czy chcesz dodac kolejne danie do zamówienia? Jeśli tak, to wcisnij enter.\n" +
                               " W innym wypadku wpisz dowolny znak.\n" +
                               " Aktualna cena zamówienia to: " + cena);
            wyborKoniec = scan.nextLine();
            if (!wyborKoniec.equals("")) {

                System.out.println("""
                                                
                        """);
                System.out.println("Dokonano zamówienia. Cena: " + cena +
                                   "\nwybierz rodzaj zamowienia: " +
                                   "\n1.stacjonarne" +
                                   "\n2.dostawa");
                switch (scan.nextInt()) {
                    case 1 -> {
                        rodzajZamowienia = StatusZamowienia.STACJONARNE;
                        System.out.println("Podaj numer stolika");
                        numerStolika = scan.nextInt();
                        scan.nextLine();
                        infoZamowienie.add(String.valueOf(numerStolika));
                    }
                    case 2 -> {
                        scan.nextLine();
                        rodzajZamowienia = StatusZamowienia.DOSTAWA;
                        System.out.println("Podaj adres dostawy");
                        adresDostawy = scan.nextLine();
                        infoZamowienie.add(adresDostawy);
                    }
                }
                godzinaZamowienia = dtf.format(LocalDateTime.now());
                statusZamowienia = StatusZamowienia.DO_REALIZACJI;
                infoZamowienie.add(String.valueOf(statusZamowienia));
                infoZamowienie.add(String.valueOf(rodzajZamowienia));
                infoZamowienie.add(godzinaZamowienia);
                List<Object> collect = Stream.concat(zamowienie.stream(), infoZamowienie.stream())
                        .collect(Collectors.toList());
                wszystkieZamowienia.add(collect);
                System.out.println(collect);
                // posortujZamowienia();
                zamowienie.clear();
                cena = 0;
                break;
            }
        }
    }

    public void zlozLosoweZamowienie() {
        System.out.println("podaj ilość dań do zamówienia.");
        int wybor = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < wybor; i++) {
            int liczba = random.nextInt(kartaMenu.size());
            while (kartaMenu.get(liczba).getDostepnosc() == Dostepnosc.NIEDOSTEPNE) {
                liczba = random.nextInt(kartaMenu.size());
            }
            zamowienie.add(kartaMenu.get(liczba));
            cena += kartaMenu.get(i).getCena();
        }

            System.out.println("Dokonano zamówienia. Cena: " + cena +
                               "\nwybierz rodzaj zamowienia: " +
                               "\n1.stacjonarne" +
                               "\n2.dostawa");
            switch (scan.nextInt()) {
                case 1 -> {
                    rodzajZamowienia = StatusZamowienia.STACJONARNE;
                    System.out.println("Podaj numer stolika");
                    numerStolika = scan.nextInt();
                    scan.nextLine();
                    infoZamowienie.add(String.valueOf(numerStolika));
                }
                case 2 -> {
                    scan.nextLine();
                    rodzajZamowienia = StatusZamowienia.DOSTAWA;
                    System.out.println("Podaj adres dostawy");
                    adresDostawy = scan.nextLine();
                    infoZamowienie.add(adresDostawy);
                }
            }
            godzinaZamowienia = dtf.format(LocalDateTime.now());
            statusZamowienia = StatusZamowienia.DO_REALIZACJI;
            infoZamowienie.add(String.valueOf(statusZamowienia));
            infoZamowienie.add(String.valueOf(rodzajZamowienia));
            infoZamowienie.add(godzinaZamowienia);
            List<Object> collect = Stream.concat(zamowienie.stream(), infoZamowienie.stream())
                    .collect(Collectors.toList());
            wszystkieZamowienia.add(collect);
            System.out.println(collect);
            zamowienie.clear();
            cena = 0;
    }
}