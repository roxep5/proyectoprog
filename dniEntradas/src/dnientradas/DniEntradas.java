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
        int faltan=12;//variable para contar cuantas entradas faltan por vender
        int sumaentradas=0;// variable para calcular cuantas entradas se llevan vendidas
        Scanner teclado=new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("Introduzca la opcion: ");
        System.out.println("- Opción 1: comprar entradas");
        System.out.println("- Opcion 2: ver entradas vendidas con sus dnis");
        System.out.println("- Opcion 3: Cuantas entradas quedan?");
        System.out.println("- 0 para salir ");
        System.out.println("---------------------------------------");
        int opcion=0;
        opcion=teclado.nextInt();
        //Comprobamos que no introduzcan cosas no incluidas en las opciones
        while(opcion!=1&&opcion!=2&&opcion!=3){
            System.out.println("vuelva a introducir opcion:");
            opcion=teclado.nextInt();
        }
        while(opcion!=0&&faltan!=0){
            bingo=false;
            switch(opcion){
                case 1:
                    int DNIe;
                    int entradase = 0;
                    System.out.print("Introduzca DNI: ");
                    DNIe=teclado.nextInt();//introducimos dni
                    //comprobamos si existe en el array
                    for(int i=0;i<12;i++){
                        if(dni[i]==DNIe){
                            posicion=i;//guardamos la posicion donde existe el dni
                            bingo=true;
                            break;
                        }
                    }
                    //si no existe 
                    if(bingo==false){
                        dni[cn]=DNIe;
                        System.out.println("Cuantas entradas quiéres comprar?");
                        entradase=teclado.nextInt();
                        while(entradase<0||entradase>4){
                            System.out.println("introduzca numero de entradas, maximo: 4, quedan: "+faltan+" por vender ");
                            entradase=teclado.nextInt();     
                        }
                        //sumamos entradas para comprobar luego si supera el máximo de entradas disponibles
                        sumaentradas+=entradase;
                        System.out.println("sumaentradas="+sumaentradas);
                        while(sumaentradas>13){
                            System.out.println("Has superado el límite de entradas permitidas quedan: "+faltan);
                            System.out.println("------------------------------------");
                            entradase=teclado.nextInt();
                            while(entradase<0||entradase>4){
                            System.out.println("Introduzca de nuevo numero de entradas, maximo: 4, quedan: "+faltan+" por vender ");
                            entradase=teclado.nextInt();  
                            sumaentradas+=entradase;   
                        }
                            }
                        //le restamos a faltan para comprobar
                        faltan-=entradase;
                        entradas[cn]=entradase;
                        cn++;
                         System.out.println("cn "+cn);
                        
                    }
                    //si el dni ya existe
                    if(bingo){
                        if(entradas[posicion]==4){//si tiene mas de 4 entradas no se uan
                            System.out.println("ya tiene el maximo de entradas permitidas por dni: 4");
                            break;
                        }else if(entradas[posicion]<4){
                            int quedanDni=4-entradas[posicion];
                             System.out.println("Introduce cuantas entradas quieres comprar, le quedan "+quedanDni+" por comprar");
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
            if(faltan>0){
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
        }else if(faltan==0){
                System.out.println("Queda cerrada la venta de entradas al haber sido todas vendidas. SOLD OUT!!!");
        }
        }
        
    }
    
}
