package Services;
import Modules.Cliente;
import Modules.Solicitud;
import edu.princeton.cs.stdlib.In;
import edu.princeton.cs.stdlib.Out;
import java.util.*;

public class SistemaImpl implements Sistema {



    List<Cliente> ListaUsuarios = new ArrayList<>(); // Lista de Usuarios
    List<Solicitud> ListaSolicitud = new ArrayList<>(); // Lista de Solicitudes

    String UsuarioActual = ""; //Usuario Actual
    String ContraActual = ""; //Contrasena Actual

    /**
     * Metodo que realiza la carga de archivo de usuarios.txt
     */
    public void cargarArchivo() {
        In in = new In("usuarios.txt");

        while (in.hasNextLine()) {

            String linea = in.readLine();

            String[] campos = linea.split("/");

            if (campos.length >= 4) {
                String usuario = campos[0];
                String nombre = campos[1];
                String apellido = campos[2];
                String contrasena = campos[3];
                int edad = Integer.parseInt(campos[4]);
                String estado = campos[5];
                String matchRecibidos = campos[6];
                String match = campos[7];
                String matchEnviados = campos[8];

                Cliente Usuarios = new Cliente(usuario, nombre, apellido, contrasena, edad, estado, matchRecibidos, match, matchEnviados);

                ListaUsuarios.add(Usuarios);


            }



        }

    }

    /**
     * Metodo que realiza la carga de archivo de Solicitud.txt
     */
    public void cargarArchivo1(){

        In in = new In("Solicitud.txt");


        while (in.hasNextLine()){
            String linea = in.readLine();
            String[] campos = linea.split("/");
            if(campos.length >= 3) {
                String Solicitud = campos[0];
                String personaEnvia = campos[1];
                String personaReciba = campos[2];

                Solicitud Solicitudes = new Solicitud(Solicitud, personaEnvia, personaReciba);
                ListaSolicitud.add(Solicitudes);


            }
        }
    }

    /**
     * Metodo que realiza Guardar de archivo de usuarios.txt
     */

    public void guardarArchivo() {

        Out out = new Out("usuarios.txt");
        for (Cliente cliente : ListaUsuarios)
        {
            String ListaUsuarios = cliente.getUsuario() + "/" + cliente.getNombre() + "/" + cliente.getApellido() + "/" + cliente.getContrasena() + "/"  +  cliente.getEdad() + "/" + cliente.getEstado() + "/" + cliente.getMatchEnviadas() + "/" + cliente.getMatch() + "/" + cliente.getMatchRecibidas();
            out.println(ListaUsuarios);

        }

    }

    /**
     *  Metodo que realiza Guardar de archivo de Solicitud.txt
     */

    public void guardarArchivo1(){

        Out out = new Out("Solicitud.txt");
        for(Solicitud solicitud : ListaSolicitud){

            String ListaUsuario = solicitud.getSolicitud() + "/" + solicitud.getPersonaEnvia() + "/" + solicitud.getPersonaRecibe() ;
            out.println(ListaUsuario);
        }

    }

    /***
     * Metodo que Inicio Session
     */


    public void inicioSesion() {

        boolean inicioValido = false;
        System.out.println("--------->[Sistema Byteka Lover Us]<---------");
        System.out.print("Ingrese Usuario:");

        Scanner s = new Scanner(System.in);
        String inicio = s.nextLine();


        if (inicio.isEmpty()) { // Si el inicio esta sin ningun caracter
            System.out.println("Ingrese algun caracter");
            inicioSesion();
        } else {

            System.out.print("Ingrese Contraseña");
            String contrasena = s.nextLine();

            if (contrasena.isEmpty()){
                System.out.println("Ingrese algun caracter");
                inicioSesion();
            }


            String cadenaCodificada = Base64.getEncoder().encodeToString(contrasena.getBytes());



            for (Cliente cliente : ListaUsuarios) {
                if (cliente.getUsuario().equals(inicio) && cliente.getContrasena().equals(cadenaCodificada)){
                    inicioValido = true;
                    UsuarioActual = cliente.getUsuario();
                    ContraActual = cliente.getContrasena();
                    System.out.println("Bienvenido " + UsuarioActual ) ;

                }

            }

            if (inicioValido){
                System.out.println("Inicio de Sesion Correcta");
            } else {
                System.out.println("Usuario o Contraseña no Valida");
                inicioSesion();
            }



        }


    }

