package com.example.webgridcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private List<GridViewModal> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private TextView textViewTV;
    private ImageView imageViewIV;

    public GridViewAdapter(List<GridViewModal> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) context
                    .getSystemService(Context
                            .LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.gridview_item, null);
        }

        imageViewIV = convertView.findViewById(R.id.imageIV);
        textViewTV = convertView.findViewById(R.id.textTV);
        imageViewIV.setImageResource(list.get(position).getImage());
        textViewTV.setText(list.get(position).getName());
        return convertView;
    }
}
