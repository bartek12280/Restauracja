import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        Zamowienia zamowienia = new Zamowienia();
        PersonelPracujacy pracownicy = new PersonelPracujacy();
        Scanner scan = new Scanner(System.in);
        int wybor;
        System.out.println("-----R-E-S-T-A-U-R-A-C-J-A-----\n");
        while (true) {
            System.out.println("""
                    1. Menu.
                    2. Zamówienia.
                    3. Pracownicy.
                    4. Rozpocznij pracę restauracji.
                    5. Zatrzymaj pracę restauracji.
                    6. Wyłącz program.
                    """);
            wybor = scan.nextInt();
            switch (wybor) {

                case 1 -> {
                    System.out.println("""
                            -----M-E-N-U-----
                            1. Wyświetl menu.
                            2. Dodaj danie do menu.
                            3. Usuń danie z menu.
                            4. Zapisz menu do pliku.
                            5. Wczytaj menu w pliku.
                            6. Oznacz danie jako dostepne/niedostepne.
                            7. Powrót.
                                                        
                            """);
                    wybor = scan.nextInt();
                    switch (wybor) {
                        case 1 -> {
                            menu.pokazMenu();
                        }
                        case 2 -> {
                            menu.dodajPozycje();
                        }
                        case 3 -> {
                            menu.usunPozycje();
                        }
                        case 4 -> {
                            menu.zapiszMenu();
                        }
                        case 5 -> {
                            menu.wczytajMenu();
                        }
                        case 6 -> {
                            menu.oznaczDostepnosc();
                        }
                        case 7 -> {
                            System.out.println("Powrót do ekranu głównego.");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("""
                            -----Z-A-M-O-W-I-E-N-I-A-----
                            1. Złóż zamówienie.
                            2. Złóż losowe zamówienie.
                            3. Wyświetl zamówienia do zrealizowania.
                            4. Wyświetl zrealizowane zamówienia.
                            5. Powrót.
                            """);
                    wybor = scan.nextInt();
                    switch (wybor) {
                        case 1 -> {
                            zamowienia.zlozZamowienie();
                        }
                        case 2 -> {
                            zamowienia.zlozLosoweZamowienie();
                        }
                        case 3 -> {
                            zamowienia.pokazZamowieniaDoRealizacji();
                        }
                        case 4 -> {
                            zamowienia.pokazZamowieniaZrealizowane();
                        }
                        case 5 -> {
                            System.out.println("Powrót do ekranu głównego.");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("""
                            -----P-R-A-C-O-W-N-I-C-Y-----
                            1. Dodaj pracownika.
                            2. Wyrzuć pracownika.
                            3. Wyświetl informację o pracowniku.
                            4. Wyświetl informacje o wszystkich pracownikach.
                            5. Powrót.
                            """);
                    wybor = scan.nextInt();
                    switch (wybor) {
                        case 1 -> {
                            pracownicy.dodajPracownika();
                        }
                        case 2 -> {
                            pracownicy.usunPracownika();
                        }
                        case 3 -> {
                            pracownicy.usunPracownika();
                        }
                        case 4 -> {
                            pracownicy.pokazPracownikow();
                        }
                        case 5 -> {
                            System.out.println("Powrót do ekranu głównego.");
                        }
                    }
                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {
                    break;
                }
            }
        }
    }
}