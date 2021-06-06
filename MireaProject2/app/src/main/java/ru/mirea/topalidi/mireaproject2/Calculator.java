package ru.mirea.topalidi.mireaproject2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculator extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Calculator() {
        // Required empty public constructor
    }
    public static Calculator newInstance(String param1, String param2) {
        Calculator fragment = new Calculator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    Button btnSumm;
    Button btnMin;
    Button btnUmn;
    Button btnDel;
    TextView textViewRes;
    EditText editText;
    EditText editText1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_calculator, container, false);
        btnSumm = (Button) root.findViewById(R.id.button);
        btnMin = (Button) root.findViewById(R.id.button2);
        btnUmn = (Button) root.findViewById(R.id.button3);
        btnDel = (Button) root.findViewById(R.id.button4);
        editText = (EditText) root.findViewById(R.id.editTextTextPersonName2);
        editText1 = (EditText) root.findViewById(R.id.editTextTextPersonName);
        textViewRes = (TextView) root.findViewById(R.id.textView2);
        btnSumm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                int a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                int b1 = Integer.parseInt(b.trim());
                double k = a1 + b1;
                String str1 = Double.toString(k);
                textViewRes.setText(str1);
            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                int a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                int b1 = Integer.parseInt(b.trim());

                double k1 = a1 - b1;
                String str1 = Double.toString(k1);
                textViewRes.setText(str1);
            }
        });
        btnUmn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                int a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                int b1 = Integer.parseInt(b.trim());
                double k2 = a1 * b1;
                String str1 = Double.toString(k2);
                textViewRes.setText(str1);
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();
                double a1 = Integer.parseInt(a.trim());
                String b = editText1.getText().toString();
                double b1 = Integer.parseInt(b.trim());
                if (b1 == 0)
                {
                    textViewRes.setText("Can not /0");
                }
                else
                {
                    double k3 = a1 / b1;
                    String str1 = Double.toString(k3);
                    textViewRes.setText(str1);
                }

            }
        });
        return root;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */

    @Override
    public void onClick(View v) {


    }
}