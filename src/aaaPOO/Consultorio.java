package aaaPOO;

public class Consultorio {
private int num;
private Medico[] medicos;



public Consultorio(int num, Medico[] medicos) {
	super();
	this.num = num;
	this.medicos = medicos;
}

public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public Medico[] getMedicos() {
	return medicos;
}
public void setMedicos(Medico[] medicos) {
	this.medicos = medicos;
}


}
