package Modules;

public class Cliente {


    private String Usuario;

    /**
     * Nombre del usuario
     */
    private String nombre;

    /**
     * Apellido del Usuario
     */
    private String apellido;

    /**
     *  contraseña del usuario
     */

    private String contrasena;

    /**
     *  edad del usuario
     */
    private int edad;

    /**
     * Estado del usuario
     */


    private String estado;

    /**
     * Match recibidos
     */

    private String matchRecibidas;

    /**
     * Match del usuario
     */

    private String match;


    /***
     * Match enviadas
     */

    private String matchEnviadas;

    /***
     * Constructor de Cliente
     * @param Usuario
     * @param nombre
     * @param apellido
     * @param contrasena
     * @param edad
     * @param estado
     * @param matchRecibidas
     * @param match
     * @param matchEnviadas
     */

    public Cliente(String Usuario,String nombre, String apellido, String contrasena, int edad, String estado, String matchRecibidas, String match, String matchEnviadas) {
        this.Usuario = Usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.edad = edad;
        this.estado = estado;
        this.matchRecibidas = matchRecibidas;
        this.match = match;
        this.matchEnviadas = matchEnviadas;
    }

    /**
     * Get Usuario
     * @return
     */

    public String getUsuario(){
        return Usuario;
    }

    /**
     * Get Nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Get Apellido
     * @return
     */

    public String getApellido() {
        return apellido;
    }

    /**
     * Get Contrasena
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Get Edad
     * @return
     */

    public int getEdad() {
        return edad;
    }

    /**
     * Get Descripcion/Estado del Usuario
     * @return
     */

    public String getEstado() {
        return estado;
    }

    /**
     * Get Solicitudes Recibidas
     * @return
     */
    public String getMatchRecibidas() {
        return matchRecibidas;
    }

    /**
     * Get Emparejamiento (Match)
     * @return
     */

    public String getMatch() {
        return match;
    }

    /**
     * Get Emparejamiento Enviado
     * @return
     */
    public String getMatchEnviadas() {
        return matchEnviadas;
    }

    /**
     * Set Contraseña
     * @param contrasena
     */


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Set edad
     * @param edad
     */

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Set Descripcion
     * @param estado
     */

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Set Match
     * @param match
     */

    public void setMatch(String match) {
        this.match = match;
    }

    /**
     * Set Emparejamiento Recibidos
     * @param matchRecibidas
     */

    public void setMatchRecibidas(String matchRecibidas) {
        this.matchRecibidas = matchRecibidas;
    }

    /**
     * Set Emparejamiento enviados
     * @param matchEnviadas
     */

    public void setMatchEnviadas(String matchEnviadas) {
        this.matchEnviadas = matchEnviadas;
    }
}

