package gssports.ultimatecardsfootball.activity.util;

import android.util.Log;

/**
 * Created by manuel.molero on 03/05/2016.
 */
public class Constantes {
    
	public static final String PORTERO = "POR";	
	public static final String DEFENSA = "DEF";	
	public static final String CENTROCAMPISTA = "MED";	
	public static final String DELANTERO = "DEL";	
	public static final String PACKAGE_CLASS_ATRIBUTOS = "gssports.ultimatecardsfootball.database.model.Atributos";	
	public static final String PACKAGE_CLASS_AVANZADOS = "gssports.ultimatecardsfootball.database.model.Avanzados";	
   
    public Constantes() {
    }

	public enum AtaqueMovimientosSinDado{
		PaseDirecto,
		MovimientoCasillaAdyacente,
		Intercambio,
		IntercambioConBalon
	}

	public enum AtaqueMovimientosConBalon{
		PaseCorto,
		PaseLargo,
		PaseAlto,
		Regate,
		DisparoLejano,
		RemateCabeza,
		Remate,
		LanzamientoFalta,
		RegateVelocidad
	}

	public enum AtaqueMovimientosSinBalon{
		Desmarque
	}

	public enum DefensaMovimientos{
		Robo,
		Anticipacion,
		Falta,
		RemateCabeza
	}
}
