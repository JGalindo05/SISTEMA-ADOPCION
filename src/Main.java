import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();
        List<Perro> perrosDisponibles = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("""
                    -----MENU-----
                    1. Registrar personas
                    2. Registrar perro
                    3. Ver personas registradas
                    4. Ver perros disponibles
                    5. Adoptar perros (puedes adoptar 3 perros por persona)
                    6. Consultar el perro mas viejo adoptado
                    7. Salir del programa...
                    
                    """);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = teclado.nextLine();
                    System.out.println("Edad: ");
                    int edad = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Documentos: ");
                    String documento = teclado.nextLine();
                    personas.add(new Persona(nombre, apellido, edad, documento));


                case 2:
                    System.out.println("Placa: ");
                    String placa = teclado.nextLine();
                    System.out.println("Nombre: ");
                    String nombrePerro = teclado.nextLine();
                    System.out.println("Raza: ");
                    String raza = teclado.nextLine();
                    System.out.println("Edad: ");
                    int edadPerro = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Tamaño: ");
                    String tamano = teclado.nextLine();
                    perrosDisponibles.add(new Perro(placa, nombrePerro, raza, edadPerro, tamano));


                case 3:
                    for (Persona persona : personas){
                        System.out.println(persona);
                    }


                case 4:
                    for (Perro perro : perrosDisponibles){
                        System.out.println(perro);
                    }


                case 5:
                    System.out.println("Ingrese documento de la persona: ");
                    String doc = teclado.nextLine();
                    Persona personaEncontrada = null;

                    for (int i = 0; i < personas.size(); i++) {
                        if (personas.get(i).getDocumento().equals(doc)) {
                            personaEncontrada = personas.get(i);

                        }
                    }

                    if (personaEncontrada == null) {
                        System.out.println("Persona no encontrada.");

                    }

                    System.out.print("Placa del perro a adoptar: ");
                    String placaAdoptar = teclado.nextLine();
                    Perro perroEncontrado = null;
                    int indicePerro = -1;

                    for (int i = 0; i < perrosDisponibles.size(); i++) {
                        if (perrosDisponibles.get(i).getPlaca().equals(placaAdoptar)) {
                            perroEncontrado = perrosDisponibles.get(i);
                            indicePerro = i;
                        }
                    }

                    if (perroEncontrado == null) {
                        System.out.println("Perro no encontrado o ya fue adoptado.");
                    } else {
                        personaEncontrada.adoptarPerro(perroEncontrado);
                        perrosDisponibles.remove(indicePerro);
                    }







            }

        }while(opcion!=7);





    }

}