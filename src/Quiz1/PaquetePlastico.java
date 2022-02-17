package Quiz1;

public class PaquetePlastico extends PaqueteReciclaje{
	private double kgDuro; 
	private double kgBlando;
	private PlasticoDuro tipoDuro;
	private PlasticoBlando tipoBlando;	
	
	public PaquetePlastico(String barrio, double kg, boolean aceptable, double kgmalos, double kgDuro,
			double kgBlando) {
		super(barrio, kg, aceptable, kgmalos);
		this.kgDuro = kgDuro;
		this.kgBlando = kgBlando;
		tipoDuro= new PlasticoDuro (kgDuro);
		tipoBlando= new PlasticoBlando (kgBlando);
		
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

	public PlasticoDuro getTipoDuro() {
		return tipoDuro;
	}

	public void setTipoDuro(PlasticoDuro tipoDuro) {
		this.tipoDuro = tipoDuro;
	}

	public PlasticoBlando getTipoBlando() {
		return tipoBlando;
	}

	public void setTipoBlando(PlasticoBlando tipoBlando) {
		this.tipoBlando = tipoBlando;
	}
	
	
	
}
