package com.example.todolist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> tasksArr;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksArr = new ArrayList<>();
        ListView listView = findViewById(R.id.task_list);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasksArr);
        listView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(v -> {
            TaskInput taskInput= new TaskInput();
            taskInput.show(getSupportFragmentManager(), "TaskInput");
        });
    }

    public void addTask(String str) {
        tasksArr.add(str);
        adapter.notifyDataSetChanged();
    }
}
