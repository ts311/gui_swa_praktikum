package com.example.gui_swa_praktikum.ui.form;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gui_swa_praktikum.R;
import com.example.gui_swa_praktikum.http_client.MeetingService;

import java.text.SimpleDateFormat;

public class FormFragment extends Fragment {

    private FormViewModel formViewModel;

    private static Button dateStart, timeStart, dateEnd, timeEnd;
    private int year, month, day, hour, minute;
    private static TextView set_date, set_time;
    private static final int DATE_START = 0;
    private static final int TIME_START = 1;
    private static final int DATE_END = 2;
    private static final int TIME_END = 3;
    private Button saveButton;
    private MeetingService meetingService;
    private EditText meetingName, description, location, frequency, category, commit;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        formViewModel = new ViewModelProvider(this).get(FormViewModel.class);
        View root = inflater.inflate(R.layout.fragment_form, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        meetingName = root.findViewById(R.id.meeting_name);

        description = root.findViewById(R.id.description);

        location = root.findViewById(R.id.location);

        frequency = root.findViewById(R.id.frequency);

        description = root.findViewById(R.id.description);

        dateStart = (Button) root.findViewById(R.id.select_start_date);
        dateStart.setText(sdf.format(selectedDate));

        timeStart = (Button) root.findViewById(R.id.select_start_time);

        dateEnd = (Button) root.findViewById(R.id.select_end_date);
        dateEnd.setText(sdf.format(selectedDate));

        dateEnd.setText(sdf.format(selectedDate));

        timeEnd = (Button) root.findViewById(R.id.select_end_time);

        category = root.findViewById(R.id.category);

        formViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
