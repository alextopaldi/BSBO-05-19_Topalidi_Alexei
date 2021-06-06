package ru.mirea.topalidi.mireaproject2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    List<String> stories;
    Context context;

    public Adapter (Context ct, ArrayList<String> stories) {
        this.context = ct;
        this.stories = stories;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvItemStory;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
            tvItemStory = itemView.findViewById(ru.mirea.topalidi.mireaproject2.R.id.textViewStory);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvItemStory.setText(stories.get(stories.size()-1));
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.itemsst, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

}