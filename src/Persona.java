import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;
    private List<Perro> perrosAdoptados;

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perrosAdoptados = new ArrayList<>();
    }

    public String getDocumento() {
        return documento;
    }

    public void adoptarPerro(Perro perro) {
        if (perrosAdoptados.size() < 3) {
            perrosAdoptados.add(perro);
        } else {
            System.out.println("Esta persona ya adoptó el máximo de 3 perros.");
        }
    }

    public Perro perroMasGrande() {
        if (perrosAdoptados.isEmpty()) return null;

        Perro mayor = perrosAdoptados.get(0);
        for (int i = 1; i < perrosAdoptados.size(); i++) {
            if (perrosAdoptados.get(i).getEdad() > mayor.getEdad()) {
                mayor = perrosAdoptados.get(i);
            }
        }
        return mayor;
    }

    @Override
    public String toString() {
        String resultado = nombre + " " + apellido + ", Edad: " + edad + ", Documento: " + documento + "\nPerros adoptados:\n";
        for (Perro p : perrosAdoptados) {
            resultado += "- " + p + "\n";
        }
        return resultado;
    }
}

