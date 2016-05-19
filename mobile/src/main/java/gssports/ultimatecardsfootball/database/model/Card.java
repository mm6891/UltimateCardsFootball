package gssports.ultimatecardsfootball.database.model;

/**
 * Created by manuel.molero on 29/04/2016.
 */
public class Card {

    int _id;
    String nombre;
    Atributos atributos;
	Avanzados atributosAvanzados;
    Posicion posicion;
	String player;
	String demarcacion;
    int posicionActual;
    boolean tieneBalon;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   

	public Atributos getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributos atributos) {
        this.atributos = atributos;
    }
	
	public Avanzados getAvanzados() {
        return atributosAvanzados;
    }

    public void setAvanzados(Avanzados avanzados) {
        this.atributosAvanzados = avanzados;
    }
	
	public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
	
	 public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }  
	
	public String getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public boolean isTieneBalon() {
        return tieneBalon;
    }

    public void setTieneBalon(boolean tieneBalon) {
        this.tieneBalon = tieneBalon;
    }

    // constructors
    public Card() {
    }


}
