package appjpm4everyone.recyclerview_fragment.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import appjpm4everyone.recyclerview_fragment.Entidades.SeleccionesFutbol;
import appjpm4everyone.recyclerview_fragment.R;
import appjpm4everyone.recyclerview_fragment.adaptadores.AdaptadorSelecciones;
import appjpm4everyone.recyclerview_fragment.interfaces.Comunicador_Fragments;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaSeleccionesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaSeleccionesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaSeleccionesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //Variables a trabajar
    ArrayList<SeleccionesFutbol> listaSelecciones;
    RecyclerView recyclerSeleciones;

    //Activity para mostrar el detalle de cada selección
    Activity actividad;
    Comunicador_Fragments interfaceComunicadoraFragments;

    public ListaSeleccionesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaSeleccionesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaSeleccionesFragment newInstance(String param1, String param2) {
        ListaSeleccionesFragment fragment = new ListaSeleccionesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Cremaos las instancias del respectivo fragment.XML
        View visualizar = inflater.inflate(R.layout.fragment_lista_selecciones, container, false);

        listaSelecciones = new ArrayList<>();
        //Hacemos el puente con el View visualizar (Los fragments llevan "Puentes")
        recyclerSeleciones = (RecyclerView) visualizar.findViewById(R.id.recyclerListaSelecciones);
        //Va con un getContext() porque es un fragment
        recyclerSeleciones.setLayoutManager(new LinearLayoutManager(getContext()));

        //método para llenar el RecyclerView
        Llenado_listaSelecciones();

        //Creo una Adaptador para visualizar la información de las selecciones
        AdaptadorSelecciones adaptador =new  AdaptadorSelecciones(listaSelecciones);
        recyclerSeleciones.setAdapter(adaptador);

        //Hacemos el evento OnClickListener
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hacemos un Toast que me indique que sucedio el evento
                Toast.makeText(getContext(), "Selecciona: "
                        +listaSelecciones.get(recyclerSeleciones
                .getChildAdapterPosition(view)).getEquipo(),Toast.LENGTH_SHORT).show();

                //Vamos al detalle de cada Seleecion al hacer Click, enviando todo el objeto de una Selección
                interfaceComunicadoraFragments.enviarSeleccion(listaSelecciones.get(recyclerSeleciones.getChildAdapterPosition(view)));
            }
        });

        return visualizar;
    }

    private void Llenado_listaSelecciones() {
        //Recordar que la lista recibe (String, String, Imagen)
        listaSelecciones.add(new SeleccionesFutbol(getString(R.string.Argentina),getString(R.string.Detalle_corto_Argentina),getString(R.string.Detalle_largo_Argentina), R.drawable.argentina_escudo, R.drawable.bandera_argentina));
        listaSelecciones.add(new SeleccionesFutbol(getString(R.string.Bolivia),getString(R.string.Detalle_corto_Bolivia),getString(R.string.Detalle_largo_Bolivia), R.drawable.bolivia_escudo, R.drawable.bandera_bolivia));
        listaSelecciones.add(new SeleccionesFutbol(getString(R.string.Brasil),getString(R.string.Detalle_corto_Brasil),getString(R.string.Detalle_largo_Brasil), R.drawable.brasil_escudo, R.drawable.bandera_brasil));
        listaSelecciones.add(new SeleccionesFutbol(getString(R.string.Chile),getString(R.string.Detalle_corto_Chile),getString(R.string.Detalle_largo_Chile), R.drawable.chile_escudo, R.drawable.bandera_chile));
        listaSelecciones.add(new SeleccionesFutbol(getString(R.string.Colombia),getString(R.string.Detalle_corto_Colombia),getString(R.string.Detalle_largo_Colombia), R.drawable.colombia_escudo, R.drawable.bandera_colombia));
        listaSelecciones.add(new SeleccionesFutbol(getString(R.string.Ecuador),getString(R.string.Detalle_corto_Ecuador),getString(R.string.Detalle_largo_Ecuador), R.drawable.ecuador_escudo, R.drawable.bandera_ecuador));
        listaSelecciones.add(new SeleccionesFutbol(getString(R.string.Paraguay),getString(R.string.Detalle_corto_Paraguay),getString(R.string.Detalle_largo_Paraguay), R.drawable.paraguay_escudo, R.drawable.bandera_paraguay));
        listaSelecciones.add(new SeleccionesFutbol(getString(R.string.Peru),getString(R.string.Detalle_corto_Peru),getString(R.string.Detalle_largo_Peru), R.drawable.peru_escudo, R.drawable.bandera_peru));
        listaSelecciones.add(new SeleccionesFutbol(getString(R.string.Uruguay),getString(R.string.Detalle_corto_Uruguay),getString(R.string.Detalle_largo_Uruguay), R.drawable.uruguay_escudo, R.drawable.bandera_uruguay));
        listaSelecciones.add(new SeleccionesFutbol(getString(R.string.Venezuela),getString(R.string.Detalle_corto_Venezuela),getString(R.string.Detalle_largo_Venezuela), R.drawable.venezuela_escudo, R.drawable.bandera_venezuela));

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //Aquí verifico si el contexto le llega una actividad
        if(context instanceof  Activity){
            //Realizo el casting de dicha actividad
            this.actividad = (Activity) context;
            //Comunicacion entre el los fragments Lista y Detalle
            interfaceComunicadoraFragments = (Comunicador_Fragments) this.actividad;
        }


        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
