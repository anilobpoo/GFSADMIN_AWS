package com.obpoo.gfsfabricsoftware.PUG.Adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obpoo.gfsfabricsoftware.PUG.Model.NLdataItems;
import com.obpoo.gfsfabricsoftware.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHD on 12/8/2018.
 */

public class NLadapter extends RecyclerView.Adapter<NLadapter.VIEWHOLDER> {
    Context context;
    ArrayList<NLdataItems> NLdatalist = new ArrayList<>();
    String emailId, mobilenumber;

    public NLadapter(Context context, ArrayList<NLdataItems> NLdatalist) {
        this.context = context;
        this.NLdatalist = NLdatalist;

    }

    @NonNull
    @Override
    public VIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pug_list, parent, false);
        VIEWHOLDER NLholder = new VIEWHOLDER(view);

        return NLholder;
    }

    @Override
    public void onBindViewHolder(@NonNull VIEWHOLDER holder, int position) {
        String url_image = "http://furnirworld.com/giovanifs/Uploads/Profile/";

        holder.Name.setText(NLdatalist.get(position).getName());
        holder.Address.setText(NLdatalist.get(position).getAddress());
        Picasso.with(context).load(url_image + NLdatalist.get(position).getPic()).into(holder.image);
        emailId = NLdatalist.get(position).getEmail();
        mobilenumber = NLdatalist.get(position).getPhone();
        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                String[] recipients = new String[]{emailId};


                emailIntent.putExtra(Intent.EXTRA_EMAIL, recipients);

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Request Order To PICKUPGUY");

                emailIntent.putExtra(Intent.EXTRA_TEXT, "This is email's message");

                emailIntent.setType("text/plain");

                context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            }
        });

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + mobilenumber));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                context.startActivity(callIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return NLdatalist.size();
    }

    class VIEWHOLDER extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.name)
        TextView Name;
        @BindView(R.id.address)
        TextView Address;
        @BindView(R.id.list_mail)
        ImageView mail;
        @BindView(R.id.list_call)
        ImageView call;
        @BindView(R.id.list_share)
        ImageView share;


        public VIEWHOLDER(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
