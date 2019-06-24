package com.obpoo.gfsfabricsoftware.Dashboard.UI;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.obpoo.gfsfabricsoftware.Dashboard.Adapter.Stock_article_adapter;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.DashResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.RateResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.CurveResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.Response;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert.StockAlertData;
import com.obpoo.gfsfabricsoftware.Dashboard.DataModel.previledges.PreviledgesResponse;
import com.obpoo.gfsfabricsoftware.Dashboard.MVP.ReportPresenterImpl;
import com.obpoo.gfsfabricsoftware.Dashboard.MVP.ReportView;
import com.obpoo.gfsfabricsoftware.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StockArticleFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StockArticleFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StockArticleFrag extends Fragment implements ReportView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    ReportPresenterImpl presenter;
    @BindView(R.id.recycle_sa)
    RecyclerView recycle_sa;
    Boolean isScrolling = false;
    int currentItems,totalItems,scrollOutItems;
    int page = 1;
    Stock_article_adapter adapter;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.stock_Search)
    EditText stock_Search;
    ArrayList<StockAlertData> stockAlertList;
    ArrayList<StockAlertData> stockAlertListAdded;
    int pagination =0;

    public StockArticleFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StockArticleFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static StockArticleFrag newInstance(String param1, String param2) {
        StockArticleFrag fragment = new StockArticleFrag();
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
        View view = inflater.inflate(R.layout.fragment_stock_article, container, false);
        ButterKnife.bind(this,view);
        stockAlertList = new ArrayList<>();
        stockAlertListAdded = new ArrayList<>();
        presenter= new ReportPresenterImpl(this);

        presenter.onViewStockAlert("view_stock",String.valueOf(page));

        stock_Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {
                final Handler handler = new Handler();
                if(!s.toString().equals("")) {
                    System.out.println("Enter search 1"+s.toString());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            presenter.onViewStockSearch("search_stock", s.toString());
                        }
                    }, 2000);
                }
                else{
                    System.out.println("Enter Search 2"+s.toString());
                    page=1;
                    presenter.onViewStockAlert("view_stock",String.valueOf(page));
                }
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

  /*  @Override
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
    public void onGetReportResponse(DashResponse response) {

    }

    @Override
    public void onGetExchangerate(RateResponse response) {

    }

    @Override
    public void onGetStockAlert(Response response) {
        Log.i("StockAlert",response.getMessage());

        stockAlertList=response.getData();
         final LinearLayoutManager  linearLayoutManager = new LinearLayoutManager(getActivity());;
        if(pagination == 0){
        stockAlertListAdded.addAll(stockAlertList);
        adapter = new Stock_article_adapter(getActivity(),stockAlertListAdded);

        recycle_sa.setLayoutManager(linearLayoutManager);
        recycle_sa.setAdapter(adapter);
        adapter.notifyDataSetChanged();}
        else{
            stockAlertListAdded.addAll(stockAlertList);
            adapter.notifyDataSetChanged();
        }

        recycle_sa.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling=true;

                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = linearLayoutManager.getChildCount();
                totalItems = linearLayoutManager.getItemCount();
                scrollOutItems = linearLayoutManager.findFirstVisibleItemPosition();

                if(isScrolling && (currentItems+scrollOutItems == totalItems)){
                    isScrolling =false;
                    fetchData();
                }
            }
        });


    }

    @Override
    public void onGetDSCurve(CurveResponse response) {

    }

    @Override
    public void onGetSearchStock(Response response) {
        Log.i("StockSearch",response.getMessage());

        stockAlertList=response.getData();
        adapter = new Stock_article_adapter(getActivity(),stockAlertList);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recycle_sa.setLayoutManager(linearLayoutManager);
        recycle_sa.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onGetPreviledgesStock(PreviledgesResponse response) {

    }

    private void fetchData() {
        pagination =1;
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                presenter.onViewStockAlert("view_stock",String.valueOf(page));
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        },5000);

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
