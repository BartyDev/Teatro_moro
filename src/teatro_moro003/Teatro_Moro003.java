/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teatro_moro003;


import java.io.PrintStream;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;


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
     static String reservado = "[R]";
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
            System.out.println("1).Reservar entradas");
            System.out.println("2).Comprar entradas");
            System.out.println("3).Modificar compra");
            System.out.println("4).Boleta");
        
            
            
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
    while (true) { // Permitir repetir la selección de asiento sin regresar al menú principal
        System.out.println("\t\t:::::: Entradas disponibles : " + variable + " ::::::");

        // **Imprimir zonas con los asientos reservados y ocupados**
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

        System.out.println("Seleccione una fila(1 , 2 , 3 , 4):");

        if (tecla2.hasNextInt()) {
            int fila = tecla2.nextInt();
            tecla2.nextLine();

            String[] zonaSeleccionada;
            switch (fila) {
                case 1 -> {
                    zonaSeleccionada = vip;
                    nombreZona = "VIP";
                }
                case 2 -> {
                    zonaSeleccionada = palcos;
                    nombreZona = "Palcos";
                }
                case 3 -> {
                    zonaSeleccionada = plateaAlta;
                    nombreZona = "Platea Alta";
                }
                case 4 -> {
                    zonaSeleccionada = plateaBaja;
                    nombreZona = "Platea Baja";
                }
                default -> {
                    System.out.println("Ingresa una opción válida");
                    continue;
                }
            }

            System.out.println("Seleccione el número de asiento (1 a " + asientos + "): ");
            if (tecla2.hasNextInt()) {
                asiento = tecla2.nextInt();
                tecla2.nextLine();

                if (asiento < 1 || asiento > asientos) {
                    System.out.println("Asiento inválido.");
                    continue;
                }
                if (zonaSeleccionada[asiento - 1].equals(ocupado) || zonaSeleccionada[asiento - 1].equals(reservado)) {
                    System.out.println("Ese asiento ya ha sido reservado o comprado, no puedes seleccionarlo.");
                    continue;
                }

                zonaSeleccionada[asiento - 1] = reservado; // **El asiento pasa de disponible a reservado**
                variable--; // **La cantidad de asientos disponibles disminuye**

   // Crear una variable exclusiva para manejar reservas sin afectar la original
final int asientoReservaTemp = asiento;

System.out.println("Se ha reservado tu asiento con éxito.");
System.out.println("\nTienes 10 segundos para confirmar tu reserva...");

// **Temporizador de cancelación automática**
final Timer cancelTimer = new Timer();
cancelTimer.schedule(new TimerTask() {
    @Override
    public void run() {
        if (zonaSeleccionada[asientoReservaTemp - 1].equals(reservado)) {
            System.out.println("\n⏳ Tu reserva ha sido cancelada por falta de confirmación.");
            zonaSeleccionada[asientoReservaTemp - 1] = disponible; // Se libera el asiento
        }
        cancelTimer.cancel();
    }
}, 10000); // 10 segundos para cancelar si no se confirma

// **Opción de confirmación**
System.out.println("\n¿Desea confirmar su reserva? 1)Sí / 2)No: ");
if (tecla2.hasNextInt()) {
    final int confirmacion = tecla2.nextInt();
    tecla2.nextLine();

    if (confirmacion == 1) {
        System.out.println("✅ Reserva confirmada. ¡El asiento es tuyo!");
        cancelTimer.cancel(); // **Se detiene el temporizador para evitar cancelaciones tardías**
    } else {
        System.out.println("❌ Has cancelado tu reserva. El asiento vuelve a estar disponible.");
        zonaSeleccionada[asientoReservaTemp - 1] = disponible; // **Se libera el asiento manualmente**
        variable++;
        cancelTimer.cancel(); // **También se cancela el temporizador para evitar ejecuciones innecesarias**
    }
} else {
    tecla2.next();
    System.out.println("ERROR : Opción inválida");
}
            }
        } else {
            tecla2.next();
            System.out.println("ERROR : Opción inválida");
            continue;
        }

        System.out.println("\n¿Desea reservar otro asiento? 1)Sí / 2)Salir): ");
        seguir = tecla2.nextInt();
        tecla2.nextLine();

        if (seguir != 1) {
            break; // Ahora sí regresa al menú si el usuario elige salir
        }
    }
}
            
            
            
           else if (opcion == 2) {  
    int fila = 0;
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

        System.out.println("Seleccione una fila(1 , 2 , 3 , 4):");

        if (tecla2.hasNextInt()) {
            fila = tecla2.nextInt();
            tecla2.nextLine();
        } else {
            tecla2.next();
            System.out.println("ERROR : Opcion inválida");
            continue;
        }
    }

    String[] zonaSeleccionada;
    int precio;

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
            System.out.println("Ingresa una opción válida");
            continue;
        }
    }

    // **Validación de asientos libres, ocupados o reservados**
    System.out.println("Seleccione el número de asiento (1 a " + asientos + "): ");

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
    if (zonaSeleccionada[asiento - 1].equals(reservado)) {
        System.out.println("Ese asiento está reservado y no se puede comprar.");
        continue;
    }

    tecla2.nextLine();
    zonaSeleccionada[asiento - 1] = ocupado; // **El asiento ahora está comprado**

    int estudiante = 0;
    while (estudiante < 1 || estudiante > 2) {
        System.out.println("¿Es estudiante? (1 = Sí / 2 = No): ");

        if (tecla2.hasNextInt()) {
            estudiante = tecla2.nextInt();
            tecla2.nextLine();
        } else {
            tecla2.next();
            System.out.println("ERROR : Opcion inválida");
        }
    }

    int edad = 0;
    while (edad < 1 || edad > 120) {
        System.out.println("¡Se aplicara el descuento si cumple las condiciones!");
        System.out.println("Ingrese su edad: ");
        edad = tecla2.nextInt();
        tecla2.nextLine();
        double descuento = 0;

        if (edad < 1 || edad > 120) {
            System.out.println("Edad inválida.");
            continue;
        } else if (edad >= 55) {
            descuento = 0.15;
            System.out.println("¡Se agregó el descuento adulto mayor!");
        } else if (estudiante == 1 && edad >= 3) {
            descuento = 0.10;
            System.out.println("¡Se agregó el descuento estudiante!");
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

 System.out.println("\n¿Desea realizar otra compra? 1)Sí / 2)No): ");
seguir = tecla2.nextInt();
tecla2.nextLine();
if (seguir != 1) {

    continue; // Regresa al menú en lugar de continuar en compras
}
           }     
           
else if (opcion == 3) {  
    System.out.println("==== ::::::::::: ====");
    System.out.println(":::|| CARRITO ||:::");

    if (totalFinal >= 1) {
        for (int i = 0; i < totalFinal; i++) {
            System.out.println("");
            System.out.print("Entrada #" + (i + 1) + " || ");
            System.out.print("Zona: " + zonasCompradas[i] + " || ");
            System.out.print("Asiento: " + asientosComprados[i] + " || ");
            System.out.printf(" Precio: $%.0f\n", preciosFinales[i]);
        }
    } else {
        System.out.println("El carrito está vacío.");
        continue;
    }

    System.out.println("");
    System.out.println("1) Eliminar entrada\n2) Cambiar entrada entrada\n0) Salir");
    seguir = tecla2.nextInt();
    tecla2.nextLine();

    if (seguir == 1) {  
    System.out.println("Ingrese el número de entrada a eliminar (Ejemplo: Si ve 'Entrada #1', ingrese 1): ");
    int entradaEliminar = tecla2.nextInt() - 1; // **Ajuste para que el usuario seleccione correctamente**
    tecla2.nextLine();

    if (entradaEliminar >= 0 && entradaEliminar < totalFinal) {  
        int asientoEliminado = asientosComprados[entradaEliminar];
        String zonaEliminada = zonasCompradas[entradaEliminar];

        totalFinal--;
        variable++;

        // **Liberar asiento eliminado**
        String[] zonaArray;
        switch (zonaEliminada) {
            case "VIP" -> zonaArray = vip;
            case "Palcos" -> zonaArray = palcos;
            case "Platea Alta" -> zonaArray = plateaAlta;
            case "Platea Baja" -> zonaArray = plateaBaja;
            default -> {
                System.out.println("❌ Zona inválida.");
                continue;
            }
        }
        zonaArray[asientoEliminado - 1] = disponible;

        System.out.println("✅ Entrada eliminada, el asiento ahora está disponible.");
    } else {
        System.out.println("❌ Número de entrada inválido.");
    }
} else if (seguir == 2) {  
    System.out.println("Ingrese el número de entrada a modificar (Ejemplo: Si ve 'Entrada #1', ingrese 1): ");
    int entradaModificar = tecla2.nextInt() - 1; // **Ajuste para que el usuario seleccione correctamente**
    tecla2.nextLine();

    if (entradaModificar >= 0 && entradaModificar < totalFinal) {  
        // **Liberar el asiento anterior**
        int asientoAnterior = asientosComprados[entradaModificar];
        String zonaAnterior = zonasCompradas[entradaModificar];

        String[] zonaAnteriorArray;
        switch (zonaAnterior) {
            case "VIP" -> zonaAnteriorArray = vip;
            case "Palcos" -> zonaAnteriorArray = palcos;
            case "Platea Alta" -> zonaAnteriorArray = plateaAlta;
            case "Platea Baja" -> zonaAnteriorArray = plateaBaja;
            default -> {
                System.out.println("❌ Zona inválida.");
                continue;
            }
        }
        zonaAnteriorArray[asientoAnterior - 1] = disponible;
        variable++;

        System.out.println("Seleccione la nueva fila (1 , 2 , 3 , 4): ");
        int nuevaFila = tecla2.nextInt();
        tecla2.nextLine();

        String[] zonaSeleccionada;
        switch (nuevaFila) {
            case 1 -> zonaSeleccionada = vip;
            case 2 -> zonaSeleccionada = palcos;
            case 3 -> zonaSeleccionada = plateaAlta;
            case 4 -> zonaSeleccionada = plateaBaja;
            default -> {
                System.out.println("❌ Opción inválida.");
                continue;
            }
        }
        System.out.println("Seleccione el nuevo número de asiento (1 a " + asientos + "): ");
        int nuevoAsiento = tecla2.nextInt();
        tecla2.nextLine();

        if (nuevoAsiento < 1 || nuevoAsiento > asientos || zonaSeleccionada[nuevoAsiento - 1].equals(ocupado) || zonaSeleccionada[nuevoAsiento - 1].equals(reservado)) {
            System.out.println("❌ Ese asiento ya está reservado o comprado.");
            continue;
        }

        // **Marcar el nuevo asiento como ocupado**
        zonaSeleccionada[nuevoAsiento - 1] = ocupado;
        variable--;

        System.out.println("Ingrese su edad: ");
        int nuevaEdad = tecla2.nextInt();
        tecla2.nextLine();

        double descuento = 0;
        if (nuevaEdad >= 65) descuento = 0.15;
        else if (nuevaEdad >= 17) descuento = 0.10;

        double nuevoPrecio = preciosFinales[entradaModificar] - (preciosFinales[entradaModificar] * descuento);

        // **Actualizar compra**
        zonasCompradas[entradaModificar] = nombreZona;
        asientosComprados[entradaModificar] = nuevoAsiento;
        preciosFinales[entradaModificar] = nuevoPrecio;
        descuentosAplicados[entradaModificar] = (int) (descuento * 100);

        System.out.println("✅ Entrada modificada con éxito.");
    } else {
        System.out.println("❌ Número de entrada inválido.");
    }

    } else if (seguir == 0) {
        System.out.println("Volviendo al menú principal...");
        break;
    }
}      
else if (opcion == 4) {  
    if (totalFinal == 0) {  
        //verifica si hay o no elementos dentro de compras para continuar con la boleta
        System.out.println("❌ No hay entradas en tus compras. Agrega una antes de generar la Boleta.");
        continue; // **Regresa al menú sin mostrar el voucher**
    }

    System.out.println("\n:::- BOLETA FINAL -:::");
    totalGeneral = 0; // Reiniciar el total para calcular correctamente

    for (int i = 0; i < totalFinal; i++) {
        System.out.println("Entrada #" + (i + 1));
        System.out.println("Zona: " + zonasCompradas[i]);
        System.out.println("Asiento: " + asientosComprados[i]);
        System.out.println("Descuento aplicado: " + descuentosAplicados[i] + "%");
        System.out.printf("Precio: $%.0f\n", preciosFinales[i]);
        System.out.println();
        totalGeneral += preciosFinales[i];
    }

    System.out.printf("Total a pagar: $%.0f\n", totalGeneral);
    System.out.println("");

    // **Cálculo de entradas vendidas**
    int totalVendidas = 0;

    for (int i = 0; i < asientos; i++) {
        if (vip[i].equals(ocupado)) totalVendidas++;
        if (palcos[i].equals(ocupado)) totalVendidas++;
        if (plateaAlta[i].equals(ocupado)) totalVendidas++;
        if (plateaBaja[i].equals(ocupado)) totalVendidas++;
    }

    System.out.println("Total de entradas vendidas: " + totalVendidas);
    System.out.println("");

    System.out.println(teatro);
    System.out.println("¡Gracias por su compra!\n¡Disfrute la función!");

    break;
}else {
    break;
}
 }
 
    }

    }