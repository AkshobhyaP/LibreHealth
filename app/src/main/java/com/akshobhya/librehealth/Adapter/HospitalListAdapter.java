package com.akshobhya.librehealth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.akshobhya.librehealth.R;

import java.util.ArrayList;

public class HospitalListAdapter extends RecyclerView.Adapter<ViewHolder_rv_fragment_doctor> {

    Context context;
    ArrayList<String> list_name;
    ArrayList<String> list_address;
    ArrayList<String> list_contact;

    public HospitalListAdapter(Context c, ArrayList<String> name, ArrayList<String> address, ArrayList<String> contact) {
        context = c;
        list_name = name;
        list_address = address;
        list_contact = contact;
    }

    @Override
    public ViewHolder_rv_fragment_doctor onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_hospital, parent, false);
        return new ViewHolder_rv_fragment_doctor(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_rv_fragment_doctor holder, final int position) {
        holder.textview_card_hospital_name.setText(list_name.get(position));
        holder.button_card_direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri addressUri = Uri.parse("geo:0,0?q=" + list_address.get(position));
                Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);
                context.startActivity(intent);
            }
        });
    holder.button_card_contact.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri contactUri =Uri.parse("tel:"+list_contact.get(position));
            Intent intent = new Intent(Intent.ACTION_DIAL,contactUri);
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return list_name.size();
    }
}

class ViewHolder_rv_fragment_doctor extends ViewHolder {
    TextView textview_card_hospital_name;
    Button button_card_direction;
    Button button_card_contact;

    public ViewHolder_rv_fragment_doctor(@NonNull View itemView) {
        super(itemView);
        textview_card_hospital_name = itemView.findViewById(R.id.textview_card_name);
        button_card_contact = itemView.findViewById(R.id.button_card_contact);
        button_card_direction = itemView.findViewById(R.id.button_card_direction);
    }
}
