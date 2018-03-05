package appjpm4everyone.recyclerview_fragment.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import appjpm4everyone.recyclerview_fragment.Entidades.SeleccionesFutbol;
import appjpm4everyone.recyclerview_fragment.R;
import appjpm4everyone.recyclerview_fragment.utilidades.Utilidades;

/**
 * Created by SIMON on 26/02/2018.
 */

public class AdaptadorSelecciones extends
        RecyclerView.Adapter<AdaptadorSelecciones.SeleccionesViewHolder>
        implements  View.OnClickListener{

    //Creacion de Variables del Adaptador
    ArrayList<SeleccionesFutbol> listaSelecciones;
    private View.OnClickListener listener;

    //Creo el Constructor del ArrayList
    public AdaptadorSelecciones(ArrayList<SeleccionesFutbol> listaSelecciones) {
        this.listaSelecciones = listaSelecciones;
    }


    @Override
    public SeleccionesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_equipos,null,false);
        //Configuración del RecyclerView para ocupar el tamaño de la pantalla
        RecyclerView.LayoutParams layParams = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layParams);

        view.setOnClickListener(this);
        return new SeleccionesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeleccionesViewHolder holder, int position) {
        holder.txtEquipo.setText(listaSelecciones.get(position).getEquipo());
        //Modo Portrait
        if( Utilidades.portrait==true){
            holder.txtInformacion.setText(listaSelecciones.get(position).getInfo());
        }
        holder.escudoFoto.setImageResource(listaSelecciones.get(position).getEscudoId());
    }

    @Override
    public int getItemCount() {
        return listaSelecciones.size();
    }

    //Método para el evento Click
    public  void  setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }//Final public void onClick



    public class SeleccionesViewHolder extends RecyclerView.ViewHolder {

     //Creo los componentes a trabajar con la listaSelecciones.XML
        TextView txtEquipo, txtInformacion;
        ImageView escudoFoto;


        public SeleccionesViewHolder(View itemView) {
            super(itemView);
            //Hago el Casting de las variables de listaSelecciones.XML
            txtEquipo = (TextView) itemView.findViewById(R.id.idNombre);
            //Modo Portrait
            if( Utilidades.portrait==true){
                txtInformacion = (TextView) itemView.findViewById(R.id.idInfo);
            }
            escudoFoto = (ImageView) itemView.findViewById(R.id.idImagen);


        }
    }
}
