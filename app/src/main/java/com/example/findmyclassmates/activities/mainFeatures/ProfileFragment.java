package com.example.findmyclassmates.activities.mainFeatures;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.findmyclassmates.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private TextView textViewFirstName;
    private EditText editTextFirstName;
    private TextView textViewLastName;
    private EditText editTextLastName;
    private TextView textViewStudentID;
    private EditText editTextStudentID;
    private Button buttonSave;
    private Button buttonCancel;
    private TextView invalidBlank;
    private TextView invalidStudentID;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(/*String param1, String param2*/) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        textViewFirstName = view.findViewById(R.id.textViewFirstName);
        editTextFirstName = view.findViewById(R.id.editTextFirstName);
        textViewLastName = view.findViewById(R.id.textViewLastName);
        editTextLastName = view.findViewById(R.id.editTextLastName);
        textViewStudentID = view.findViewById(R.id.textViewStudentID);
        editTextStudentID = view.findViewById(R.id.editTextStudentID);
        buttonSave = view.findViewById(R.id.buttonSave);
        buttonCancel = view.findViewById(R.id.buttonCancel);
        invalidBlank = view.findViewById(R.id.invalidBlank);
        invalidStudentID = view.findViewById(R.id.invalidStudentID);



        // Set click listener for the TextView to enable editing
        textViewFirstName.setOnClickListener(v -> enableEditing(textViewFirstName, editTextFirstName));
        textViewLastName.setOnClickListener(v -> enableEditing(textViewLastName, editTextLastName));
        textViewStudentID.setOnClickListener(v -> enableEditing(textViewStudentID, editTextStudentID));
        // Set click listener for the "Save" button
        buttonSave.setOnClickListener(v -> saveChanges());
        // Set click listener for the "Cancel" button
        buttonCancel.setOnClickListener(v -> cancelChanges());
        // Initially, the buttons are hidden
        buttonSave.setVisibility(View.GONE);
        buttonCancel.setVisibility(View.GONE);


        return view;
        //return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    private void enableEditing(TextView textView, EditText editText) {
        textView.setVisibility(View.GONE);
        editText.setVisibility(View.VISIBLE);
        editText.setText(textView.getText());
        editText.requestFocus();
        buttonSave.setVisibility(View.VISIBLE);
        buttonCancel.setVisibility(View.VISIBLE);
    }

    private void saveChanges() {
        invalidBlank.setVisibility(View.GONE);
        invalidStudentID.setVisibility(View.GONE);
        if(editTextFirstName.getVisibility()==View.VISIBLE)
        {
            String newFirstName = editTextFirstName.getText().toString().trim();
            if (newFirstName.isEmpty())
            {
                //set textview visible
                invalidBlank.setVisibility(View.VISIBLE);
            }
            else {
            textViewFirstName.setText(newFirstName);
            }
        }
        if(editTextLastName.getVisibility()==View.VISIBLE)
        {
            String newLastName = editTextLastName.getText().toString().trim();
            if (newLastName.isEmpty())
            {
                //set textview visible
                invalidBlank.setVisibility(View.VISIBLE);
            }
            else {
                textViewLastName.setText(newLastName);
            }
        }
        if(editTextStudentID.getVisibility()==View.VISIBLE)
        {
            String newStudentID = editTextStudentID.getText().toString().trim();
            if (newStudentID.isEmpty())
            {
                //set textview visible
                invalidBlank.setVisibility(View.VISIBLE);
            }
            if (newStudentID.length()!=10)
            {
                //set textview visible
                invalidStudentID.setVisibility(View.VISIBLE);
            }
            else {
                try {
                    Integer.parseInt(newStudentID);
                    //System.out.println("The string is an integer: " + number);
                    textViewStudentID.setText(newStudentID);
                } catch (NumberFormatException e) {
                    //set textview visible
                    invalidStudentID.setVisibility(View.VISIBLE);
                    //System.out.println("The string is not an integer.");
                }
            }
        }
        // Hide the EditText field
        editTextFirstName.setVisibility(View.INVISIBLE);
        editTextLastName.setVisibility(View.INVISIBLE);
        editTextStudentID.setVisibility(View.INVISIBLE);
        // Show the TextView
        textViewFirstName.setVisibility(View.VISIBLE);
        textViewLastName.setVisibility(View.VISIBLE);
        textViewStudentID.setVisibility(View.VISIBLE);
        //make buttons invisible
        buttonSave.setVisibility(View.INVISIBLE);
        buttonCancel.setVisibility(View.INVISIBLE);
    }

    public void cancelChanges() {
        // Hide the EditText field
        editTextFirstName.setVisibility(View.INVISIBLE);
        editTextLastName.setVisibility(View.INVISIBLE);
        editTextStudentID.setVisibility(View.INVISIBLE);
        // Show the TextView
        textViewFirstName.setVisibility(View.VISIBLE);
        textViewLastName.setVisibility(View.VISIBLE);
        textViewStudentID.setVisibility(View.VISIBLE);
        //make buttons invisible
        buttonSave.setVisibility(View.GONE);
        buttonCancel.setVisibility(View.GONE);
    }

}