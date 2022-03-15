//ME DICE QUE NO LE DA PARA COMPILAR PORQUE TIENE LETRAS RARAS Y YA NO TENGO TIEMPO, EN ESTE COMENTADO ESTA EL ERROR, DESDE AHI NO ME DEJABA



import java.io.*;
import java.util.*;

import java.util.Arrays;
import java.util.Scanner;


class Estudiante{
    private String nombres;
    private String apellidos;
    private int edad;
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public Estudiante(String nombres, String apellidos, int edad) {
        super();
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    
}
public class Error extends Exception{
    public Error(){
        super("La lista no tiene estudiantes");
    }
}

public class RecEst {


    public static String[] cantidadMayoresEdad(Estudiante[] listaEstudiantes) throws Error{
        if(listaEstudiantes.length!=0){
            Estudiante[] nuevo= new Estudiante[0];
       nuevo= holaR(listaEstudiantes, 0, nuevo);
      String[] result= new String[nuevo.length];
        for(int i=0; i<nuevo.length;i++){
            result[i]=nuevo[i].getNombres();
        }
        
        return result; 
        } else throw new Error();
      
        
    } 
    
    public static Estudiante[] holaR(Estudiante[] Estudiantes, int pos, Estudiante[] result){
        if(pos==Estudiantes.length){
            if(Estudiantes[pos].getEdad()>18){
                
            result = Arrays.copyOf(result, result.length+1);
            result[result.length-1]= Estudiantes[pos];
                return result;
            }else return result;
        }else{
           if(Estudiantes[pos].getEdad()>18){
             result = Arrays.copyOf(result, result.length+1);
                result[result.length-1]= Estudiantes[pos];
                return holaR(Estudiantes, pos+1, result);
            }else return holaR(Estudiantes, pos+1, result); 
        }
    }

    public static void main(String[] args) throws Error{
        Scanner in = new Scanner(System.in);
        String l=in.nextLine();
        int t=0;
        if (l.compareTo("")!=0)
            t= Integer.parseInt(l);
        Estudiante[] listE=new Estudiante[t];
        for(int i=0;i<t;i++){
            l=in.nextLine();
            String[] a=l.split(" ");
            Estudiante e=new Estudiante(a[0], a[1],Integer.parseInt(a[2]));
            listE[i]=e;
        }        
        in.close();
        try{
             String[] nombres=RecEst.cantidadMayoresEdad(listE);
        for (String n:nombres)
           System.out.println(n);
        }catch(Error e){
            System.out.println(e);
        }
       
    }

}