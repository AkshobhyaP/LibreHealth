package com.akshobhya.librehealth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akshobhya.librehealth.R;
import com.akshobhya.librehealth.Activity.SearchFormActivity;

import java.util.ArrayList;

public class SearchListAdapter extends RecyclerView.Adapter<Viewholder_rv_searchlist> {

    Context context;
    public static ArrayList<String> id;
    ArrayList<String> name;
    ArrayList<String> father_name;
    ArrayList<String> mother_name;

    public SearchListAdapter(Context c, ArrayList<String> id, ArrayList<String> name, ArrayList<String> father_name, ArrayList<String> mother_name) {
        context = c;
        this.name = name;
        this.id = id;
        this.father_name = father_name;
        this.mother_name = mother_name;
    }

    @Override
    public Viewholder_rv_searchlist onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_search, parent, false);
        return new Viewholder_rv_searchlist(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder_rv_searchlist holder, int position) {
        holder.textView_card_name.setText(name.get(position));
        holder.textView_card_fathername.setText(father_name.get(position));
        holder.textView_card_mothername.setText(mother_name.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }
}

class Viewholder_rv_searchlist extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView textView_card_name;
    TextView textView_card_fathername;
    TextView textView_card_mothername;
    Context context;

    public Viewholder_rv_searchlist(@NonNull View itemView) {
        super(itemView);
        textView_card_name = (TextView) itemView.findViewById(R.id.rv_list_name);
        textView_card_fathername = (TextView) itemView.findViewById(R.id.rv_list_father_name);
        textView_card_mothername = (TextView) itemView.findViewById(R.id.rv_list_mother_name);
        itemView.setOnClickListener(this);
        context = itemView.getContext();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, SearchFormActivity.class);
        intent.putExtra("ID", SearchListAdapter.id.get(getAdapterPosition()));
        context.startActivity(intent);
    }

}