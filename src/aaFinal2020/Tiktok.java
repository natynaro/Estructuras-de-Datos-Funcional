package aaFinal2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Video implements Comparable<Video>{
    private String autor;
    private String id;
    private int me_gusta;
    private int visualizaciones;
    private int comentarios;
        
    
    public Video(String autor, String id, int me_gusta, int visualizaciones, int comentarios) {
        super();
        this.autor = autor;
        this.id = id;
        this.me_gusta = me_gusta;
        this.visualizaciones = visualizaciones;
        this.comentarios = comentarios;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getMe_gusta() {
        return me_gusta;
    }
    public void setMe_gusta(int me_gusta) {
        this.me_gusta = me_gusta;
    }
    public int getVisualizaciones() {
        return visualizaciones;
    }
    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }
    public int getComentarios() {
        return comentarios;
    }
    public void setComentarios(int comentarios) {
        this.comentarios = comentarios;
    }
    @Override
    public String toString() {
        return  autor + ":"+ me_gusta ;
    }
    @Override
    public int compareTo(Video arg0) {
        
        if(this.getMe_gusta()!=arg0.getMe_gusta()) {
            if( this.getMe_gusta()<arg0.getMe_gusta()) {
                return this.getMe_gusta();
            }else return arg0.getMe_gusta();
        }else if(this.getVisualizaciones()!=arg0.visualizaciones){
            if( this.getVisualizaciones()<arg0.getVisualizaciones()) {
                 return this.getMe_gusta()-1;
            }else return arg0.getMe_gusta();
        }else {
            if( this.getComentarios()<arg0.getComentarios()) {
                 return this.getMe_gusta()-1;
            }else return arg0.getMe_gusta();

        }

        
    }//AAAAH
   }




public class Tiktok {
    
    public Video[] videoOrdenado(Video[] videos) {
        //Completar funcion
        Video[] total= new Video[videos.length];
        
        PriorityQueue<Video> queue = new PriorityQueue<Video>();
        
        for(Video v:videos) {
            queue.add(v);
        }
            Stack<Video> pila = new Stack<Video>();
        int cont=0;
        for(Video v:queue) {
            pila.add(v);
        }
        for(int i=0; i<videos.length;i++) {
            total[i]=pila.pop();
        }
        return total;
        
    }
        


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        Video[] videos=new Video[0];
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] lineSplit=line.split(",");
            Video v=new Video(lineSplit[0],lineSplit[1], Integer.parseInt(lineSplit[2]),
                    Integer.parseInt(lineSplit[3]), Integer.parseInt(lineSplit[4]));
            videos=Arrays.copyOf(videos, videos.length+1);
            videos[videos.length-1]=v;
        }
        Tiktok t=new Tiktok();
        Video[] videosO=t.videoOrdenado(videos);
        for (Video v:videosO)
            System.out.println(v);
        in.close();
    
    }

}
