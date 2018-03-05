package appjpm4everyone.recyclerview_fragment;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import appjpm4everyone.recyclerview_fragment.Entidades.SeleccionesFutbol;
import appjpm4everyone.recyclerview_fragment.fragments.DetalleSeleccionFragment;
import appjpm4everyone.recyclerview_fragment.fragments.ListaSeleccionesFragment;
import appjpm4everyone.recyclerview_fragment.interfaces.Comunicador_Fragments;
import appjpm4everyone.recyclerview_fragment.utilidades.Utilidades;

//Cuando trabajo con Fragment debo implementar si trabajo con un SDK 16 o inferior

public class MainActivity extends AppCompatActivity implements
        ListaSeleccionesFragment.OnFragmentInteractionListener ,
        DetalleSeleccionFragment.OnFragmentInteractionListener, Comunicador_Fragments{

    //Creo las instancias de los Fragments
    ListaSeleccionesFragment listaFragment;
    DetalleSeleccionFragment detalleFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Verificacion si esta en mdo Portrait
        //Si existe el id del modo Portrait
        if(findViewById(R.id.FragmentContenedor)!=null){
            //Modo Portrait
            Utilidades.portrait=true;
            if(savedInstanceState!=null) {
                return;
            }
                //Casting de las variables creadas
                listaFragment = new ListaSeleccionesFragment();

                //Para cargar los fragment en un layout diferente
                //Busco el Fragment creado () en el XML del main) y lo remplazo por lo que necesito
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.FragmentContenedor,listaFragment).commit();
        }else{//Modo Landscape
            Utilidades.portrait=false;
        }





    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarSeleccion(SeleccionesFutbol seleccionesFutbol) {

        //Casting del FragmentDetalle en modo Landscape
        detalleFragment = (DetalleSeleccionFragment)
                this.getSupportFragmentManager().findFragmentById(R.id.fragmentDetalle);

        //Verificamos que existe el Modo Landscape y no existe el Modo Portrait
        if(detalleFragment!=null && findViewById(R.id.FragmentContenedor)==null) {
            detalleFragment.asignaciónLandscape(seleccionesFutbol);
        }
        else {  //Modo Portrait
            detalleFragment = new DetalleSeleccionFragment();
            //Creo el Bundle para el envío de información entre Atividades
            Bundle bundleEnviar = new Bundle();
            bundleEnviar.putSerializable("objetoFutbol", seleccionesFutbol);
            detalleFragment.setArguments(bundleEnviar);

            //Cargar el Fragment en la actividad
            // addToBackStack(null), es para un envío más eficiente
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.FragmentContenedor, detalleFragment).addToBackStack(null).commit();
        }
    }
}
