/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teatro_moro003;

import java.io.PrintStream;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author elvis_wndys14
 */
public class Teatro_Moro003 {

    //DECLARANDO VARIABLES ESTATICAS
    static double totalGeneral = 0;
    static String teatro = "::: - TEATRO MORO - :::";
    static String ocupado = "[X]";
    static String disponible = "[D]";
    static int cantSala = 40;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        //DECLARANDO VARIABLES DE INSTANCIA
        int asientos;
        int variable;
        int seguir;
        int asiento = 0;
        //PRECIOS ENTRADAS
        int a = 30000;
        int b = 13000;
        int c = 18000;
        int d = 15000;

        asientos = 10;
        variable = asientos * 4;
        String nombreZona = "";

        //ASIENTOS
        String[] vip = new String[asientos];
        String[] palcos = new String[asientos];
        String[] plateaAlta = new String[asientos];
        String[] plateaBaja = new String[asientos];

        Scanner tecla2 = new Scanner(System.in);

        for (int i = 0; i < asientos; i++) {
            vip[i] = disponible;
            palcos[i] = disponible;
            plateaAlta[i] = disponible;
            plateaBaja[i] = disponible;
        }

        //AQUI ACUMULAMOS EL TOTAL A PAGAR FINAL
        String[] zonasCompradas = new String[variable];
        int[] asientosComprados = new int[variable];
        double[] preciosFinales = new double[variable];
        int[] descuentosAplicados = new int[variable];
        int totalFinal = 0;

        System.out.println(teatro);

