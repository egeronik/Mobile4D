package com.example.mobile4d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mobile4d.networking.Title;
import com.example.mobile4d.networking.TitleParser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    EditText editText;
    GridView gridView;

    TitleParser titleParser ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.breedET);
        imageButton = findViewById(R.id.imageButton);
        gridView = findViewById(R.id.grView);

        titleParser = new TitleParser();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleParser.getProxy().getByBreedAndCount(editText.getText().toString(),30).enqueue(new Callback<Title>() {
                    @Override
                    public void onResponse(Call<Title> call, Response<Title> response) {
                        if (response.isSuccessful()){
                            updateGridView(response.body());
                        }else {
                            Toast.makeText(MainActivity.this,"Smf wrong", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Title> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Request failure", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    private void updateGridView(Title body) {
        gridAdapter gridAdapter = new gridAdapter(getApplicationContext(),R.layout.list_item,body.getMessage());
        gridView.setAdapter(gridAdapter);
    }
}