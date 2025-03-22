import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<String> nombre = new ArrayList<>();
        ArrayList<Double> precio = new ArrayList<>();
        ArrayList<Integer> cantidad = new ArrayList<>();
        ArrayList<Double> cantidadIVA = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);

        //variables de entrada
        int opcion;
        String producto = "";
        double precioSinIVA;
        int cantidadProducto;
        final double IVA = 0.10;
        double precioIva = 0;
        //variables de actualización
        String acualizarProducto= "";
        double acualizarPrecio;
        int acualizarCantidad;
        int codActualizar = 0;
        //variables de eliminación
        int codEliminar;



        int i; // variable del for


        System.out.println("Programa de inventario \n" +
                "Tienda Maria \n -------------------------");

        do {
            System.out.println("1.- Ingresar Datos \n" +
                    "2.- Mostrar Inventario \n" +
                    "3.- Actualizar Datos \n" +
                    "4.- Eliminar Datos \n" +
                    "0.- Salir \n");

            System.out.print("ingrese opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();


            if (opcion == 1) {  // Ingresar nombreProducto a la lista

                System.out.println("Ingrese el producto : ");
                producto = entrada.nextLine();
                System.out.println("Ingrese el precio de producto : ");
                precioSinIVA = entrada.nextDouble();
                entrada.nextLine();
                System.out.println("Ingrese la cantidad de productos : ");
                cantidadProducto = entrada.nextInt();
                entrada.nextLine();


                nombre.add(producto);
                precio.add(precioSinIVA);
                cantidad.add(cantidadProducto);
                precioIva = precioSinIVA + (cantidadProducto * IVA);
                cantidadIVA.add(precioIva);

                System.out.println("el producto: " + producto+ " ingresado exitosamente \n");

                precioIva=0; // limpiar la variable



            } else if (opcion == 2) {
                System.out.println("Inventario ");
                System.out.println("--------------------------");
                System.out.println("    producto    precio  cantidad  total");
                for (i = 0; i < nombre.size(); i++) {
                    System.out.println(i + ".- " + nombre.get(i)+ ",      "+precio.get(i)+",  "+cantidad.get(i)+ ",  "+cantidadIVA.get(i));
                }
                System.out.println("--------------------------");
                System.out.println("\n");


            } else if (opcion == 3) {
                if (nombre.size() == 0) { // validar si la lista no esta vacia
                    System.out.println("No hay productos  en el tienda");
                } else{
                    System.out.println("Ingrese el numero de stock para acutalizar : ");
                    codActualizar = entrada.nextInt();
                    entrada.nextLine();

                    if (codActualizar < 0 || codActualizar >=nombre.size()) { // validar si el numero ingresado existe en la lista
                        System.out.println("No existe el numero de stock para acutalizar");

                    }else{ // actualizar el dato en la lista
                        System.out.println("Ingresa el nuevo producto : ");
                        acualizarProducto = entrada.nextLine();
                        entrada.nextLine();
                        System.out.println("Ingresa el nuevo precio : ");
                        acualizarPrecio = entrada.nextDouble();
                        entrada.nextLine();
                        System.out.println("Ingresa la nueva cantidad : ");
                        acualizarCantidad = entrada.nextInt();
                        entrada.nextLine();

                        nombre.set(codActualizar, acualizarProducto);
                        precio.set(codActualizar, acualizarPrecio);
                        cantidad.set(codActualizar,acualizarCantidad);

                        System.out.println("El producto: "+nombre.get(codActualizar)+ " actualizado exitosamente" );
                        System.out.println("-------------------------------------\n");

                    }
                }

                System.out.println("\n");
            }else if (opcion == 4) {
                if (nombre.size() == 0) { // validar si la lista no esta vacia
                    System.out.println("No hay productos para eliminar");
                } else {
                    System.out.println("Ingrese el numero de stock para eliminar : ");
                    codEliminar = entrada.nextInt();
                    entrada.nextLine();
                    if (codEliminar < 0 || codEliminar >= nombre.size()) { // validar si el numero ingresado existe en la lista
                        System.out.println("No existe el numero de stock para eliminar");
                    } else {

                        System.out.println("el producto " + nombre.get(codEliminar) + " se ha eliminado \n");
                        nombre.remove(codEliminar);
                        cantidad.remove(codEliminar);
                        cantidadIVA.remove(codEliminar);
                        precio.remove(codEliminar);
                        System.out.println("------------------------");
                    }
                    System.out.println("\n");
                }


            } else if (opcion >=5) {
                System.out.println("Opcion incorrecta");
            }


        }while (opcion != 0) ;
        entrada.close();

        System.out.println("ha salido del menu");

        }
    }

