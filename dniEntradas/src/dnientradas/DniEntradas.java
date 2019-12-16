/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnientradas;

import java.util.Scanner;

/**
 *
 * @author Roxep
 */
public class DniEntradas {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        // TODO code application logic here
        int[] dni=new int[12];
        int[] entradas= new int[12];
        int cn=0; //contador de numeros
        int posicion=0;//variable que guarda la posicion
        boolean bingo=false;
        int faltan=12;
        int sumaentradas=0;
        Scanner teclado=new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("Introduzca la opcion: ");
        System.out.println("- Opción 1: comprar entradas");
        System.out.println("- Opcion 2: ver entradas vendidas con sus dnis");
        System.out.println("- Opcion 3: Cuantas entradas quedan?");
        System.out.println("- 0 para salir ");
        System.out.println("----------------------------------");
        int opcion=0;
        opcion=teclado.nextInt();
        while(opcion!=1&&opcion!=2&&opcion!=3){
            System.out.println("vuelva a introducir opcion:");
            opcion=teclado.nextInt();
        }
        while(opcion!=0){
            bingo=false;
            switch(opcion){
                case 1:
                    int DNIe;
                    int entradase;
                    System.out.print("Introduzca DNI: ");
                    DNIe=teclado.nextInt();
                    for(int i=0;i<12;i++){
                        if(dni[i]==DNIe){
                            posicion=i;
                            bingo=true;
                            break;
                        }
                    }
                    
                    if(bingo==false){
                        dni[cn]=DNIe;
                        System.out.println("Cuantas entradas quiéres comprar?");
                        entradase=teclado.nextInt();
                        while(entradase<0||entradase>4){
                            System.out.println("introduzca numero de entradas, maximo: 4, quedan: "+faltan+" por vender ");
                            entradase=teclado.nextInt();     
                        }
                        
                        sumaentradas+=entradase;
                        while(sumaentradas>12){
                            System.out.println("Has superado el límite de entradas permitidas quedan: "+faltan);
                            System.out.println("------------------------------------");
                            while(entradase<0||entradase>4){
                            System.out.println("Introduzca de nuevo numero de entradas, maximo: 4, quedan: "+faltan+" por vender ");
                            entradase=teclado.nextInt();     
                        }
                            }
                        sumaentradas+=entradase;
                        faltan-=entradase;
                        entradas[cn]=entradase;
                        cn++;
                         System.out.println("cn "+cn);
                        
                    }
                    if(bingo){
                        if(entradas[posicion]==4){
                            System.out.println("ya tiene el maximo de entradas permitidas por dni: 4");
                            break;
                        }else if(entradas[posicion]<4){
                            entradase=teclado.nextInt();
                            int varinter=entradas[posicion];
                            varinter+=entradase;
                             while(varinter>4){
                                 varinter-=entradase;
                            System.out.println("introduzca numero de entradas, maximo: 4, quedan: "+faltan+" llevas: "+varinter);
                            entradase=teclado.nextInt();
                            varinter+=entradase;
                        }
                             entradas[posicion]=varinter;
                        }
                        
                    }
                    break;
                case 2:
                    for(int i=0;i<dni.length;i++){
                        if(dni[i]==0){
                            break;
                        }
                    System.out.println("DNI: "+dni[i]+" ha comprado: "+entradas[i]);
                            
                        
                    }
                    break;
                case 3:
                    System.out.println("quedan "+faltan+" entradas por vender");
                    break;
                    
                           
            }
             System.out.println("----------------------------------");
        System.out.println("Introduzca la opcion: ");
        System.out.println("- Opción 1: comprar entradas");
        System.out.println("- Opcion 2: ver entradas vendidas con sus dnis");
        System.out.println("- Opcion 3: Cuantas entradas quedan?");
        System.out.println("- 0 para salir ");
        System.out.println("----------------------------------");
        opcion=teclado.nextInt();
        while(opcion!=1&&opcion!=2&&opcion!=3){
            System.out.println("vuelva a introducir opcion:");
            opcion=teclado.nextInt();
        }
        }
    }
    
}