    /**
     * Menu del Sistema
     */


    public void menu() {

        Scanner s = new Scanner(System.in);
        imprimirMenu();
        String opcion = s.nextLine();

        while (!opcion.equals("5")) {

            switch (opcion) {
                case "1" -> opcion1();
                case "2" -> mostrarUsuarios();
                case "3" -> mostrarUsuariosAscendente();
                case "4" -> opcion4();
                default -> System.out.println("ERROR INGRESE UNA DE LAS OPCIONES CORRRECTAS");
            }
            imprimirMenu();
            opcion = s.nextLine();
        }

        System.out.println("**********************************");
        System.out.println("Cerrando sesion y saliendo del Sistema");
        System.out.println("GRACIAS POR USAR EL BYTEKA LOVER US ");
        System.out.println("**********************************");

    }

    /***
     * Imprimir Menu
     */

    public void imprimirMenu() {

        System.out.println("--------->[Byteka Lover Us]<---------");
        System.out.println("- Bienvenido al sistema de Emparejamiento BLU -");
        System.out.println("[1] Ajustes de usuario");
        System.out.println("[2] Mostrar Usuarios");
        System.out.println("[3] Mostrar usuarios por edad (Ascendiente) ");
        System.out.println("[4] Solicitud de Emparejamiento ");
        System.out.println("[5] Cerrar Sesion ");

    }

    /***
     * Imprimir Menu de Opcion 4
     */

    public void imprimirOpcion4() {

        System.out.println("--------->[Sistema Byteka Lover Us]<---------");
        System.out.println("OPCIONES DE EMPAREJAMIENTO");
        System.out.println("[1] Solicitudes de emparejamiento enviadas");
        System.out.println("[2] Solicitudes de emparejamiento recibidas");
        System.out.println("[3] Realizar solicitud de emparejamiento");
        System.out.println("[4] Aceptar solicitud de emparejamiento");
        System.out.println("[5] Rechazar solicitud de emparejamiento");
        System.out.println("[6] Cancelar emparejamiento");
        System.out.println("[7] Volver");


    }

    /***
     * Metodo que Imprime la opcion 1
     */

    public void imprimirOpcion1() {
        System.out.println("--------->[Sistema Byteka Lover Us]<---------");

        System.out.println("INFORMACION ACTUAL");
        for(Cliente cliente : ListaUsuarios){
            if(cliente.getUsuario().equals(UsuarioActual)){
                System.out.println("Usuario: " + UsuarioActual);
                System.out.println("Edad: " + cliente.getEdad());
                System.out.println("Descripcion: " + cliente.getEstado());
            }

        }
        System.out.println("**********************************");
        System.out.println("AJUSTES DE USUARIO");
        System.out.println("[1] Cambiar descripcion");
        System.out.println("[2] Cambiar contraseña");
        System.out.println("[3] Cambiar Edad");
        System.out.println("[4] Volver");
    }

    /***
     * Metodo que Muestra Usuarios de la Lista Usuarios
     */
    public void mostrarUsuarios() {
        System.out.println("Desplegando Usuarios(En caso de NO Aparecer Usuarios Todos los Usuarios Tienen un Match)");
        System.out.println("**********************************");
        System.out.println("USUARIOS DE BYTEKA (Usuarios sin Match) ");
        System.out.println("**********************************");

        if (ListaUsuarios.isEmpty()) {
            System.out.println("NO SE ENCUENTRAN USUARIOS EN EL SISTEMA ");

        } else {

            for (Cliente cliente : ListaUsuarios) {
                if (cliente.getMatch().equals("-")) {
                    System.out.println("Usuario: " + cliente.getUsuario());
                    System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
                    System.out.println("Edad: " + cliente.getEdad());
                    System.out.println("Descripcion: " + cliente.getEstado());
                    System.out.println("**********************************");
                } else {
                    continue;
                }

            }
        }
    }

