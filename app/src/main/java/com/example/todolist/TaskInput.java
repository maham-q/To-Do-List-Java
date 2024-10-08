package com.example.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TaskInput extends DialogFragment {

    private EditText ettaskinput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_input, container, false);
        ettaskinput = view.findViewById(R.id.ettaskinput);

        Button saveButton = view.findViewById(R.id.btnsave);
        saveButton.setOnClickListener(v -> {
            String task = ettaskinput.getText().toString();
            if (!task.isEmpty()) {
                ((MainActivity) getActivity()).addTask(task);
                dismiss();
            }
        });

        return view;
    }
}
