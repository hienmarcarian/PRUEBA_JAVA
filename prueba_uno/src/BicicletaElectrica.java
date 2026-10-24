public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {
    private int autonomiaKm;
    private boolean bateriaCertificada;
    private boolean garantiaExtendidaActiva;

    public BicicletaElectrica() {
        super();
    }

    public BicicletaElectrica(String codigo, int anoFabricacion, double peso, int autonomiaKm, boolean bateriaCertificada) {
        super(codigo, anoFabricacion, peso);
        setAutonomiaKm(autonomiaKm);
        setBateriaCertificada(bateriaCertificada);
        this.garantiaExtendidaActiva = false;
    }

    public int getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(int autonomiaKm) {
        if (autonomiaKm <= 0) {
            throw new IllegalArgumentException("La autonomía debe ser mayor a cero");
        }
        this.autonomiaKm = autonomiaKm;
    }

    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }

    @Override
    public boolean tieneGarantiaExtendida() {
        return garantiaExtendidaActiva;
    }

    @Override
    public void activarGarantia() {
        this.garantiaExtendidaActiva = true;
    }

    @Override
    public double calcularCostoMantencion() {
        double costoBase = 45000.0;
        if (!bateriaCertificada) {
            costoBase *= 1.25; // Incremento del 25% si no está certificada
        }
        return costoBase;
    }
}