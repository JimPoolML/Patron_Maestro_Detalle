package appjpm4everyone.recyclerview_fragment.interfaces;

import appjpm4everyone.recyclerview_fragment.Entidades.SeleccionesFutbol;

/**
 * Created by SIMON on 27/02/2018.
 */

//Interface para comunicar objetos entre Fragments
public interface Comunicador_Fragments {
    public void enviarSeleccion(SeleccionesFutbol seleccionesFutbol);
}
