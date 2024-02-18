package miprimervideojuego;

import java.util.Scanner;

/**
 * Programa que emula el juego de piedra, papel y tijera.
 * El jugador juega contra el bot y tiene que intentar ganar o perder según el proposito que salga.
 * 
 * Hay 5 intentos 
 *
 * @author Lara
 */
public class MiPrimerVideoJuego {

    /**
     * Método princpial que incia el juego
     * @param args no se utilizan argumentos de linea de comandos
     */
    public static void main(String[] args) {
// TODO code application logic here int chiquipuntos = 0;
        int chiquipuntos = 0;           //Contador de puntos del jugador, inicializado a 0
        Scanner sc = new Scanner(System.in); //Objeto Scanner para entrada de parámetros de usuario
        String opcionJugador = "";     //Jugada seleccionada por jugador, inicializada por defecto
        String opcionBot = "";         //Jugada seleccionada por bot, inicializada por defecto
        int exitoEnProposito = 1;       //Variable que indica si el jugador tiene que ganar o perder
        long inicio = System.currentTimeMillis(); //Establece el tiempo de inicio de la partida
        
        //Bucle princial del juego, cada partida son 5 enfrentamientos. 
        for (int i = 0; i < 5; i++) {
            
            //selección del proposito de manera aleatoria 
            int proposito = (int) Math.floor(Math.random() * 2 + 1);
            if (proposito == 1) {
                System.out.println("\n\tIntenta ganar"); //es necesario redondear y sumar uno porque math.radom devuelve tipo double
            }
            if (proposito == 2) {
                System.out.println("\n\tIntenta perder");
            }
            //selección de la jugada del bot de manera aleatoria (piedra, papel o tijera)
            int j = (int) Math.floor(Math.random() * 3 + 1); 
            if (j == 1) {
                opcionBot = "tijera";
                System.out.println(opcionBot); //Salida por pantalla de la opción del bot, en este caso tijera
                tijera(); //Llamada al método tijera 
            }
            if (j == 2) {
                opcionBot = "papel";
                System.out.println(opcionBot); //Salida por pantalla de la opción del bot, en este caso papel
                papel(); //Llamada al método papel
            }
            if (j == 3) {
                opcionBot = "piedra";
                System.out.println(opcionBot); //Salida por pantalla de la opción del bot, en este caso piedra
                piedra();  //Llamada el método piedra
            }
            
            //bucle que se repite mientras la opción del jugador sea la misma que del bot
            do {
                System.out.println("Introduce tu jugada");
                opcionJugador = sc.nextLine();
                if (opcionBot.equals(opcionJugador)) {
                    System.out.println("No tiene sentido que intentes empatar");
                }
            } while (opcionBot == opcionJugador);
            
            //Posibilidades para determinar los puntos en los enfrentamientos
            if (opcionJugador.equals("tijera") && (opcionBot.equals("papel"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("tijera") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("papel"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = 1;
            }
            
            //Actualización de los puntos del jugador según éxito en el propósito (ganar o perder)
            if (proposito == 2) {
                exitoEnProposito *= -1; //Se multiplica por -1 porque al ser el propósito perder es un exito haber perdido y cuenta positivo.
            }
            if (exitoEnProposito == 1) { //Si exito es 1 (positivo) es que se logró el propósito y se actualizan el numero de puntos del jugador
                chiquipuntos++; 
            }

        }
        //Calculo de la duración de la partida, mediante el cálculo del tiempo transcurrido desde el inicio al fin
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);
        //Salida por pantalla del tiempo transcurrido
        System.out.println("Has realizado el ejercicio en " + tiempo + " segundos");
        //Cálculo del número de fallos
        int nFallos = 5 - chiquipuntos;
        //Salida por pantalla de la penalización.
        System.out.println("Penalización: " + nFallos + " x 5s = " + nFallos * 5);
        //Cálculo y salida por pantalla del tiempo total sumándole la penalización
        double tiempoFinal = tiempo + nFallos * 5;
        System.out.println("Tu tiempo final es de " + tiempoFinal + " segundos");
        System.out.println("¡Vuelve a jugar con nosotros!");
        System.out.println("¡Es muy divertido!");
        
                     
        
    } //Cierre del main

    /**
    * Método tijera que permite representar graficamente una mano haciendo el gesto de cortar. 
    */
    public static void tijera() {
        System.out.println("'''\n"
                + "   _______\n"
                + "---'  ____)____\n"
                + "         ______)\n"
                + "      __________)\n"
                + "       (____)\n"
                + "---.__(___)\n"
                + "'''");
    } //Cierre del método tijera

    /**
    * Método papel que permite representar graficamente una mano estirada como si fuera un papel. 
    */
    public static void papel() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + "        ______)\n"
                + "       _______)\n"
                + "     _______)\n"
                + "---._______)");
    } //Cierre del método papel

    /**
    * Método piedra que permite representar graficamente un puño haciendo el gesto de piedra. 
    */
    public static void piedra() {
        System.out.println("'''\n"
                + "    _______\n"
                + "---'   ____)\n"
                + "       (_____)\n"
                + "       (_____)\n"
                + "       (____)\n"
                + "---.__(___)\n"
                + "'''");
            } //Cierre del método piedra
} //Cierre de la clase PiedrapPelTijeraBrain