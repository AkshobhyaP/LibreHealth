package com.akshobhya.librehealth.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.akshobhya.librehealth.R;

import java.util.ArrayList;

import static android.view.View.GONE;

public class FirstAidAdapter extends RecyclerView.Adapter<ViewHolder_rv_firstaid> {

    Context context;
    ArrayList<String> list_name;
    ArrayList<String> list_details;

    public FirstAidAdapter(Context c, ArrayList<String> name, ArrayList<String> details) {
        context = c;
        list_name = name;
        list_details = details;
    }

    @NonNull
    @Override
    public ViewHolder_rv_firstaid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_firstaid, parent, false);
        return new ViewHolder_rv_firstaid(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder_rv_firstaid holder, int position) {
        holder.textview_card_firstaid_name.setText(list_name.get(position));
        holder.textView_card_firstaid_details.setText(list_details.get(position));
        holder.textView_card_firstaid_details.setVisibility(GONE);
        final ViewHolder_rv_firstaid holder_instance = holder;
        holder.cardview_firstaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder_instance.textView_card_firstaid_details.getVisibility() == GONE) {
                    holder_instance.textView_card_firstaid_details.setVisibility(View.VISIBLE);
                }
                else{
                holder_instance.textView_card_firstaid_details.setVisibility(View.GONE);}
            }
            });
        }

        @Override
        public int getItemCount () {
            return list_name.size();
        }
    }

    class ViewHolder_rv_firstaid extends RecyclerView.ViewHolder {
        TextView textview_card_firstaid_name;
        TextView textView_card_firstaid_details;
        CardView cardview_firstaid;

        public ViewHolder_rv_firstaid(@NonNull View itemView) {
            super(itemView);
            textview_card_firstaid_name = itemView.findViewById(R.id.textview_card_firstaid_name);
            textView_card_firstaid_details = itemView.findViewById(R.id.textview_card_firstaid_details);
            cardview_firstaid = itemView.findViewById(R.id.cardview_firstaid);
        }
    }