package POO.practica56.reto;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private final List<Articulo> articulos;

    public Carrito() {

        this.articulos = new ArrayList<>(); //Polimorismo
    }

    public boolean agregar(Articulo a){
        if (a.getNombre() == null) return false;
        if (a.getNombre().isEmpty()) return false;
        articulos.add(a);
        return true;
    }

    public boolean eliminarPorIndice(int index) {
        if (index < 0) return false;
        if (index >= articulos.size()) return false;
        articulos.remove(index);
        return true;
    }

    public boolean eliminarPorNombre(String nombre) {
        if (nombre == null) return false;
        String target = nombre.trim();
        if (target.isEmpty()) return false;
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).getNombre().equalsIgnoreCase(target)) {
                articulos.remove(i);
                return true;
            }
        }
        return false;
    }

    public void limpiar() {
        articulos.clear();
    }

    public List<Articulo> getArticulos() {
        return new ArrayList<>(articulos);
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < articulos.size(); i++) {
            total += articulos.get(i).getPrecio();
        }
        return total;
    }
}  