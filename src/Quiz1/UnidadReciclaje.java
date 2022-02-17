package Quiz1;
import java.util.*;

public class UnidadReciclaje {
	private PaqueteReciclaje[] paquetes;
    
    public UnidadReciclaje(PaqueteReciclaje[] paquetes) {
        this.paquetes = paquetes;
    }

    // buscarPaquetes de vidrio de un barrio determinado y devolver el total de kgAmbar, kgVerde, kgIncoloro, en ese orden
    public double [] buscarPaqueteVidrio(String barrio) {
    	double[] paquetesBarrio = new double[3];
    	for(int i=0; i<paquetes.length;i++) {
    		if(paquetes[i].getBarrio().equalsIgnoreCase(barrio) &&(paquetes[i].getKgAmbar()!=50000)) {	
    			paquetesBarrio[0]=    			paquetes[i].getKgAmbar();
    			paquetesBarrio[0]=    			paquetes[i].getKgVerde();
    			paquetesBarrio[0]=    			paquetes[i].getKgIncoloro();
    		}
            
    		}
    	return paquetesBarrio; 
    	}
    	          
    
    
    // Lista barrios sin repetir en el orden de aparicion que estan en la lista de paquetes
    public String[] barriosConPaquetes() {
    	String[] paquetesBarrio = new String[5];
    	for(int i=0; i<paquetes.length;i++) {
    		int k=0;
    	 while(paquetesBarrio
    	}
    	
        return paquetesBarrio;
    }
    
    
    // Lista de kg buenos para cada uno de los barrios
    public double[] kgPorBarrios() {
        return null;
    }
    
    public double[] kgPlasticoDuro() {
        return null;
    }
}
