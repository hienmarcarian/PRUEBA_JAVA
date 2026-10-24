import java.util.ArrayList;
import java.util.List;

public class GestorTallerBicicletas{
    private List<Bicicleta> bicicletas;

    public GestorTallerBicicletas() {
        this.bicicletas = new ArrayList<>();
    }

    public void registrarBicicleta(Bicicleta bicicleta) {
        if (bicicleta != null) {
            bicicletas.add(bicicleta);
            System.out.println(bicicleta.getCodigo() + " (" + bicicleta.getClass().getSimpleName() + ") registrada correctamente.");
        }
    }

    public Bicicleta buscarPorCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }
        for (Bicicleta bici : bicicletas) {
            if (bici.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return bici;
            }
        }
        return null;
    }

    public void listarTodas() {
        System.out.println("-- listado de bicicletas");
        for (Bicicleta bici : bicicletas) {
            System.out.println(bici.toString());
        }
    }

    public List<Bicicleta> getBicicletas() {
        return bicicletas;
    }
}