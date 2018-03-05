package appjpm4everyone.recyclerview_fragment.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import appjpm4everyone.recyclerview_fragment.Entidades.SeleccionesFutbol;
import appjpm4everyone.recyclerview_fragment.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetalleSeleccionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetalleSeleccionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleSeleccionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //Creo las instancias del Fragmen respectivo (fragment_detalle_seleccion.XML)
    TextView txtDetalle;
    ImageView imgBandera;

    public DetalleSeleccionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleSeleccionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleSeleccionFragment newInstance(String param1, String param2) {
        DetalleSeleccionFragment fragment = new DetalleSeleccionFragment();
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
        // Casting de los objetos creados
        //Debo crear un view para hacer el puente, ya que es un fragment
        View vista=inflater.inflate(R.layout.fragment_detalle_seleccion, container, false);

        txtDetalle = (TextView) vista.findViewById(R.id.idDetalle);
        imgBandera = (ImageView) vista.findViewById(R.id.idBandera);

        //Recepción del Bundle
        Bundle bundleRecibir=getArguments();
        //Objeto con los detalle de cade equipo de Futbol
        SeleccionesFutbol equipoFutbol = null;

        //Si obtubo información
        if (bundleRecibir != null) {
            equipoFutbol = (SeleccionesFutbol) bundleRecibir.getSerializable("objetoFutbol");
            //Me{etodo para verificar sí esta en modoLandscape (Horizontal)
            asignaciónLandscape(equipoFutbol);
                   }
        return vista;
    }

    public void asignaciónLandscape(SeleccionesFutbol equipoFutbol) {
        //Asignamos a cada ojeto la información correspondiente
        imgBandera.setImageResource(equipoFutbol.getimagenBandera());
        txtDetalle.setText(equipoFutbol.getDetalleEquipo());
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
