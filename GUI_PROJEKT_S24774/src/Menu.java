import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Dostepnosc {
    DOSTEPNE, NIEDOSTEPNE
}


public class Menu {

    Scanner scan = new Scanner(System.in);
    List<Danie> kartaMenu = new ArrayList<>();
    File sciezka = new File("C://Users//barte//IdeaProjects//GUI_PROJEKT_S24774/Menu.txt");

    Danie danie1 = new Danie(1, "Żeberka z fasolką BBQ", "Pyszne żeberka z fasolką BBq", 35, Dostepnosc.DOSTEPNE);
    Danie danie2 = new Danie(2, "Spaghetti Carbonara", "potrawa kuchni włoskiej złożona z makaronu, jajek, pancetty lub guanciale, sera pecorino romano lub parmezanu oraz czarnego pieprzu.", 25, Dostepnosc.DOSTEPNE);
    Danie danie3 = new Danie(3, "Placek po węgiersku", " znana i lubiana u nas potrawa. To nic innego jak połączenie chrupiących placków ziemniaczanych z gulaszem.", 23, Dostepnosc.DOSTEPNE);
    Danie danie4 = new Danie(4, "Lasagne Bolognese", "Oryginalna włoska Lasagne Bolognese z sosem mięsno-warzywnym, parmezanem i sosem beszamelowym.", 25, Dostepnosc.DOSTEPNE);
    Danie danie5 = new Danie(5,     "Ryż z warzywami", "smażony ryż z warzywami. Idealny dla wegetarian.", 20, Dostepnosc.DOSTEPNE);

    public Menu() {
        kartaMenu.add(danie1);
        kartaMenu.add(danie2);
        kartaMenu.add(danie3);
        kartaMenu.add(danie4);
        kartaMenu.add(danie5);
    }

    public void pokazMenu() {
        System.out.println(kartaMenu);

    }

    public void dodajPozycje() {
        System.out.println("podaj nazwe: ");
        String nazwa = scan.nextLine();
        System.out.println("podaj opis: ");
        String opis = scan.nextLine();
        System.out.println("podaj cene: ");
        int cena = scan.nextInt();
        scan.nextLine();
        int id = 1;

        try {


            while (id == kartaMenu.get(id - 1).getId()) {
                id++;
            }
        } catch (IndexOutOfBoundsException ignored) {
        }

        Danie danie = new Danie(id, nazwa, opis, cena, Dostepnosc.DOSTEPNE);
        kartaMenu.add(danie);
    }

    public void usunPozycje() {
        System.out.println("wybierz numer id dania do usuniecia.\n" +
                           "_________________________________");
        System.out.println(kartaMenu);
        int usun = scan.nextInt();
        scan.nextLine();
        kartaMenu.removeIf(danie -> danie.getId() == usun);
        System.out.println("Pomyslnie usunieto danie z karty.\n");
    }

    public void oznaczDostepnosc() {
        System.out.println("""
                co chcesz zrobic? Wybierz numer.
                1.oznacz jako dostepne.
                2.oznacz jako niedostepne.""");
        int wybor = scan.nextInt();
        System.out.println("Wybierz ID dania, które ma zostać oznaczone jako dostępne.");
        int wyborId = scan.nextInt();
        for (int i = 0; i < kartaMenu.size(); i++) {
            if (kartaMenu.get(i).getId() == wyborId) {
                kartaMenu.get(i).setDostepnosc(wybor);
            }
        }
    }

    public void zapiszMenu() {
        FileWriter fw;
        try {
            fw = new FileWriter(sciezka, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(kartaMenu.toString());
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wczytajMenu() {
    }
}

