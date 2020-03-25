package com.akshobhya.librehealth.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akshobhya.librehealth.R;

import java.util.ArrayList;

public class RecordsAdapter extends RecyclerView.Adapter<Viewholder_rv_records> {

    Context context;
    ArrayList<String> list_name;
    ArrayList<String> list_vaccine;
    ArrayList<String> list_date;

    public RecordsAdapter(Context c, ArrayList<String> name, ArrayList<String> vaccine,ArrayList<String> date) {
        context = c;
        list_name = name;
        list_vaccine=vaccine;
        list_date=date;
    }

    @NonNull
    @Override
    public Viewholder_rv_records onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_records, parent, false);
        return new Viewholder_rv_records(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder_rv_records holder, int position) {
        holder.textView_card_name.setText(list_name.get(position));
        holder.textView_card_vaccine.setText(list_vaccine.get(position));
        holder.textView_card_date.setText(list_date.get(position));
    }

    @Override
    public int getItemCount() {
        return list_name.size();
    }
}

class Viewholder_rv_records extends RecyclerView.ViewHolder {
    TextView textView_card_name;
    TextView textView_card_vaccine;
    TextView textView_card_date;

    public Viewholder_rv_records(@NonNull View itemView) {
        super(itemView);
        textView_card_name = (TextView) itemView.findViewById(R.id.textView_card_records_name);
        textView_card_vaccine = (TextView) itemView.findViewById(R.id.textView_card_records_vaccine);
        textView_card_date = (TextView) itemView.findViewById(R.id.textView_card_records_date);

    }
}