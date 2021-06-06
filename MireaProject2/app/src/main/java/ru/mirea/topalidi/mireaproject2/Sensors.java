package ru.mirea.topalidi.mireaproject2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Sensors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sensors extends Fragment implements SensorEventListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView textViewBrightness;
    TextView textViewGravity;
    TextView textViewStepCounter;

    public Sensors() {
        // Required empty public constructor
    }

    public static Sensors newInstance(String param1, String param2) {
        Sensors fragment = new Sensors();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sensors, container, false);

        textViewBrightness = root.findViewById(R.id.textView3);
        textViewGravity = root.findViewById(R.id.textView4);
        textViewStepCounter = root.findViewById(R.id.textView5);

        SensorManager sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor sensorGravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        Sensor sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensorLight, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorGravity, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        return root;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT){
            float brightness = event.values[0];
            textViewBrightness.setText("Brightness" + brightness);
        }
        if (event.sensor.getType() == Sensor.TYPE_GRAVITY){
            String xGravity = String.format("%.3f", event.values[0]);
            String yGravity = String.format("%.3f", event.values[1]);
            String zGravity = String.format("%.3f", event.values[2]);
            textViewGravity.setText("Force of gravity by x: " + xGravity+ "; y: "+yGravity+"; z: "+zGravity);
        }
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            String xAccelerometer = String.format("%.3f", event.values[0]);
            String yAccelerometer = String.format("%.3f", event.values[1]);
            String zAccelerometer = String.format("%.3f", event.values[2]);
            textViewStepCounter.setText("Accelerometer by x: " + xAccelerometer + "; y: " + yAccelerometer + "; z: "+zAccelerometer);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}