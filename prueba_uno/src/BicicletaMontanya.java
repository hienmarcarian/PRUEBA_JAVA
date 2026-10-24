public class BicicletaMontanya extends Bicicleta {
    private int cantidadSuspensiones;

    public BicicletaMontanya() {
        super();
    }

    public BicicletaMontanya(String codigo, int anoFabricacion, double peso, int cantidadSuspensiones) {
        super(codigo, anoFabricacion, peso);
        setCantidadSuspensiones(cantidadSuspensiones);
    }

    public int getCantidadSuspensiones() {
        return cantidadSuspensiones;
    }

    public void setCantidadSuspensiones(int cantidadSuspensiones) {
        if (cantidadSuspensiones < 0) {
            throw new IllegalArgumentException("la cantidad de las suspensiones no puede ser negativa");
        }
        this.cantidadSuspensiones = cantidadSuspensiones;
    }

    @Override
    public double calcularCostoMantencion() {
        double costoBase = 30000.0;
        if (cantidadSuspensiones > 1) {
            costoBase *= 1.15; // Incremento del 15% si tiene más de 1 suspensión
        }
        return costoBase;
    }
}