        //MENU
        for (;;) {
            System.out.println("");
            System.out.println(".....::// MENU //::.....");
            System.out.println("----- aforo max." + cantSala + " -----");
            System.out.println("Seleccione una opción: ");
            System.out.println("1). Comprar entrada");
            System.out.println("2). Entradas compradas");
            System.out.println("3). Promociones");
            System.out.println("4). Salir");
            int opcion = 0;//variables locales
            while (opcion < 1 || opcion > 4) {

                if (tecla2.hasNextInt()) {
                    opcion = tecla2.nextInt();
                    tecla2.nextLine();
                } else {
                    tecla2.next();
                    System.out.println("ERROR : Opcion inválida");
                }
            }
            if (opcion == 1) {

                int fila = 0;//variables locales
                while (fila < 1 || fila > 4) {

                    System.out.println("\t\t:::::: entradas disponibles : " + variable + " ::::::");

                    System.out.print("VIP\t\t");
                    for (String s : vip) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    System.out.print("Palcos\t\t");
                    for (String s : palcos) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    System.out.print("Platea Alta\t");
                    for (String s : plateaAlta) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    System.out.print("Platea Baja\t");

                    for (String s : plateaBaja) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Selecione una fila(1 , 2 , 3 , 4):");

                    if (tecla2.hasNextInt()) {
                        fila = tecla2.nextInt();
                        tecla2.nextLine();

                    } else {

                        tecla2.next();
                        System.out.println("ERROR : Opcion inválida");
                    }
                }

                String[] zonaSeleccionada;
                int precio;//variables locales

                switch (fila) {
                    case 1 -> {
                        zonaSeleccionada = vip;
                        precio = a;
                        nombreZona = "VIP";
                    }
                    case 2 -> {
                        zonaSeleccionada = palcos;
                        precio = b;
                        nombreZona = "Palcos";
                    }
                    case 3 -> {
                        zonaSeleccionada = plateaAlta;
                        precio = c;
                        nombreZona = "Platea Alta";
                    }
                    case 4 -> {
                        zonaSeleccionada = plateaBaja;
                        precio = d;
                        nombreZona = "Platea Baja";
                    }
                    default -> {
                        System.out.println("Ingresa una opcion válida");
                        continue;
                    }
                }

                //VALIDAMOS ASIENTOS LIBRES O OCUPADOS
                System.out.println("Seleccione el numero de asiento (1 a " + asientos + "): ");

                if (tecla2.hasNextInt()) {
                    asiento = tecla2.nextInt();
                } else {
                    tecla2.next();
                    System.out.println("ERROR : Opcion inválida");
                    continue;
                }
                if (asiento < 1 || asiento > asientos) {
                    System.out.println("Asiento inválido.");
                    continue;
                }
                if (zonaSeleccionada[asiento - 1].equals(ocupado)) {
                    System.out.println("Ese asiento ya está ocupado.");
                    continue;
                }

                tecla2.nextLine();
                zonaSeleccionada[asiento - 1] = ocupado;
                int estudiante = 0;//variables locales
                while (estudiante < 1 || estudiante > 2) {
                    // System.out.println("::- descuentos del 10% para estudiantes y\ndel 15% para personas de la tercera edad -::");
                    System.out.println("¿Es estudiante? (1 = Sí / 2 = No): ");

                    if (tecla2.hasNextInt()) {
                        estudiante = tecla2.nextInt();
                        tecla2.nextLine();

                    } else {
                        tecla2.next();
                        System.out.println("ERROR : Opcion inválida");
                    }
                }

                //VALIDAMOS DESCUENTOS X EDAD
                int edad = 0;//variables locales

                while (edad < 1 || edad > 120) {
                    System.out.println("¡Se aplicara el descuento si cumple las condiciones!");
                    System.out.println("Ingrese su edad: ");
                    edad = tecla2.nextInt();
                    tecla2.nextLine();
                    double descuento = 0;
                    System.out.println("");
                    if (edad < 1 || edad > 120) {
                        System.out.println("Edad inválida.");
                        continue;
                    } else if (edad >= 55) {
                        descuento = 0.15;
                        System.out.println("¡Se agrego el descuento adulto mayor!");
                    } else if (estudiante == 1 && edad >= 3) {
                        descuento = 0.10;
                        System.out.println("¡Se agrego el descuento estudiante!");

                    } else {
                        System.out.println("¡No aplica a ninguna promoción!");
                    }

                    double precioFinal = precio - (precio * descuento);

                    zonasCompradas[totalFinal] = nombreZona;
                    asientosComprados[totalFinal] = asiento;
                    preciosFinales[totalFinal] = precioFinal;
                    descuentosAplicados[totalFinal] = (int) (descuento * 100);
                    totalFinal++;
                    variable--;
                }
                System.out.println("Se ha agregado al carrito con éxito");
                System.out.println("\n¿Desea realizar otra compra? 1)Si / 2)Ir a pagar): ");

                seguir = tecla2.nextInt();
                tecla2.nextLine();
                if (seguir != 1) {
                    break;
                }

            } else if (opcion == 2) {

                System.out.println("==== ::::::::::: ====");
                System.out.println(":::|| CARRITO ||:::");

                int i;

                if (totalFinal >= 1) {
                    for (i = 0; i < totalFinal; i++) {
                        System.out.println("");
                        System.out.print("Entrada #" + (i + 1) + " || ");
                        System.out.print("Zona: " + zonasCompradas[i] + " || ");
                        System.out.print("Asiento: " + asientosComprados[i] + " || ");
                        System.out.printf(" Precio: $%.0f\n", preciosFinales[i]);
                    }
                } else {
                    System.out.println("el carrito esta vacio");
                    continue;
                }
                System.out.println("");
                System.out.println("1)eliminar entrada\n0)salir");
                seguir = tecla2.nextInt();
                tecla2.nextLine();

                if (seguir == asiento) {
                    totalFinal--;
                    variable++;
                    System.out.println("entrada eliminada");
                }
                continue;
            } else if (opcion == 3) {
                System.out.println("");
                System.out.println("==== ::::::::::: ====");
                System.out.println("::|| PROMOCIONES ||::");
                System.out.println("15% DESCUENTO EN ADULTOS MAYORES (55 A +)");
                System.out.println("10% DESCUENTO ESTUDIANTES");

                continue;
            } else {
                break;
            }
        }
        //

        //VISUALIZACION DE COMPRA FINAL
        System.out.println("\n:::- VOUCHER FINAL -:::");

        for (int i = 0; i < totalFinal; i++) {
            System.out.println("Entrada #" + (i + 1));
            System.out.println("Zona: " + zonasCompradas[i]);
            System.out.println("Asiento: " + asientosComprados[i]);
            System.out.println("Descuento aplicado : " + descuentosAplicados[i] + "%");
            System.out.printf("Precio: $%.0f\n", preciosFinales[i]);
            System.out.println();
            totalGeneral += preciosFinales[i];
        }
        System.out.printf("Total a pagar: $%.0f\n", +totalGeneral);
        System.out.println("Total de entradas vendidas: " + (cantSala - variable));
        System.out.println(teatro);
        System.out.println("¡Gracias por su compra!\n¡disfrute la funcion!");

    }

}
