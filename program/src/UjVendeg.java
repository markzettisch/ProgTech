public class UjVendeg extends Vendeg {

    FelvetelSt felvesz;

    public UjVendeg(FelvetelSt felvesz) {
        this.felvesz = felvesz;
    }
    @Override
    public void Rogzit() {
        felvesz.Rogzites();
    }
}
