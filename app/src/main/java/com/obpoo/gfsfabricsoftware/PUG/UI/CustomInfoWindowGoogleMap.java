package com.obpoo.gfsfabricsoftware.PUG.UI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.obpoo.gfsfabricsoftware.PUG.Model.NLdataItems;
import com.obpoo.gfsfabricsoftware.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by PHD on 12/8/2018.
 */

public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {

    private Context context;
    ArrayList<NLdataItems> NLdatalist = new ArrayList<>();
    int index;
    private OnInfoWindowElemTouchListener infoButtonListener;

    public CustomInfoWindowGoogleMap(Context ctx,ArrayList<NLdataItems> NLdatalist,int index){
        context = ctx;
        this.NLdatalist=NLdatalist;
        this.index=index;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.pug_list, null);

        TextView name_tv = view.findViewById(R.id.name);
        TextView Address = view.findViewById(R.id.address);
        ImageView img = view.findViewById(R.id.image);
        ImageView email = view.findViewById(R.id.list_mail);
        ImageView call = view.findViewById(R.id.list_call);
        ImageView share = view.findViewById(R.id.list_share);


        System.out.println(marker.getSnippet()+"getInfoContents");
        index=Integer.valueOf(marker.getSnippet());
        name_tv.setText(NLdatalist.get(index).getName());
        Address.setText(NLdatalist.get(index).getAddress());
        String url_image="http://furnirworld.com/giovanifs/Uploads/Profile/";
        Picasso.with(context).load(url_image+NLdatalist.get(index).getPic()).into(img);



        this.infoButtonListener = new OnInfoWindowElemTouchListener(email,context.getResources().getDrawable(R.drawable.ic_email_black_24dp),
                context.getResources().getDrawable(R.drawable.ic_email_black_24dp)) {
            @Override
            protected void onClickConfirmed(View v, Marker marker) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                String[] recipients = new String[]{NLdatalist.get(Integer.valueOf(marker.getSnippet())).getEmail()};


                emailIntent.putExtra(Intent.EXTRA_EMAIL, recipients);

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Request Order To PICKUPGUY");

                emailIntent.putExtra(Intent.EXTRA_TEXT, "This is email's message");

                emailIntent.setType("text/plain");
                context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            }
        };
        email.setOnTouchListener(infoButtonListener);

        return view;
    }
}
