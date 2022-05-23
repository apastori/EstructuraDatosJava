package trabajarconobligatorio.Modelos;

public class Contacto implements Comparable<Contacto> {
    private int numero;
    private String nombre;
    // agregar lista de mensajes

    public Contacto(int elNumero, String elNombre) {
        this.setNumero(elNumero);
        this.setNombre(elNombre);
    }

    public Contacto(int elNumero) {
        this.setNumero(elNumero);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // public boolean equals(Object o) {
    // return this.getNombre().equalsIgnoreCase(((Contacto) o).getNombre());
    // }
    public boolean equals(Object o) {
        if (this.getNumero() == ((Contacto) o).getNumero()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    // public int compareTo(Contacto o) {
    // return this.getNombre().compareTo(o.getNombre());
    // }
    public int compareTo(Contacto o) {
        if (this.numero == o.numero) {
            return 0;
        } else {
            return 1;
        }        
    }

    public String toString() {
        return "Numero: " + this.getNumero() + " Nombre: " + this.getNombre();
    }
}
