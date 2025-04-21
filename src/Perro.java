public class Perro {
    private String placa;
    private String nombrePerro;
    private String raza;
    private int edadPerro;
    private String tamano;

    public Perro(String placa, String nombrePerro, String raza, int edadPerro, String tamano) {
        this.placa = placa;
        this.nombrePerro = nombrePerro;
        this.raza = raza;
        this.edadPerro = edadPerro;
        this.tamano = tamano;
    }

    public Perro() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombrePerro() {
        return nombrePerro;
    }

    public void setNombrePerro(String nombrePerro) {
        this.nombrePerro = nombrePerro;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edadPerro;
    }

    public void setEdad(int edadPerro) {
        this.edadPerro = edadPerro;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "placa='" + placa + '\'' +
                ", nombre='" + nombrePerro + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edadPerro +
                ", tamano='" + tamano + '\'' +
                '}';
    }
}
