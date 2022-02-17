package Quiz1;

public class PaqueteReciclaje {
	private String barrio;
    private double kg;
    private boolean aceptable;
    private double kgmalos; // kg que clasificaron mal o no tienen buen estado
    private double kgbuenos;
    private double kgIncoloro;
	private double kgVerde; 
	private double kgAmbar;
	private double kgDuro; 
	private double kgBlando;
	
    public PaqueteReciclaje(String barrio, double kg, boolean aceptable, double kgmalos) {
		super();
		this.barrio = barrio;
		this.kg = kg;
		this.aceptable = aceptable;
		this.kgmalos = kgmalos;
	}
    
    public PaqueteReciclaje(String barrio, double kg, boolean aceptable, double kgmalos, double kgIncoloro, double kgVerde,
			double kgAmbar) {
    	this.kgIncoloro = kgIncoloro;
		this.kgVerde = kgVerde;
		this.kgAmbar = kgAmbar;
		this.barrio = barrio;
		this.kg = kg;
		this.aceptable = aceptable;
		this.kgmalos = kgmalos;
    }
    
    public PaqueteReciclaje(String barrio, double kg, boolean aceptable, double kgmalos, double kgDuro, double kgBlando) {
    	this.kgDuro = kgDuro;
		this.kgBlando = kgBlando;
		this.barrio = barrio;
		this.kg = kg;
		this.aceptable = aceptable;
		this.kgmalos = kgmalos;
    }
    
    public void CalcularKgBuenos(){
    	
    }

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public double getKg() {
		return kg;
	}

	public void setKg(double kg) {
		this.kg = kg;
	}

	public boolean isAceptable() {
		return aceptable;
	}

	public void setAceptable(boolean aceptable) {
		this.aceptable = aceptable;
	}

	public double getKgmalos() {
		return kgmalos;
	}

	public void setKgmalos(double kgmalos) {
		this.kgmalos = kgmalos;
	}

	public double getKgbuenos() {
		return kgbuenos;
	}

	public void setKgbuenos(double kgbuenos) {
		this.kgbuenos = kgbuenos;
	}

	public double getKgIncoloro() {
		return kgIncoloro;
	}

	public void setKgIncoloro(double kgIncoloro) {
		this.kgIncoloro = kgIncoloro;
	}

	public double getKgVerde() {
		return kgVerde;
	}

	public void setKgVerde(double kgVerde) {
		this.kgVerde = kgVerde;
	}

	public double getKgAmbar() {
		return kgAmbar;
	}

	public void setKgAmbar(double kgAmbar) {
		this.kgAmbar = kgAmbar;
	}

	public double getKgDuro() {
		return kgDuro;
	}

	public void setKgDuro(double kgDuro) {
		this.kgDuro = kgDuro;
	}

	public double getKgBlando() {
		return kgBlando;
	}

	public void setKgBlando(double kgBlando) {
		this.kgBlando = kgBlando;
	}

  
    
}
