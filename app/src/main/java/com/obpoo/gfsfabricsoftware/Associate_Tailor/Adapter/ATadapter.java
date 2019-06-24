    package com.obpoo.gfsfabricsoftware.Associate_Tailor.Adapter;

    import android.app.Activity;
    import android.content.Context;
    import android.content.Intent;
    import android.os.Build;
    import android.support.annotation.NonNull;
    import android.support.constraint.ConstraintLayout;
    import android.support.v7.widget.RecyclerView;
    import android.util.Log;
    import android.view.Gravity;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.WindowManager;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.PopupWindow;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.Spinner;
    import android.widget.TextView;

    import com.google.android.gms.vision.text.Text;
    import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponse;
    import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.ATresponseDatum;
    import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssoFabricResponse;
    import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateActivity;
    import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabircChangeRes;
    import com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel.AssociateFabricChangeURL;
    import com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP.ATpresenterImpl;
    import com.obpoo.gfsfabricsoftware.Associate_Tailor.MVP.ATview;
    import com.obpoo.gfsfabricsoftware.Associate_Tailor.UI.AssociateTailorMain;
    import com.obpoo.gfsfabricsoftware.Associate_Tailor.UI.AssociateTailorProfile;
    import com.obpoo.gfsfabricsoftware.R;

    import java.util.ArrayList;

    import butterknife.BindView;
    import butterknife.ButterKnife;

    public class ATadapter extends RecyclerView.Adapter<ATadapter.ViewHolder> implements ATview {
    ArrayList<ATresponseDatum> aTresponseDatumArrayList;
    Activity context;
    private PopupWindow mPopupWindow;
    ATpresenterImpl presenter;

    public void updateList(ArrayList<ATresponseDatum> temp){
        aTresponseDatumArrayList=temp;
        notifyDataSetChanged();

    }

    public ATadapter(ArrayList<ATresponseDatum> aTresponseDatumArrayList, Activity context) {
    this.aTresponseDatumArrayList = aTresponseDatumArrayList;
    this.context = context;
    presenter = new ATpresenterImpl(this);
    }

    @NonNull
    @Override
    public ATadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(context).inflate(R.layout.associate_tailor_request, viewGroup, false);
    ATadapter.ViewHolder assoview = new ATadapter.ViewHolder(view);
    return assoview;
    }

    @Override
    public void onBindViewHolder(@NonNull final ATadapter.ViewHolder holder, final int i) {
    holder.t_name.setText(aTresponseDatumArrayList.get(i).getTailorInfo().getAdminName());
    holder.t_email.setText(aTresponseDatumArrayList.get(i).getTailorEmail());
    holder.t_activity.setText(aTresponseDatumArrayList.get(i).getActivity());

    holder.t_profile.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in = new Intent(context, AssociateTailorProfile.class);
            in.putExtra("AssociateProfile", aTresponseDatumArrayList.get(i).getTailorInfo());
            in.putExtra("AssociateFrom", "TAILORREQUEST");
            context.startActivity(in);

        }
    });

    holder.t_status.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View popupView = inflater.inflate(R.layout.associate_tailor_ac_rej, null);
            mPopupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (Build.VERSION.SDK_INT >= 21) {
                mPopupWindow.setElevation(5.0f);
            }


            // mPopupWindow.showAtLocation(holder.popupPlace, Gravity.CENTER,0,0);
            mPopupWindow.showAsDropDown(v, 0, 0);

            View container = mPopupWindow.getContentView().getRootView();
            if (container != null) {
                WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
                p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                p.dimAmount = 0.30f;
                if (wm != null) {
                    wm.updateViewLayout(container, p);
                }
            }

            Button update_act = (Button) popupView.findViewById(R.id.update_act);
            Button cancel_act = (Button) popupView.findViewById(R.id.cancel_act);
            final EditText credit_limit = (EditText) popupView.findViewById(R.id.credit_limit);
            final EditText days_limit = (EditText) popupView.findViewById(R.id.days_limit);
            final Spinner vat_spin = (Spinner) popupView.findViewById(R.id.vat_spin);
            final Spinner cod_spin = (Spinner) popupView.findViewById(R.id.cod_spin);
            final TextView vat_text = (TextView) popupView.findViewById(R.id.vat_text);
            final TextView cod_text = (TextView) popupView.findViewById(R.id.cod_text);
            final RadioGroup rg = (RadioGroup) popupView.findViewById(R.id.radioGroup);
            RadioButton accept_rb = (RadioButton) popupView.findViewById(R.id.accept_rb);
            RadioButton reject_rb = (RadioButton) popupView.findViewById(R.id.reject_rb);

            accept_rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (aTresponseDatumArrayList.get(i).getActivity().equals("requested")) {
                        credit_limit.setVisibility(View.VISIBLE);
                        days_limit.setVisibility(View.VISIBLE);
                        vat_spin.setVisibility(View.VISIBLE);
                        cod_spin.setVisibility(View.VISIBLE);
                        vat_text.setVisibility(View.VISIBLE);
                        cod_text.setVisibility(View.VISIBLE);
                    } else {
                        credit_limit.setVisibility(View.GONE);
                        days_limit.setVisibility(View.GONE);
                        vat_spin.setVisibility(View.GONE);
                        cod_spin.setVisibility(View.GONE);
                        vat_text.setVisibility(View.GONE);
                        cod_text.setVisibility(View.GONE);
                    }
                }
            });

            reject_rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    credit_limit.setVisibility(View.GONE);
                    days_limit.setVisibility(View.GONE);
                    vat_spin.setVisibility(View.GONE);
                    cod_spin.setVisibility(View.GONE);
                    vat_text.setVisibility(View.GONE);
                    cod_text.setVisibility(View.GONE);
                }
            });


            update_act.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String act_val = "0";
                    String act_act = "";
                    int selectedAct = rg.getCheckedRadioButtonId();
                    RadioButton rb = (RadioButton) popupView.findViewById(selectedAct);
                    if (rb.getText().equals("Accept")) {
                        act_val = "1";
                        act_act = "accepted";
                    }
                    if (rb.getText().equals("Reject")) {
                        act_val = "0";
                        act_act = "Rejected";

                    }
                    String creditLimit_str = credit_limit.getText().toString();
                    String dayslimit_str = days_limit.getText().toString();
                    String vat_str = vat_spin.getSelectedItem().toString();
                    String vat_str_code, cod_str_code;
                    if (vat_str.equals("Enable")) {
                        vat_str_code = "1";
                    } else {
                        vat_str_code = "0";
                    }
                    String cod_str = cod_spin.getSelectedItem().toString();
                    if (cod_str.equals("Enable")) {
                        cod_str_code = "1";
                    } else {
                        cod_str_code = "0";
                    }

                    if (aTresponseDatumArrayList.get(i).getActivity().equals("requested")&& rb.getText().equals("Accept")) {
                        Log.i("isRequested","requested");
                        presenter.sendChangeTailorRequest("updt_status", aTresponseDatumArrayList.get(i).getTsId(), cod_str_code, vat_str_code, dayslimit_str, creditLimit_str, act_act);
                    } else {
                        presenter.sendAssociateActivity("updt_status", aTresponseDatumArrayList.get(i).getTsId(), act_act, act_val);
                    }
                }
            });


            cancel_act.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPopupWindow.dismiss();
                }
            });


        }
    });


    }

    @Override
    public int getItemCount() {
    return aTresponseDatumArrayList.size();
    }

    @Override
    public void ATretriveData(ATresponse response) {

    }

    @Override
    public void associateActicity(AssociateActivity response) {
    Log.i("AssociateActivity", response.getMessage());
    if (response.getStatus().equals("success")) {
        Intent in = new Intent(context, AssociateTailorMain.class);
        context.startActivity(in);
        context.finish();

    }


    }

    @Override
    public void assoFabrics(AssoFabricResponse response) {

    }

    @Override
    public void changeFabURL(AssociateFabricChangeURL response) {

    }

    @Override
    public void changeFabricStatus(AssociateFabircChangeRes response) {

    }

    @Override
    public void changeTailorRequest(AssociateActivity response) {
    Log.i("AssociateActivityReq", response.getMessage());
    if (response.getStatus().equals("success")) {
        Intent in = new Intent(context, AssociateTailorMain.class);
        context.startActivity(in);
        context.finish();

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

        class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.t_email)
    TextView t_email;
    @BindView(R.id.t_name)
    TextView t_name;
    @BindView(R.id.t_activity)
    TextView t_activity;
    @BindView(R.id.t_profile)
    Button t_profile;
    @BindView(R.id.t_status)
    Button t_status;
    @BindView(R.id.popupPlace)
    ConstraintLayout popupPlace;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    }
    }
