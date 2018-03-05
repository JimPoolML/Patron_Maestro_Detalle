package appjpm4everyone.recyclerview_fragment.Entidades;

import java.io.Serializable;

/**
 * Created by SIMON on 26/02/2018.
 */


//Debo implementar el Serializable para las clases, para transportar valores entre Fragments
public class SeleccionesFutbol implements Serializable {

    private String equipo;
    private String info;
    private String detalleEquipo;
    private int escudoId;
    private int imagenBandera;

    public SeleccionesFutbol() {
    }

    //Constructor de la clase
    public SeleccionesFutbol(String equipo, String info, String detalleEquipo, int escudoId, int imagenBandera) {
        this.equipo = equipo;
        this.info = info;
        this.escudoId = escudoId;
        this.detalleEquipo = detalleEquipo;
        this.imagenBandera = imagenBandera;
    }


    public String getDetalleEquipo() {
        return detalleEquipo;
    }

    public void setDetalleEquipo(String detalleEquipo) {
        this.detalleEquipo = detalleEquipo;
    }

    public int getimagenBandera() {
        return imagenBandera;
    }

    public void setimagenBandera(int imagenBandera) {
        this.imagenBandera = imagenBandera;
    }





    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getEscudoId() {
        return escudoId;
    }

    public void setEscudoId(int escudoId) {
        this.escudoId = escudoId;
    }






}
