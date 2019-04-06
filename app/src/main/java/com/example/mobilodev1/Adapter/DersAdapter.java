package com.example.mobilodev1.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobilodev1.Entity.Ders;
import com.example.mobilodev1.Listener.DersListener;
import com.example.mobilodev1.R;

import java.util.ArrayList;

public class DersAdapter extends RecyclerView.Adapter<DersAdapter.DersViewHolder>{

    private ArrayList<Ders> dersler;
//    private Context context ;
    private DersListener listener;

    public DersAdapter(ArrayList<Ders> dersler, DersListener listener) {
        this.dersler = dersler;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_ders,viewGroup,false);
        return new DersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DersViewHolder dersvh, int i) {
        dersvh.ders.setText(dersler.get(i).getAd());
        dersvh.not.setText(Float.toString(dersler.get(i).getNot()));
    }

    @Override
    public int getItemCount() {
        return dersler.size();
    }

    public class DersViewHolder extends RecyclerView.ViewHolder{
        TextView ders,not;
        CardView cv ;
        public DersViewHolder(@NonNull View itemView) {
            super(itemView);
            ders = itemView.findViewById(R.id.ders);
            not = itemView.findViewById(R.id.not);
            cv = itemView.findViewById(R.id.derscv);
            cv.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    listener.onClick(view , getAdapterPosition());
                }
            });
        }
    }
}
