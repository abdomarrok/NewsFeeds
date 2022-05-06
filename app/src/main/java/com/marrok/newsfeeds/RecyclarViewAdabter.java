package com.marrok.newsfeeds;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclarViewAdabter  extends RecyclerView.Adapter<RecyclarViewAdabter.ViewHolder>{
    private static final String TAG = "RecyclarViewAdabter";
    Context context;
    private ArrayList<NewsItem> news =new ArrayList<>();
    public void setNews(ArrayList<NewsItem> news) {
        this.news=news;

    }

    public RecyclarViewAdabter(Context context) {
        this.context = context;
    }

    public RecyclarViewAdabter() {

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtTitle.setText(news.get(position).getTitle());
        holder.txtDesc.setText(news.get(position).getDesc());
        holder.txtDate.setText(news.get(position).getDate());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: navigate to user webview
                Intent intent = new Intent(context,WebviViewActivity.class);
                intent.putExtra("url",news.get(position).getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtDate,txtDesc,txtTitle;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initWidget(itemView);
        }

        private void initWidget(View iteView) {
            txtDate = iteView.findViewById(R.id.txt_date);
            txtDesc = iteView.findViewById(R.id.txt_discrption);
            txtTitle = iteView.findViewById(R.id.txtTitle);
            parent = iteView.findViewById(R.id.mcardview);
        }
    }
}
