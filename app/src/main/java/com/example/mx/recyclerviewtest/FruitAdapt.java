package com.example.mx.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 12 on 2017/10/17.
 */

public class FruitAdapt extends RecyclerView.Adapter<FruitAdapt.ViewHoder> {
    private List<Fruit> mFruitList;

    public FruitAdapt(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);
        final ViewHoder hoder=new ViewHoder(view);
        hoder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=hoder.getAdapterPosition();
                Fruit fruit=mFruitList.get(position);
                Toast.makeText(v.getContext(),"you click view"+fruit.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
        return hoder;
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {
        Fruit fruit=mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    static class ViewHoder extends RecyclerView.ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
        View fruitView;

        public ViewHoder(View itemView) {
            super(itemView);
            fruitView=itemView;
            fruitImage=(ImageView)itemView.findViewById(R.id.fruit_image);
            fruitName=(TextView) itemView.findViewById(R.id.fruit_name);
        }
    }
}
