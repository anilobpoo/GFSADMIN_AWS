package com.obpoo.gfsfabricsoftware.PUG.UI;

import android.annotation.SuppressLint;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.obpoo.gfsfabricsoftware.PUG.MVP.NearestLocation.NLView;
import com.obpoo.gfsfabricsoftware.PUG.MVP.NearestLocation.NLpresenterImpl;
import com.obpoo.gfsfabricsoftware.PUG.Model.NLData;
import com.obpoo.gfsfabricsoftware.PUG.Model.NLdataItems;
import com.obpoo.gfsfabricsoftware.R;
import com.obpoo.gfsfabricsoftware.utilities.ConnectivityListener;
import com.obpoo.gfsfabricsoftware.utilities.ConnectivityReceiver;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapPUG.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MapPUG#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapPUG extends Fragment implements OnMapReadyCallback, ConnectivityReceiver.ConnectivityReceiverListener, NLView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    //Map Variables
    MapView mapView;
    GoogleMap map;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;
    LocationRequest mLocationRequest = new LocationRequest();
    NLView nlView;
    NLpresenterImpl presenter;
    LatLng Source_latlng;
    LatLngBounds.Builder builder;
    ArrayList<NLdataItems> NLdataList;




    public MapPUG() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * <p>
     * //     * @param param1 Parameter 1.
     * //     * @param param2 Parameter 2.
     *
     * @return A new instance of fragment MapPUG.
     */
    // TODO: Rename and change types and number of parameters
    public static MapPUG newInstance() {
        MapPUG fragment = new MapPUG();
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

    @SuppressLint("MissingPermission")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_pug, container, false);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.findPUG));
        mapView = (MapView) view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        mLocationRequest.setInterval(10);
        mLocationRequest.setFastestInterval(10);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());
        mFusedLocationClient.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    Toast.makeText(getActivity(), String.valueOf(location.getLatitude()), Toast.LENGTH_SHORT).show();
                    Source_latlng = new LatLng(location.getLatitude(), location.getLongitude());


                } else {
                    Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    // Update UI with location data
                    // ...
                    //Toast.makeText(getActivity(), String.valueOf(location.getLatitude()), Toast.LENGTH_SHORT).show();
                }
            }

            ;
        };
        presenter = new NLpresenterImpl(this);
        presenter.onGetNLlatLng("view_all");




        return view;
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        ConnectivityListener.getInstance().setConnectivityListener((ConnectivityReceiver.ConnectivityReceiverListener) this);
        mapView.onResume();
        startLocationUpdates();

    }

    @SuppressLint("MissingPermission")
    private void startLocationUpdates() {
        mFusedLocationClient.requestLocationUpdates(mLocationRequest,
                mLocationCallback,
                null /* Looper */);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);
       /* map.addMarker(new MarkerOptions().position(new LatLng(43.1, -87.9)));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(43.1, -87.9), 10));*/

    }


    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if (!isConnected) {
            Toast.makeText(getActivity(), "Internet got Disconnected", Toast.LENGTH_SHORT).show();
            Log.i("NetworkChanged", String.valueOf(isConnected));
        }

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onGetNLResponse(NLData response) {
        Log.i("NLData", response.getMessage());
        NLdataList= new ArrayList<>();
        NLdataList = response.getData();
        builder= new LatLngBounds.Builder();

        for(int i = 0;i<NLdataList.size();i++){
            double pugLat = Double.parseDouble(NLdataList.get(i).getLatitude());
            double puglon = Double.parseDouble(NLdataList.get(i).getLongitude());
            LatLng pugLatlng = new LatLng(pugLat, puglon);
            drawMarker(pugLatlng,NLdataList.get(i).getName(),NLdataList,i);
        }


       // getNearestPUG(NLdataList);                   // For Nearest Location

    }

    private void drawMarker(LatLng pugLatlng, String name, ArrayList<NLdataItems> NLdataList, int index) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(pugLatlng).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_red_300_36dp)).snippet(String.valueOf(index));
        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(getActivity(),NLdataList,index);
        map.setInfoWindowAdapter(customInfoWindow);
        Marker marker= map.addMarker(markerOptions);
        marker.setTag(index);
        System.out.println(index+"drawMArker");




        //LatLngBuilder
        builder.include(pugLatlng);
        LatLngBounds bounds = builder.build();
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 20);
        map.moveCamera(cu);
        map.animateCamera(CameraUpdateFactory.zoomTo(2), null);
    }


    private void getNearestPUG(ArrayList<NLdataItems> nLdataList) {
        List<Float> getDistanceInDouble = new ArrayList<>();
        for (int i = 0; i < nLdataList.size(); i++) {
            double pugLat = Double.parseDouble(nLdataList.get(i).getLatitude());
            double puglon = Double.parseDouble(nLdataList.get(i).getLongitude());
            LatLng pugLatlng = new LatLng(pugLat, puglon);
            if (Source_latlng != null && pugLatlng != null) {
                float[] result = new float[1];
                Location.distanceBetween(Source_latlng.latitude, Source_latlng.longitude, pugLatlng.latitude, pugLatlng.longitude, result);
                System.out.println(result[0]);
                getDistanceInDouble.add(result[0]);

            }
        }

        int index = getSmallestPUG(getDistanceInDouble, getDistanceInDouble.size());
        System.out.println("index" + index);
        LatLng smallestLatLng = new LatLng(Double.parseDouble(nLdataList.get(index).getLatitude()), Double.parseDouble(nLdataList.get(index).getLongitude()));
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(smallestLatLng).title("NearestPUG").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        Marker m = map.addMarker(markerOptions);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(43.1, -87.9), 10));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(smallestLatLng.latitude,smallestLatLng.longitude),5));

    }

    private int getSmallestPUG(List<Float> getDistanceInDouble, int size) {
        int index = 0;
        float min = getDistanceInDouble.get(0);
        for (int i = 0; i < getDistanceInDouble.size(); i++) {
            if (min > getDistanceInDouble.get(i)) {
                min = getDistanceInDouble.get(i);
                index = i;
            }
        }


        return index;


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
