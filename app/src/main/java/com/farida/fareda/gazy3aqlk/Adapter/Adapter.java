package com.farida.fareda.gazy3aqlk.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.farida.fareda.gazy3aqlk.MOdle.Model;
import com.farida.fareda.gazy3aqlk.R;

import java.util.List;

/**
 * Created by fareda on 26/02/2018.
 */

public class Adapter  extends RecyclerView.Adapter<Adapter.Holder> {
Context mContext;

    Model mModel;
    List<Model> mArrayList;

    public Adapter(Context context, List<Model> arrayList) {
        mContext = context;
        mArrayList = arrayList;
    }

    @Override

    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycleitem,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        mModel=mArrayList.get(position);

        holder.title.setText(mModel.getTitle());

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        TextView title;
        public Holder(View itemView) {
            super(itemView);

            title=(TextView) itemView.findViewById(R.id.titleitem);
        }
    }
}
