import Services.*;


public class Main {
    public static void main(String[] args) {


        SistemaImpl sistema = new SistemaImpl();

        //Carga de Archivos
        sistema.cargarArchivo();
        sistema.cargarArchivo1();



        //Inicio de Session
        sistema.inicioSesion();

        //Menu
        sistema.menu();

        //Guardar Archivos
        sistema.guardarArchivo();
        sistema.guardarArchivo1();















    }
}