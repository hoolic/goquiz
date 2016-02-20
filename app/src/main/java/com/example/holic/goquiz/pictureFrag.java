package com.example.holic.goquiz;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by holic on 16/2/19.
 */

public class pictureFrag extends Fragment
                         implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";





    private String choice1;
    private String choice2;

    private OnFragmentInteractionListener mListener;

    public pictureFrag() {

    }

    public void onClick(View v) {

    }


    public static pictureFrag newInstance(String param1, String param2) {
        pictureFrag fragment = new pictureFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           choice1 = getArguments().getString(ARG_PARAM1);
            choice2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        Button enter = (Button) view.findViewById(R.id.picButton);
        final EditText answer = (EditText) view.findViewById(R.id.answer);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = answer.getText().toString();

                if(txt.equalsIgnoreCase("")){
                    Toast.makeText(getActivity().getApplicationContext(),
                            "You have to guess something~",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    if (txt.equalsIgnoreCase("elizabeth")) {
                        Quizplay.score++;
                    }
                    Intent intent = new Intent(getActivity().getApplicationContext(), Quizend.class);
                    getActivity().startActivity(intent);

                }
            }

        });
        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
