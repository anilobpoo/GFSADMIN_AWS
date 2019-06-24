package com.obpoo.gfsfabricsoftware.PUG.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obpoo.gfsfabricsoftware.PUG.MVP.NearestLocation.NLView;
import com.obpoo.gfsfabricsoftware.PUG.Model.NLData;
import com.obpoo.gfsfabricsoftware.R;

public class MapViewPUG extends Fragment implements NLView {



    public static MapViewPUG newInstance() {
        MapViewPUG fragment = new MapViewPUG();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map_pug, container, false);
        return view;
    }

    @Override
    public void onGetNLResponse(NLData response) {

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
}
