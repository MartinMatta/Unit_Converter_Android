package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unitconverter.Adapters.ResultListViewAdapter;
import com.example.unitconverter.Adapters.ResultModel;
import com.example.unitconverter.Converter.Converter;
import com.example.unitconverter.Converter.FactoryConverter;
import com.example.unitconverter.Converter.InputUnit;

import java.util.ArrayList;
import java.util.List;

public class ConvertActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    private ArrayAdapter<String> inputUnitAdapter;
    private Converter converter;
    private TextView typeTextView;
    private ListView listView;
    private EditText inputValue;
    private Spinner spinner;
    private String typeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            typeName = (String)bundle.get("type");
            typeName = typeName.replace("cardview", "");
        }

        typeTextView = (TextView)findViewById(R.id.typeName);
        inputValue = (EditText) findViewById(R.id.inputNum);
        spinner = (Spinner) findViewById(R.id.input);
        listView = (ListView) findViewById(R.id.resultListView);

        typeTextView.setText(typeName);

        spinner.setOnItemSelectedListener(this);


        converter = FactoryConverter.createObject(typeName, this);
        //listView.setAdapter(converter.getResultList());
        inputUnitAdapter = converter.getInputUnitList();

        spinner.setAdapter(inputUnitAdapter);

        inputValue.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    result();

                    return true;
                }
                return false;
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void noInputDialog() {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(ConvertActivity.this);
        View mView = layoutInflaterAndroid.inflate(R.layout.no_input_dialog, null);
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(
                ConvertActivity.this,  R.style.CustomAlertDialog
        );
        alertDialogBuilderUserInput.setView(mView);

        AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

        Button btnCancel = (Button) mView.findViewById(R.id.btnOk);

        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                alertDialogAndroid.dismiss();
            }
        });

        alertDialogAndroid.show();

    }

    private void result() {
        hideKeyboard(ConvertActivity.this);

        converter.setInputUnit(
                spinner.getSelectedItem().toString()
        );

        if (inputValue.getText().toString().trim().length() > 0) {
            converter.setInputNumber(
                    Float.parseFloat(String.valueOf(inputValue.getText()))
            );

            listView.setAdapter(converter.getResultList(false));

        } else {
            noInputDialog();
            listView.setAdapter(converter.getResultList(true));
        }
    }
}