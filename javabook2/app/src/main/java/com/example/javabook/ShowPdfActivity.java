package com.example.javabook;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.javabook.databinding.ActivityShowPdfBinding;

public class ShowPdfActivity extends AppCompatActivity {

    ActivityShowPdfBinding binding;

    private  String title;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowPdfBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        title =getIntent().getStringExtra("title");
        position =getIntent().getIntExtra("pos",0);
        binding.title.setText(title);

        if (position == 0){

            binding.pdfView.fromAsset("Chapter1.pdf").load();

        } else if (position == 1) {
            binding.pdfView.fromAsset("Chapter2.pdf").load();

        } else if (position == 2) {
            binding.pdfView.fromAsset("Chapter3.pdf").load();

        } else if (position == 3) {
            binding.pdfView.fromAsset("Chapter4.pdf").load();

        } else if (position == 4) {
            binding.pdfView.fromAsset("Chapter5.pdf").load();

        } else if (position == 5) {
            binding.pdfView.fromAsset("Chapter6.pdf").load();

        } else if (position == 6) {
            binding.pdfView.fromAsset("Chapter7.pdf").load();

        } else if (position == 7) {
            binding.pdfView.fromAsset("Chapter8.pdf").load();

        } else if (position == 8) {
            binding.pdfView.fromAsset("Chapter9.pdf").load();

        } else if (position == 9) {
            binding.pdfView.fromAsset("Chapter10.pdf").load();

        } else if (position == 10) {
            binding.pdfView.fromAsset("Chapter11.pdf").load();

        } else if (position == 11) {
            binding.pdfView.fromAsset("Chapter12.pdf").load();

        } else if (position == 12) {
            binding.pdfView.fromAsset("Chapter13.pdf").load();

        } else if (position == 13) {
            binding.pdfView.fromAsset("Chapter14.pdf").load();

        } else if (position == 14) {
            binding.pdfView.fromAsset("Chapter15.pdf").load();

        }

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
    }
}