public class Usuario {
    private String nombre;

    //Creación de objeto
    public Usuario(String nombre) {
        this.nombre = nombre;
        
    }
    //Metodo saludo
    public String Saludo() {
        return "Hola " + nombre;
    }
}

