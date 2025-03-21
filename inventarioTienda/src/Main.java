import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<String> datos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        //variables
        String producto;
        String acualizarDatos= "";
        int opcion;
        int codActualizar = 0;
        int codEliminar;
        int eliminarDatos;
        int i; // variable del for


        System.out.println("Programa de inventario \n" +
                "Tienda Maria \n -------------------------");

        do {
            System.out.println("1.- Ingresar Datos \n" +
                    "2.- Actualizar Datos \n" +
                    "3.- Eliminar Datos \n" +
                    "0.- Salir \n");

            System.out.print("ingrese opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            if (opcion == 1) {  // Ingresar datos a la lista
                System.out.println("Ingrese el producto : ");
                producto = entrada.nextLine();
                datos.add(producto);
                System.out.println("productos en stock");
                System.out.println("--------------------------");
                for (i = 0; i < datos.size(); i++) {
                    System.out.println(i + ".- " + datos.get(i));
                }
                System.out.println("--------------------------");
                System.out.println("\n");


            } else if (opcion == 2) {
                if (datos.size() == 0) { // validar si la lista no esta vacia
                    System.out.println("No hay datos para editar");
                } else{
                    System.out.println("Ingrese el numero de stock para acutalizar : ");
                    codActualizar = entrada.nextInt();
                    entrada.nextLine();

                    if (codActualizar < 0 || codActualizar >=datos.size()) { // validar si el numero ingresado existe en la lista
                        System.out.println("No existe el numero de stock para acutalizar");

                    }else{ // actualizar el dato en la lista
                        System.out.println("Ingresa el nuevo producto : ");
                        acualizarDatos = entrada.nextLine();
                        datos.set(codActualizar, acualizarDatos);
                        System.out.println("--------------------------");
                        for (i = 0; i < datos.size(); i++) {
                            System.out.println(i + ".- " + datos.get(i));
                        }
                        System.out.println("--------------------------");
                    }
                }

                System.out.println("\n");
            }else if (opcion == 3) {
                if (datos.size() == 0) { // validar si la lista no esta vacia
                    System.out.println("No hay datos para editar");
                } else {
                    System.out.println("Ingrese el numero de stock para eliminar : ");
                    codEliminar = entrada.nextInt();
                    entrada.nextLine();
                    if (codEliminar < 0 || codEliminar >=datos.size()) { // validar si el numero ingresado existe en la lista
                        System.out.println("No existe el numero de stock para eliminar");
                    }else {

                        System.out.println("el producto "+ datos.get(codEliminar) + " se ha eliminado \n");
                        datos.remove(codEliminar);
                        System.out.println("------------------------");
                        for (i = 0; i < datos.size(); i++) {
                            System.out.println(i + ".- " + datos.get(i));
                        }
                        System.out.println("--------------------------");

                        }
                    System.out.println("\n");
                }
            }


        }while (opcion != 0) ;
        entrada.close();

        System.out.println("ha salido del menú");

        }
    }

