package com.example.my_j_son_h.comments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_j_son_h.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder> {
    Context context;
    ArrayList<data_manager> data;
    public Adapter(Context context, ArrayList<data_manager> data) {
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_item_layout,parent,false);
        viewholder viewholder=new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewholder holder, int position) {

        holder.id.setText(""+data.get(position).id);
        holder.name.setText(""+data.get(position).name);
        holder.email.setText(""+data.get(position).email);
        holder.comment.setText(""+data.get(position).comments);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
       TextView name,email,id,comment;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.re_name);
            id=itemView.findViewById(R.id.re_id);
            email=itemView.findViewById(R.id.re_email);
            comment=itemView.findViewById(R.id.re_comment);
        }
    }
}
