package EjercicioRectangulo;

import java.io.*;

public class Rectangulo {
	private double ancho;
	private double altura;
	
	public Rectangulo() throws IOException, ClassNotFoundException {
		//ancho=0;
		//altura=0;
		//cargarFichero();
	}
	
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double calcularPerimetro() {
		double perimetro= ((this.altura * 2)+ (this.ancho * 2));
		return perimetro;
		
		
	}
	public double calcularArea() {
		double area=(this.altura * this.ancho);
		return area;
	}

	public String toString() {
		return "Rectangulo [ancho=" + ancho + ", altura=" + altura + "]";
	}
	
	public void cargarFichero() throws IOException, ClassNotFoundException {
		crearFichero();
		File hi= new File("alt.txt");
		
		if(	hi.canRead()) {
			FileInputStream fs= new FileInputStream("alt.txt");
			ObjectInputStream fr= new ObjectInputStream(fs);
			altura=(double)fr.readObject();
			fr.close();
			fs.close();
		}else System.out.println("llorela");
		
		
		FileInputStream fp= new FileInputStream("anch.txt");
		ObjectInputStream fz= new ObjectInputStream(fp);
		ancho=(double)fz.readObject();
		fp.close();
		fz.close();
		
		
	}
	
	public void crearFichero() throws IOException {
		File fl=new File("alt.txt");
		if(!fl.exists()) {
			fl.createNewFile();
		}
		File ft=new File("anch.txt");
		if(!ft.exists()) {
			ft.createNewFile();
		}
	}
	
	public void guardarFichero() throws IOException {
		crearFichero();
		FileOutputStream emm=new FileOutputStream("alt.txt");
		ObjectOutputStream mme= new ObjectOutputStream(emm);
		mme.writeObject(altura);
		emm.close();
		mme.close();
		
		FileOutputStream emo=new FileOutputStream("anch.txt");
		ObjectOutputStream ome= new ObjectOutputStream(emo);
		ome.writeObject(ancho);
		emo.close();
		ome.close();
	}
	
	
	
}
