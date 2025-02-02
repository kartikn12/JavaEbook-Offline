package com.example.javabook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.javabook.Adapters.CategoryAdapter;
import com.example.javabook.Models.CategoryModel;
import com.example.javabook.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    ArrayList<CategoryModel> list;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);

        // Menu toggle
        binding.menu.setOnClickListener(view -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        // Navigation item selection
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.share) {
                // Share functionality
                String shareBody = "Hey, I am using the best Java Notes app! " +
                        "Check it out: http://play.google.com/store/apps/details?id=" +
                        MainActivity.this.getPackageName();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain"); // Correct MIME type
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, "Share JavaNotes via"));
                drawerLayout.closeDrawer(GravityCompat.START);
            } else if (item.getItemId() == R.id.rate) {
                // Rate functionality
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName()));
                startActivity(intent);
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            return false;
        });

        // Set up RecyclerView
        list = new ArrayList<>();
        populateCategoryList();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvcategory.setLayoutManager(layoutManager);

        adapter = new CategoryAdapter(this, list);
        binding.rvcategory.setAdapter(adapter);
    }

    private void populateCategoryList() {
        for (int i = 1; i <= 15; i++) {
            list.add(new CategoryModel("Chapter-" + i));
        }
    }
}
