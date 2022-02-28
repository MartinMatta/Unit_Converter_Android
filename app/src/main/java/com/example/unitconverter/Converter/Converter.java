package com.example.unitconverter.Converter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.unitconverter.Adapters.ResultListViewAdapter;
import com.example.unitconverter.Adapters.ResultModel;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public List<String> unitList;
    private String inputType;
    private Context context;

    public Converter(List<String> unitList, Context context) {
        this.unitList = unitList;
        this.context = context;
    }

    public void setInputNumber(Float inputNumber) {
    }

    public ResultListViewAdapter getResultList(boolean clear) {

        ArrayList<ResultModel> arrayOfResultModel = new ArrayList<ResultModel>();
        ResultListViewAdapter adapter = new ResultListViewAdapter(
                context, arrayOfResultModel
        );

        if (clear) {
            return adapter;
        } else {
            for (int i = 0; i < unitList.size(); i++) {
                String[] unitName = unitList.get(i).split(" ");
                adapter.add(new ResultModel(unitName[0], getResult(22.0f, unitName[1]), unitName[1]));
            }
            return adapter;
        }
    }

    public ArrayAdapter<String> getInputUnitList() {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                context, android.R.layout.simple_spinner_item, unitList
        );
        return dataAdapter;
    }

    public void setInputUnit(String inputType) {
        this.inputType = inputType.split(" ")[1];
    }

    private String getResult(float value, String unitType) {
        //return inputType;
        return String.valueOf(value);
    }

}
