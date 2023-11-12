package Modules;

public class Solicitud {

    /**
     * Solicitud
     */


    private String Solicitud;

    /**
     * La persona que envia la Solicitud
     */


    private String personaEnvia;

    /**
     * La persona que recibe la solicitud
     */

    private String personaRecibe;

    /**
     * Constructor de Solicitud
     * @param solicitud
     * @param personaEnvia
     * @param personaRecibe
     */


    public Solicitud(String solicitud, String personaEnvia, String personaRecibe) {
        Solicitud = solicitud;
        this.personaEnvia = personaEnvia;
        this.personaRecibe = personaRecibe;
    }

    /**
     * Set Solicitud
     * @return
     */

    public void setSolicitud(String solicitud) {
        Solicitud = solicitud;
    }

    /**
     * Set Solicitud
     * @return
     */

    public String getSolicitud() {
        return Solicitud;
    }

    /**
     * Get Persona que Envia Solicitud
     * @return
     */

    public String getPersonaEnvia() {
        return personaEnvia;
    }
    /**
     * Get Persona que Recibe Solicitud
     * @return
     */

    public String getPersonaRecibe() {
        return personaRecibe;
    }
}
