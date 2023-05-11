package a.a;
import java.util.ArrayList;
import java.util.List;

public class Feria {
    private String nombre;
    private List<Persona> visitantes;

    public Feria(String nombre) {
        this.nombre = nombre;
        this.visitantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getVisitantes() {
        return visitantes;
    }

    public void agregarVisitante(Persona persona) {
        visitantes.add(persona);
    }
}