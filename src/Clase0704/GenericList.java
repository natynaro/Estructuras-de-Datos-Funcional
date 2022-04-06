package Clase0704;

public class GenericList <T extends Comparable<T>>{

    class Nodo {
        T info;
        Nodo sig;
    }
    
    private Nodo inicio;
    
    public GenericList() {
        inicio=null;
    }
      
    void insertar(T x)
    {
        Nodo nuevo = new Nodo ();
        nuevo.info = x;
        if (inicio==null) {
            inicio=nuevo;
        } else {
            if (x.compareTo(inicio.info)<0) {
                nuevo.sig=inicio;
                inicio=nuevo;
            } else {
                Nodo aux=inicio;
                Nodo atras=inicio;
                while (x.compareTo(aux.info)>=0 && aux.sig!=null) {
                    atras=aux;
                    aux=aux.sig;
                }
                if (x.compareTo(aux.info)>=0) {
                    aux.sig=nuevo;
                } else {
                    nuevo.sig=aux;
                    atras.sig=nuevo;
                }
            }
        }
    }
    /*
    public int extraer (int pos) {
        if (pos <= cantidad ())    {
            int informacion;
            if (pos == 1) {
                informacion = inicio.info;
                inicio = inicio.sig;
            } else {
                Nodo aux;
                aux = inicio;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    aux = aux.sig;
                Nodo prox = aux.sig;
                aux.sig = prox.sig;
                informacion = prox.info;
            }
            return informacion;
        }
        else
            return Integer.MAX_VALUE;
    }

    public void borrar (int pos)
    {
        if (pos <= cantidad ())    {
            if (pos == 1) {
                inicio = inicio.sig;
            } else {
                Nodo aux;
                aux = inicio;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    aux = aux.sig;
                Nodo prox = aux.sig;
                aux.sig = prox.sig;
            }
        }
    }
    
    public void intercambiar (int pos1, int pos2) {
        if (pos1 <= cantidad () && pos2 <= cantidad ())    {
            Nodo aux1 = inicio;
            for (int f = 1 ; f < pos1 ; f++)
                aux1 = aux1.sig;
            Nodo aux2 = inicio;
            for (int f = 1 ; f < pos2 ; f++)
                aux2 = aux2.sig;
            int aux = aux1.info;
            aux1.info = aux2.info;
            aux2.info = aux;
        }
    }
    
    public int mayor () {
        if (!vacia ()) {
            int may = inicio.info;
            Nodo aux = inicio.sig;
            while (aux != null) {
                if (aux.info > may)
                    may = aux.info;
                aux = aux.sig;
            }
            return may;
        }
        else
            return Integer.MAX_VALUE;
    }
    
    public int posMayor() {
        if (!vacia ())    {
            int may = inicio.info;
            int x=1;
            int pos=x;
            Nodo aux = inicio.sig;
            while (aux != null){
                if (aux.info > may) {
                    may = aux.info;
                    pos=x;
                }
                aux = aux.sig;
                x++;
            }
            return pos;
        }
        else
            return Integer.MAX_VALUE;
    }

    public int cantidad ()
    {
        int cant = 0;
        Nodo aux = inicio;
        while (aux != null) {
            aux = aux.sig;
            cant++;
        }
        return cant;
    }
    
    public boolean ordenada() {
        if (cantidad()>1) {
            Nodo aux1=inicio;
            Nodo aux2=inicio.sig;
            while (aux2!=null) {
                if (aux2.info<aux1.info) {
                    return false;
                }
                aux2=aux2.sig;
                aux1=aux1.sig;
            }
        }
        return true;
    }
    
    public boolean existe(int x) {
        Nodo aux=inicio;
        while (aux!=null) {
            if (aux.info==x)
                return true;
            aux=aux.sig;
        }
        return false;
    }
    
    public boolean vacia ()
    {
        if (inicio == null)
            return true;
        else
            return false;
    }

*/
void imprimir () {
        Nodo aux = inicio;
        while (aux != null) {
            System.out.print (aux.info + "-");
            aux = aux.sig;
        }
        System.out.println();
    }
        
    
    public static void main(String[] ar) {
    	GenericList lo=new GenericList();
        lo.insertar(10);
        lo.insertar(5);
        lo.insertar(7);
        lo.insertar(50);
        lo.imprimir();
    }
}