    /***
     * Metodo BubbleSort que setea a to/do en un orden de menos a mayor
     * @param listaUsuarios
     */

    public void bubbleSort(List <Cliente> listaUsuarios){
        int n = listaUsuarios.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Comparar las edades de los clientes
                if (listaUsuarios.get(j).getEdad() > listaUsuarios.get(j + 1).getEdad()) {
                    // Intercambiar clientes
                    Cliente temp = listaUsuarios.get(j);
                    listaUsuarios.set(j, listaUsuarios.get(j + 1));
                    listaUsuarios.set(j + 1, temp);
                }
            }
        }

    }

    /**
     * Metodo que Imprime los Usuarios de manera Ascendiente
     */
    public void mostrarUsuariosAscendente() {

        bubbleSort(ListaUsuarios);

        System.out.println("**********************************");
        System.out.println("USUARIOS DE BYTEKA (Usuarios sin Match) ");
        System.out.println("**********************************");

        if (ListaUsuarios.isEmpty()) {
            System.out.println("NO SE ENCUENTRAN USUARIOS EN EL SISTEMA ");
        }else {

            for(Cliente cliente : ListaUsuarios){
                if(cliente.getMatch().equals("-")){
                    System.out.println("Usuario: " + cliente.getUsuario()) ;
                    System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
                    System.out.println("Edad: " + cliente.getEdad());
                    System.out.println("Descripcion: " + cliente.getEstado());
                    System.out.println("**********************************");
                }
            }
        }


    }

    /**
     * Metodo menu de opcion1 Ajustes de Usuario
     */
    public void opcion1() {


        Scanner s = new Scanner(System.in);
        imprimirOpcion1();
        String opcion = s.nextLine();




        while (!opcion.equals("4")) {
            switch (opcion) {
                case "1" -> cambiarDescripcion();
                case "2" -> cambiarContrasena();
                case "3" -> cambiarEdad();
                default -> System.out.println("ERROR INGRESE UNA DE LAS OPCIONES CORRRECTAS");
            }
            imprimirOpcion1();
            opcion = s.nextLine();
        }

        System.out.println("**********************************");
        System.out.println("Volviendo al menu principal ");
        System.out.println("**********************************");
    }

    /**
     * metodo que cambia la descripcion del Usuario Actual
     */
    public void cambiarDescripcion(){


        System.out.print(UsuarioActual + " Ingrese su nueva descripcion " );

        Scanner R = new Scanner(System.in);
        String Descripcion = R.nextLine();

        for(Cliente cliente : ListaUsuarios) {
            if(cliente.getUsuario().equals(UsuarioActual)){
                cliente.setEstado(Descripcion);
                System.out.println("Su descripcion cambio correctamente");
            }
        }


    }

    /***
     * Metodo que cambia la contraseña del usuario actual
     */

    public void cambiarContrasena(){

        System.out.print(UsuarioActual + " Ingrese su Contrseña actual:");

        Scanner R = new Scanner(System.in);
        String contrasena = R.nextLine();

        String cadenaCodificada = Base64.getEncoder().encodeToString(contrasena.getBytes());

        for(Cliente cliente : ListaUsuarios) {
            if(cliente.getUsuario().equals(UsuarioActual) && cliente.getContrasena().equals(cadenaCodificada)) {
                System.out.println("Ingrese su nueva contraseña");

                String contrasenaNueva = R.nextLine();

                if (contrasenaNueva.equals(contrasena)){
                    System.out.println("LA CONTRSEÑA NO PUEDE SER A LA ANTERIOR");
                } else {

                    String cadenaCodificada2 = Base64.getEncoder().encodeToString(contrasenaNueva.getBytes());

                    cliente.setContrasena(cadenaCodificada2);

                    System.out.println("Su contraseña fue cambiada con exito (Cerrado sesion por seguridad) ");
                    guardarArchivo();
                    guardarArchivo1();
                    System.exit(0);
                }
            }
        }




    }

    /**
     * Metodo que cambia la edad del Usuario Actual
     */

    public void cambiarEdad(){

        try {

            System.out.print(UsuarioActual + " Ingrese su nueva edad: " );

            Scanner R = new Scanner(System.in);
            int Valid = R.nextInt();

            if (Valid < 0 || Valid > 100) {
                System.out.println("Ingrese una Edad RAZONABLE (App para 0 a 100 años) ");
            } else {
                for(Cliente cliente : ListaUsuarios) {
                    if(cliente.getUsuario().equals(UsuarioActual)){
                        cliente.setEdad(Valid);
                        System.out.println("Su edad fue actualizado correctamente a " + cliente.getEdad());
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("ERROR, Ingrese un Numero Valido");
        }



    }

    /***
     * Menu de Opcion 4 Ajustes de Emparejamiento
     */



    public void opcion4() {

        Scanner s = new Scanner(System.in);
        imprimirOpcion4();
        String opcion = s.nextLine();

        while (!opcion.equals("7")) {
            switch (opcion) {
                case "1" -> solicitudEmparejamientoEnviadas();
                case "2" -> solicitudEmparejamientoRecibidas();
                case "3" -> realizarSolicitudEmparejamiento();
                case "4" -> aceptarSolicitudEmparejamiento();
                case "5" -> rechazarSolicitudEmparejamiento();
                case "6" -> cancelarEmparejamiento();
                default -> System.out.println("ERROR INGRESE UNA DE LAS OPCIONES CORRRECTAS");
            }
            imprimirOpcion4();
            opcion = s.nextLine();
        }

        System.out.println("**********************************");
        System.out.println("Volviendo al menu principal ");
        System.out.println("**********************************");
    }

    /***
     * Metodo que Imprime las solicitudes de emparejamiento enviadas
     */


    public void solicitudEmparejamientoEnviadas(){


        for(Cliente cliente : ListaUsuarios) {
            if(cliente.getUsuario().equals(UsuarioActual)){
                if(!cliente.getMatchEnviadas().equals("-")){
                    String linea = cliente.getMatchEnviadas();
                    String[] campos = linea.split("@");

                    System.out.println("Solicitudes de emparejamiento enviadas:");
                    System.out.println("**********************************");

                    for (String UsuariosEnviados : campos) {
                        for (Cliente cliente1 : ListaUsuarios) {
                            if (cliente1.getUsuario().equals(UsuariosEnviados)) {

                                System.out.println("Usuario: " + cliente1.getUsuario());
                                System.out.println("Nombre: " + cliente1.getNombre());
                                System.out.println("Edad: " + cliente1.getEdad());
                                System.out.println("Descripcion: " + cliente1.getEstado());
                                System.out.println("**********************************");
                            }
                        }
                    }

                    System.out.println("Estado de la Solicitudes: ");
                    System.out.println("**********************************");


                    for (Solicitud solicitud : ListaSolicitud) {
                            if (solicitud.getPersonaEnvia().equals(UsuarioActual)) {

                                System.out.println(solicitud.getPersonaRecibe() + " Estado: " + solicitud.getSolicitud() );
                                System.out.println("**********************************");
                            }
                        }


                } else {
                        System.out.println("ERROR NO POSEE SOLICITUDES ENVIADAS -_uwu_- ");

                }
            }
        }
    }

    /***
     * Metodo que Imprime las solicitudes de emparejamiento recibidas
     */


    public void solicitudEmparejamientoRecibidas() {

        for (Cliente cliente : ListaUsuarios) {
            if (cliente.getUsuario().equals(UsuarioActual)) {
                if (!cliente.getMatchRecibidas().equals("-")) {
                    String linea = cliente.getMatchRecibidas();
                    String[] campos = linea.split("@");

                    System.out.println("Solicitudes de emparejamiento Recibidas:");
                    System.out.println("**********************************");

                    for (String UsuariosRecibidos : campos) {

                        for (Cliente cliente1 : ListaUsuarios) {
                            if (cliente1.getUsuario().equals(UsuariosRecibidos)) {

                                System.out.println("Usuario: " + cliente1.getUsuario());
                                System.out.println("Nombre: " + cliente1.getNombre());
                                System.out.println("Edad: " + cliente1.getEdad());
                                System.out.println("Descripcion: " + cliente1.getEstado());
                                System.out.println("**********************************");

                            }
                        }
                    }

                    System.out.println("Estado de la Solicitudes: ");
                    System.out.println("**********************************");

                    for (Solicitud solicitud : ListaSolicitud) {
                            if (solicitud.getPersonaRecibe().equals(UsuarioActual) ) {
                                System.out.println("Usuario: " + solicitud.getPersonaEnvia() + " Estado " + solicitud.getSolicitud() );
                                System.out.println("**********************************");
                            }
                    }

                } else {
                    System.out.println("ERROR NO POSEE SOLICITUDES RECIBIDAS -_uwu_- ");

                }
            }
        }
    }

    /***
     * Metodo que realiza una solicitud de emparejamiento
     */


    public  void realizarSolicitudEmparejamiento(){
        for(Cliente cliente : ListaUsuarios) {
            if (cliente.getUsuario().equals(UsuarioActual)) {
                if (!cliente.getMatch().equals("-")) {
                        System.out.println("Usted Posee un Match UwU");
                    }
                    else {

                        mostrarUsuarios();

                        System.out.print("Ingrese el usuario al cual realiza el emparejamiento");
                        Scanner R = new Scanner(System.in);
                        String nombreUsuarioEmparejamiento = R.nextLine();
                        System.out.println("Buscando Usuario..... (Si vuelve al menu Significa que no encontro el Usuario)");

                        // Verificar si nombreUsuarioEmparejamiento se encuentra en la lista
                        for(Cliente cliente2 : ListaUsuarios) {
                            if (cliente2.getUsuario().equals(nombreUsuarioEmparejamiento)) {
                                if(cliente2.getMatch().equals("-")) {// Verifico si no encuentra ningun Match
                                    if (cliente2.getUsuario().equals(UsuarioActual)) {
                                        System.out.println("Ustede no puede realizar un emparejamiento con ustede mismo unu");
                                    }else {
                                        // Cambio de Solicitudes Enviadas a Usuario Actual
                                        String linea = cliente.getMatchEnviadas();
                                        String[] campos = linea.split("@");

                                        ArrayList<String> listaNombres = new ArrayList<>(Arrays.asList(campos));

                                        listaNombres.remove("-");
                                        listaNombres.add(nombreUsuarioEmparejamiento);

                                        String NuevaLinea = String.join("@", listaNombres);

                                        cliente.setMatchEnviadas(NuevaLinea);

                                        // Cambio de Solicitud Recibidas de Usuario nombreUsuarioEmparejamiento

                                        String linea1 = cliente2.getMatchRecibidas();
                                        String[] campos1 = linea1.split("@");

                                        ArrayList<String> listaNombres1 = new ArrayList<>(Arrays.asList(campos1));

                                        listaNombres1.add(UsuarioActual);

                                        String NuevaLinea1 = String.join("@", listaNombres1);


                                        cliente2.setMatchRecibidas(NuevaLinea1);
                                        pendienteSolicitud(nombreUsuarioEmparejamiento);
                                    }
                                }
                            }
                        }














                    }




            }
        }














    }

    /***
     * Metodo que Acepta una solicitud de emparejamiento
     */


    public  void aceptarSolicitudEmparejamiento(){

        for(Cliente cliente : ListaUsuarios) {
            if (cliente.getUsuario().equals(UsuarioActual)) {
                if (!cliente.getMatchRecibidas().equals("-")) {
                    if (!cliente.getMatch().equals("-")) {
                        System.out.println("ERROR Usted Posee un Match UwU");
                    } else {
                        String linea = cliente.getMatchRecibidas();
                        String[] campos = linea.split("@");


                        System.out.println("Usuarios que enviaron Solicitud");
                        for (String UsuariosEnviados : campos) {

                            for (Cliente cliente1 : ListaUsuarios) {
                                if (cliente1.getUsuario().equals(UsuariosEnviados)) {

                                    System.out.println("Usuario: " + cliente1.getUsuario());
                                    System.out.println("**********************************");
                                }
                            }
                        }

                        System.out.println("Estado de la Solicitudes: ");
                        System.out.println("**********************************");


                        for (Solicitud solicitud : ListaSolicitud) {
                            if (solicitud.getPersonaRecibe().equals(UsuarioActual)) {

                                System.out.println(solicitud.getPersonaEnvia() + " Estado: " + solicitud.getSolicitud() );
                                System.out.println("**********************************");
                            }
                        }


                        System.out.print("Ingrese el usuario al cual desea ACEPTAR el emparejamiento");
                        Scanner R = new Scanner(System.in);
                        String nombreUsuarioEmparejamiento = R.nextLine();

                        System.out.println("Buscando Usuario..... (Si vuelve al menu Significa que no encontro el Usuario)");

                        for(Cliente cliente2 : ListaUsuarios) {
                            if (cliente2.getUsuario().equals(nombreUsuarioEmparejamiento)) {
                                if(cliente2.getMatch().equals("-")){

                                for (String campo : campos) {
                                    if (campo.contains(nombreUsuarioEmparejamiento)) {


                                            cliente.setMatch(nombreUsuarioEmparejamiento);
                                            cliente2.setMatch(UsuarioActual);
                                            aceptarSolicitud(nombreUsuarioEmparejamiento);

                                            System.out.println("Realizando cambios.... Favor Espere uwu");
                                            System.out.println("USTED A REALIZADO UN EMPAREJAMIENTO CON  " + nombreUsuarioEmparejamiento);


                                    }


                                }
                                } else {
                                    System.out.println("Este Usuario se encuentra con Pareja ");
                                }
                            }

                        }

                    }
                } else {
                    System.out.println("ERROR USTED NO POSEE NIGUNA SOLICITUD -_uwu_- ");
                }
            }

        }
    }

    /**
     * Metodo que Cambia el setSolicitud a Aceptada
     * @param nombreUsuarioEmparejamiento persona que quiero Aceptada el emparejamiento
     */
    public void aceptarSolicitud(String nombreUsuarioEmparejamiento){

        System.out.println("Su Solicitud con la Persona " + nombreUsuarioEmparejamiento  + " se encuentra en estado Aceptada");
        for(Solicitud solicitud : ListaSolicitud){
            if(solicitud.getPersonaRecibe().equals(UsuarioActual) && solicitud.getPersonaEnvia().equals(nombreUsuarioEmparejamiento)){
                solicitud.setSolicitud("Aceptada");




            }

        }

    }

    /**
     * Metodo que Cambia el setSolicitud a Rechazada
     * @param nombreUsuarioEmparejamiento persona que quiero rechazar el emparejamiento
     */
    public void rechazarSolicitud(String nombreUsuarioEmparejamiento ){

        System.out.println("Su Solicitud con la Persona " + nombreUsuarioEmparejamiento  + " se encuentra en estado Rechazada");
        for(Solicitud solicitud : ListaSolicitud){
            if(solicitud.getPersonaRecibe().equals(UsuarioActual) && solicitud.getPersonaEnvia().equals(nombreUsuarioEmparejamiento)){
                solicitud.setSolicitud("Rechazada");

            }

        }

    }

    /***
     * Metodo que Crea una solicitud  lo agrega a la lista Solicitud
     * @param nombreUsuarioEmparejamiento persona que quiero realizar el emparejamiento (Pendiente)
     */
    public void pendienteSolicitud(String nombreUsuarioEmparejamiento){

        System.out.println("Su Solicitud con la Persona " + nombreUsuarioEmparejamiento  + " se encuentra en estado PENDIENTE");

        Solicitud nuevaSolicitud = new Solicitud("Pendiente" , UsuarioActual , nombreUsuarioEmparejamiento);
        ListaSolicitud.add(nuevaSolicitud);

    }

    /***
     * Metodo que rechaza la solicitud de emparejamiento
     */
    public void  rechazarSolicitudEmparejamiento(){

        for(Cliente cliente : ListaUsuarios){
            if(cliente.getUsuario().equals(UsuarioActual)){
                if(!cliente.getMatchRecibidas().equals("-")){
                    if(!cliente.getMatch().equals("-")){
                        System.out.println("ERROR Usted Posee un Match UwU");
                    } else {

                        String linea = cliente.getMatchRecibidas();
                        String[] campos = linea.split("@");


                        System.out.println("Usuarios que enviaron Solicitud");
                        for (String UsuariosEnviados : campos) {

                            for (Cliente cliente1 : ListaUsuarios) {
                                if (cliente1.getUsuario().equals(UsuariosEnviados)) {

                                    System.out.println("Usuario: " + cliente1.getUsuario());
                                    System.out.println("**********************************");
                                }
                            }
                        }

                        System.out.println("Estado de la Solicitudes: ");
                        System.out.println("**********************************");


                        for (Solicitud solicitud : ListaSolicitud) {
                            if (solicitud.getPersonaRecibe().equals(UsuarioActual)) {

                                System.out.println(solicitud.getPersonaEnvia() + " Estado: " + solicitud.getSolicitud() );
                                System.out.println("**********************************");
                            }
                        }


                        System.out.print("Ingrese el usuario al cual desea ACEPTAR el emparejamiento");
                        Scanner R = new Scanner(System.in);
                        String nombreUsuarioEmparejamiento = R.nextLine();

                        System.out.println("Buscando Usuario..... (Si vuelve al menu Significa que no encontro el Usuario)");


                        for(Cliente cliente2 : ListaUsuarios) {
                            if (cliente2.getUsuario().equals(nombreUsuarioEmparejamiento)) {
                                if(cliente2.getMatch().equals("-")){

                                    for (String campo : campos) {
                                        if (campo.contains(nombreUsuarioEmparejamiento)) {



                                            rechazarSolicitud(nombreUsuarioEmparejamiento);

                                            System.out.println("Realizando cambios.... Favor Espere uwu");
                                            System.out.println("USTED A RECHAZADO EL EMPAREJAMIENTO CON  " + nombreUsuarioEmparejamiento);


                                        }


                                    }
                                } else {
                                    System.out.println("Este Usuario se encuentra con Pareja ");
                                }
                            }

                        }















                    }
                } else {
                    System.out.println("ERROR NO POSEE SOLICITUDES RECIBIDAS -_uwu_- ");
                }
            }
        }

    }

    /**
     * Metodo que Cancela un Match
     */

    public void cancelarEmparejamiento(){

        for(Cliente cliente : ListaUsuarios){
            if(cliente.getUsuario().equals(UsuarioActual)){
                if(!cliente.getMatch().equals("-")){
                System.out.println("Usuario con Match: " + cliente.getMatch());
                System.out.println("Esta seguro de cancelar Match con esta persona");
                System.out.println("[1] Si Cancelar Match");
                System.out.println("[2] NO deseo volver atras");
                try {
                    Scanner R = new Scanner(System.in);
                    int resultado = R.nextInt();
                    if(resultado == 1){
                        for(Cliente cliente1 : ListaUsuarios){
                            if(cliente.getMatch().equals(cliente1.getUsuario())){
                                cliente1.setMatch("-");
                                cliente.setMatch("-");
                                System.out.println("Su Cancelacion fue realizada");
                            }
                        }
                    } else {
                        System.out.println("Volviendo Atras");
                    }
                }
                catch (Exception e){
                    System.out.println("Ingrese una de las opciones solicitadas");
                }} else {
                    System.out.println("ERROR USTED NO POSEE NINGUN MATCH -_uwu_- ");
                }







            }
        }



    }













}

























