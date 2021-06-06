package ru.mirea.topalidi.mireaproject2;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.mirea.topalidi.mireaproject2.ui.fortrack;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayTrack#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class PlayTrack extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayTrack.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayTrack newInstance(String param1, String param2) {
        PlayTrack fragment = new PlayTrack();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public PlayTrack() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    Button btStop;
    Button btstart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_play_track, container, false);
        btstart = root.findViewById(R.id.button7);
        btstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(
                        new Intent(getActivity(), fortrack.class));
            }
        });
        btStop = root.findViewById(R.id.button6);
        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(
                        new Intent(getActivity(), fortrack.class));
            }
        });
        return root;
    }

    @Override
    public void onClick(View v) {

    }
}