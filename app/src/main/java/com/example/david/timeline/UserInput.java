package com.example.david.timeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserInput extends Fragment {
    EditText activityDescription;
    EditText activityName;
    EditText timeInput;
    int time;
    String activityTitle;
    String activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_input_fragment, container, false);
        Button okButton = view.findViewById(R.id.ok_button);
        activityDescription = (EditText) view.findViewById(R.id.activity_description);
        timeInput = (EditText) view.findViewById(R.id.time_input);
        activityName = (EditText) view.findViewById(R.id.activity_name);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity = activityDescription.getText().toString();
                activityTitle = activityName.getText().toString();
                time = Integer.parseInt(timeInput.getText().toString());

                showToast(activity);
                showToast(activityTitle);
                showToast(String.valueOf(time));
            }
        });
        return view;
    }
    private void showToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }
}
