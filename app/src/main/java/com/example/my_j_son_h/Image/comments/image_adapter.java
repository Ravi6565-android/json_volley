package com.example.my_j_son_h.Image.comments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_j_son_h.Image.Image_main_activity;
import com.example.my_j_son_h.Image.imagedata;
import com.example.my_j_son_h.R;

import java.util.ArrayList;

public class image_adapter extends RecyclerView.Adapter<image_adapter.viewholder> {

    Context context;
    ArrayList<imagedata> datas;
    public image_adapter(Context context, ArrayList<imagedata> imagedata) {
        this.context=context;
        datas=imagedata;
    }

    @NonNull
    @Override
    public image_adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_image_layout,parent,false);
        viewholder viewholder= new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull image_adapter.viewholder holder, int position) {

        holder.id.setText(""+datas.get(position).getId());
        holder.title.setText(""+datas.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView id,title;
        ImageView imagev;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.RI_id);
            title=itemView.findViewById(R.id.RI_title);
            imagev=itemView.findViewById(R.id.RI_image);
        }
    }
}
