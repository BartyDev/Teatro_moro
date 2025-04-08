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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        
        //DECLARANDO VARIABLES
        int asientos,variable,edad,fila,precio,estudiante,seguir;
        double descuento = 0;
        asientos = 10;
        variable = asientos * 4;
        String disponible = "[D]";
        String ocupado = "[X]";
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
        
        System.out.println("::: - TEATRO MORO - :::");
        System.out.println("(descuentos de hasta 15%)");
        
        
        
        
        //MENU
        for (;;) { 
            System.out.println("..::// MENU //::..");
            System.out.println("Seleccione una opción: ");
            System.out.println("1). Comprar entrada");
            System.out.println("2). Salir");
            int opcion = 0;
            while (opcion < 1 || opcion > 2) {
                opcion = tecla2.nextInt();
                tecla2.nextLine();
            }
            if (opcion == 1) {
                 fila = 0;
                while (fila < 1 || fila > 4) {
                  
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
                    System.out.println("Selecione una fila:");
                    fila = tecla2.nextInt();
                    tecla2.nextLine();
                   
                     
                }
                String[] zonaSeleccionada;
                 precio = 0;
                
                switch (fila) {
                    case 1 -> {
                        zonaSeleccionada = vip;
                        precio = 30000;
                        nombreZona = "VIP";
                    }
                    case 2 -> {
                        zonaSeleccionada = palcos;
                        precio = 13000;
                        nombreZona = "Palcos";
                    }
                    case 3 -> {
                        zonaSeleccionada = plateaAlta;
                        precio = 18000;
                        nombreZona = "Platea Alta";
                    }
                    case 4 -> {
                        zonaSeleccionada = plateaBaja;
                        precio = 15000;
                        nombreZona = "Platea Baja";
                    }                    
                    default -> {
                        System.out.println("Ingresa una opcion valida");
                        continue;
                    }
                }
                
                //VALIDAMOS ASIENTOS LIBRES O OCUPADOS
                System.out.println("Seleccione el numero de asiento (1 a " + asientos + "): ");
                int asiento = tecla2.nextInt();
                tecla2.nextLine();
                if (asiento < 1 || asiento > asientos ) {
                    System.out.println("Asiento inválido.");
                    continue;
                }
                if (zonaSeleccionada[asiento - 1].equals(ocupado)) {
                    System.out.println("Ese asiento ya está ocupado.");
                    continue;
                }
                
                zonaSeleccionada[asiento - 1] = ocupado;
                estudiante = 0;
                while (estudiante < 1 || estudiante > 2) {
                    System.out.println("¿Es estudiante? (1 = Sí / 2 = No): ");
                    estudiante = tecla2.nextInt();
                    tecla2.nextLine();
                }
              
                
                //VALIDAMOS DESCUENTOS X EDAD
                edad = 0;
                while (edad < 1 || edad > 120) {
                    System.out.println("Ingrese su edad: ");
                    edad = tecla2.nextInt();
                    tecla2.nextLine();
                    if (edad < 1 || edad > 120) {
                        System.out.println("Edad inválida.");
                        continue;
                    } else if (edad >= 55) {
                        descuento = 0.15;
                        System.out.println("Descuento, tercera edad (15%)");
                    } else if (estudiante == 1) {
                        descuento = 0.10;
                        System.out.println("Descuento, estudiante (10%)");
                    } else {
                        System.out.println("");
                    }
                    double precioFinal = precio - (precio * descuento);
                
                    zonasCompradas[totalFinal] = nombreZona;
                    asientosComprados[totalFinal] = asiento;
                    preciosFinales[totalFinal] = precioFinal;
                    descuentosAplicados[totalFinal] = (int) (descuento * 100);
                    totalFinal++;
                
                    
                    //VISUALIZACION DE COMPRA
                    System.out.println("::: - TEATRO MORO - :::");
                    System.out.println("\n==== ::::::::::: ====");
                    System.out.println("Zona: " + nombreZona);
                    System.out.println("Numero de asiento: " + asiento);
                    System.out.println("TOTAL: $" + precio);
                    System.out.println("Desc.: " + (int) (descuento * 100) + "%");
                    System.out.printf("Total a pagar: $%.0f\n", precioFinal);
                }
                System.out.println("\n¿Desea continuar? (1 = Sí / 2 = No): ");
                seguir = tecla2.nextInt();
                tecla2.nextLine();
                if (seguir != 1) {
                    break;
                }
            } else {
                break;
            }
        }
        //
        
        //VISUALIZACION DE COMPRA FINAL
        System.out.println("\n:::- VOUCHER FINAL -:::");
        double totalGeneral = 0;
        for (int i = 0; i < totalFinal; i++) {
            System.out.println("Entrada " + (i + 1));
            System.out.println("Zona: " + zonasCompradas[i]);
            System.out.println("Asiento: " + asientosComprados[i]);
            System.out.println("Descuento aplicado: " + descuentosAplicados[i] + "%");
            System.out.printf("Total pagado: $%.0f\n", preciosFinales[i]);
            System.out.println();
            totalGeneral += preciosFinales[i];
        }
        System.out.printf("Total pagado: $%.0f\n", + totalGeneral);
        System.out.println("Gracias por su compra, disfrute la funcion.");
        System.out.println("::: - TEATRO MORO - :::");
        System.out.println("::: -Vuelva pronto- :::");             
        
    }
    
}
