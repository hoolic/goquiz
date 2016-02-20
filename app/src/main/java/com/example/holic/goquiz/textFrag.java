package com.example.holic.goquiz;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class textFrag extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;
    private String choice1;
    private String choice2;
    private static final String textQestion = "Question 1";
    private static final String picquestion = "Question 2";


    public textFrag() {
        // Required empty public constructor
    }

    public static textFrag newInstance(String param1, String param2) {
        textFrag fragment = new textFrag();
        Bundle args = new Bundle();
        args.putString(textQestion, param1);
        args.putString(picquestion, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onClick(View v) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            choice1 = getArguments().getString(textQestion);
            choice2 = getArguments().getString(picquestion);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_text, container, false);
        final RadioGroup group = (RadioGroup) view.findViewById(R.id.text_radio_group);

        final Button answer = (Button) view.findViewById(R.id.textSubmit);

        final RadioButton correct = (RadioButton) view.findViewById(R.id.orange);


        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(group.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "You have to choose one~",
                            Toast.LENGTH_LONG).show();
                }else {

                    if (correct.isChecked()) {
                        Quizplay.score++;
                    }
                    pictureFrag picQ = new pictureFrag();
                    FragmentManager fragmentManager = getFragmentManager();

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.Fraglayout, picQ);
                    fragmentTransaction.commit();

                }
            }
        });
        return view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}