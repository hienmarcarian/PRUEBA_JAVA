public abstract class Bicicleta {
    private String codigo;
    private int anoFabricacion;
    private double peso;

    public Bicicleta() {
    }

    public Bicicleta(String codigo, int anoFabricacion, double peso) {
        setCodigo(codigo);
        setAnoFabricacion(anoFabricacion);
        setPeso(peso);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("el codigo de la bicicleta no puede estar vacío.");
        }
        this.codigo = codigo.trim();
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        if (anoFabricacion < 2000 || anoFabricacion > 2026) {
            throw new IllegalArgumentException("el año de fabricación debe estar entre 2000 y 2026.");
        }
        this.anoFabricacion = anoFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("el peso debe ser mayor que cero");
        }
        this.peso = peso;
    }

    public abstract double calcularCostoMantencion();

    @Override
    public String toString() {
        return "Código: " + codigo + " | Año: " + anoFabricacion;
    }
}
