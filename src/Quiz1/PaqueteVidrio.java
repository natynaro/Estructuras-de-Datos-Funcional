package Quiz1;

public class PaqueteVidrio extends PaqueteReciclaje{
	 
	private VidrioVerde tipoVidrioVerde;
	private VidrioAmbar tipoVidrioAmbar;
	private VidrioIncoloro tipoVidrioIncoloro;
	private double kgIncoloro;
	private double kgVerde; 
	private double kgAmbar;
	
	public PaqueteVidrio(String barrio, double kg, boolean aceptable, double kgmalos, double kgIncoloro, double kgVerde,
			double kgAmbar) {
		super(barrio, kg, aceptable, kgmalos);
		this.kgIncoloro = kgIncoloro;
		this.kgVerde = kgVerde;
		this.kgAmbar = kgAmbar;
		tipoVidrioVerde= new VidrioVerde(kgVerde);
		tipoVidrioAmbar= new VidrioAmbar(kgAmbar);
		tipoVidrioIncoloro= new VidrioIncoloro(kgIncoloro);
	}

	public VidrioVerde getTipoVidrioVerde() {
		return tipoVidrioVerde;
	}

	public void setTipoVidrioVerde(VidrioVerde tipoVidrioVerde) {
		this.tipoVidrioVerde = tipoVidrioVerde;
	}

	public VidrioAmbar getTipoVidrioAmbar() {
		return tipoVidrioAmbar;
	}

	public void setTipoVidrioAmbar(VidrioAmbar tipoVidrioAmbar) {
		this.tipoVidrioAmbar = tipoVidrioAmbar;
	}

	public VidrioIncoloro getTipoVidrioIncoloro() {
		return tipoVidrioIncoloro;
	}

	public void setTipoVidrioIncoloro(VidrioIncoloro tipoVidrioIncoloro) {
		this.tipoVidrioIncoloro = tipoVidrioIncoloro;
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
	
	
	 
}
