public class Kuchnia extends Zamowienia {

    public boolean sprawdzZamowienia() {
        return wszystkieZamowienia.size() > 0;
    }

    public void wykonajZamowienie() throws InterruptedException {
        Thread.sleep(PersonelPracujacy.iloscKucharzy()*150);
        zrealizowaneZamowienia.add(wszystkieZamowienia.get(0));
        wszystkieZamowienia.remove(0);
    }
}
