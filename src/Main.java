import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        List<Perro> perrosDisponibles = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar persona");
            System.out.println("2. Registrar perro");
            System.out.println("3. Ver personas registradas");
            System.out.println("4. Ver perros disponibles");
            System.out.println("5. Adoptar perro");
            System.out.println("6. Consultar perro más viejo adoptado por una persona");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = teclado.nextLine();
                    System.out.print("Edad: ");
                    int edad = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Documento: ");
                    String doc = teclado.nextLine();
                    personas.add(new Persona(nombre, apellido, edad, doc));
                    break;

                case 2:
                    System.out.print("Placa: ");
                    String placa = teclado.nextLine();
                    System.out.print("Nombre: ");
                    String nombrePerro = teclado.nextLine();
                    System.out.print("Raza: ");
                    String raza = teclado.nextLine();
                    System.out.print("Edad: ");
                    int edadPerro = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Tamaño: ");
                    String tamaño = teclado.nextLine();
                    perrosDisponibles.add(new Perro(placa, nombrePerro, raza, edadPerro, tamaño));
                    break;

                case 3:
                    for (Persona persona : personas) {
                        System.out.println(persona);
                    }
                    break;

                case 4:
                    for (Perro perro : perrosDisponibles) {
                        System.out.println(perro);
                    }
                    break;

                case 5:
                    System.out.print("Documento de la persona: ");
                    String documento = teclado.nextLine();
                    Persona personaEncontrada = null;

                    for (int i = 0; i < personas.size(); i++) {
                        if (personas.get(i).getDocumento().equals(documento)) {
                            personaEncontrada = personas.get(i);
                            break;
                        }
                    }

                    if (personaEncontrada == null) {
                        System.out.println("Persona no encontrada.");
                        break;
                    }

                    System.out.print("Placa del perro a adoptar: ");
                    String placaAdoptar = teclado.nextLine();
                    Perro perroEncontrado = null;
                    int indicePerro = -1;

                    for (int i = 0; i < perrosDisponibles.size(); i++) {
                        if (perrosDisponibles.get(i).getPlaca().equals(placaAdoptar)) {
                            perroEncontrado = perrosDisponibles.get(i);
                            indicePerro = i;
                            break;
                        }
                    }

                    if (perroEncontrado == null) {
                        System.out.println("Perro no encontrado o ya fue adoptado.");
                    } else {
                        personaEncontrada.adoptarPerro(perroEncontrado);
                        perrosDisponibles.remove(indicePerro);
                    }
                    break;

                case 6:
                    System.out.print("Documento de la persona: ");
                    String docConsulta = teclado.nextLine();
                    Persona personaConsulta = null;

                    for (int i = 0; i < personas.size(); i++) {
                        if (personas.get(i).getDocumento().equals(docConsulta)) {
                            personaConsulta = personas.get(i);
                            break;
                        }
                    }

                    if (personaConsulta == null) {
                        System.out.println("Persona no encontrada.");
                    } else {
                        Perro perroViejo = personaConsulta.perroMasGrande();
                        if (perroViejo == null) {
                            System.out.println("La persona no ha adoptado perros.");
                        } else {
                            System.out.println("El perro más viejo es: " + perroViejo);
                        }
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }
}
