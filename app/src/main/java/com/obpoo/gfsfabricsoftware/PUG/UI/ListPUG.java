package com.obpoo.gfsfabricsoftware.PUG.UI;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.PUG.Adapter.NLadapter;
import com.obpoo.gfsfabricsoftware.PUG.MVP.NearestLocation.NLView;
import com.obpoo.gfsfabricsoftware.PUG.MVP.NearestLocation.NLpresenterImpl;
import com.obpoo.gfsfabricsoftware.PUG.Model.NLData;
import com.obpoo.gfsfabricsoftware.PUG.Model.NLdataItems;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListPUG#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListPUG extends Fragment implements NLView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    NLpresenterImpl presenter;
    @BindView(R.id.pug_recycle)
    RecyclerView pug_recycle;
    @BindView(R.id.pbatPUGlist)
    ProgressBar progressBar;

    public ListPUG() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment ListPUG.
     */
    // TODO: Rename and change types and number of parameters
    public static ListPUG newInstance() {
        ListPUG fragment = new ListPUG();

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
        View view = inflater.inflate(R.layout.fragment_list_pug, container, false);
        ButterKnife.bind(this,view);
        presenter = new NLpresenterImpl(this);
        presenter.onGetNLlatLng("view_all");
        return view;
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
    public void showDialog() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideDialog() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onGetNLResponse(NLData response) {
        Log.i("NLDataListView", response.getMessage());
        ArrayList<NLdataItems> NLdataList = new ArrayList<>();
        NLdataList = response.getData();

        NLadapter nLadapter = new NLadapter(getActivity(), NLdataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        pug_recycle.setLayoutManager(linearLayoutManager);
        pug_recycle.setAdapter(nLadapter);
        nLadapter.notifyDataSetChanged();


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
