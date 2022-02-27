package com.example.unitconverter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unitconverter.R;

import java.util.ArrayList;


public class ResultListViewAdapter extends ArrayAdapter<ResultModel> {

    public ResultListViewAdapter(Context context, ArrayList<ResultModel> model) {
        super(context, 0, model);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ResultModel model = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(
                    getContext()).inflate(R.layout.listview_item, parent, false
            );
        }

        TextView name = (TextView) convertView.findViewById(R.id.listview_name);
        TextView value = (TextView) convertView.findViewById(R.id.listview_value);
        TextView unit = (TextView) convertView.findViewById(R.id.listview_unit);

        name.setText(model.name);
        value.setText(model.value);
        unit.setText(model.unit);

        return convertView;
    }
}
