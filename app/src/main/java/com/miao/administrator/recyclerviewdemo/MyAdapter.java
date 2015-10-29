package com.miao.administrator.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/10/29.
 */
public class MyAdapter extends RecyclerView.Adapter {
    public static interface OnRecyclerViewListener {
        void onItemClick(int position);

        boolean onItemLongClick(int position);
    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    private List<Person> personList;

    public MyAdapter(List<Person> newsList) {
        this.personList = newsList;
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_item_layout, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        PersonViewHolder holder = (PersonViewHolder) viewHolder;
        holder.position = i;
        Person person = personList.get(i);
        holder.tvAge.setText(person.getAge() + "");
        holder.tvName.setText(person.getName());
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public View rootView;
        public TextView tvAge;
        public TextView tvName;
        public int position;

        public PersonViewHolder(View itemView) {
            super(itemView);

            tvAge = (TextView) itemView.findViewById(R.id.tvAge);
            tvName = (TextView) itemView.findViewById(R.id.tvName);

            rootView = itemView.findViewById(R.id.rootView);
            rootView.setOnClickListener(this);
            rootView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != onRecyclerViewListener) {
                onRecyclerViewListener.onItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (null != onRecyclerViewListener) {
                return onRecyclerViewListener.onItemLongClick(position);
            }
            return false;
        }
    }
}
