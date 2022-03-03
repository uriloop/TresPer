package uri.dam.tresper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import uri.dam.tresper.databinding.ActivityAppBinding;
import uri.dam.tresper.login.MainActivity;

public class AppActivity extends AppCompatActivity {

    private ActivityAppBinding binding;
    NavController navController;
    BottomNavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
/*
        navView.setItemIconTintList(ColorStateList.valueOf(Color.parseColor("#F9ECD4")));
*/
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_torneigs, R.id.navigation_social, R.id.navigation_personal)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_app);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

getWindow().setNavigationBarColor(getResources().getColor(R.color.tab_no_pulsat_text));
getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

        }else{
            //binding.navView.setItemIconSize(0);


        }
       /*  amaga el contingut de la barra del mobil superior

       View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
*/
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }




    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

// per si volem treure o posar items al menu, un cop s'ha iniciat o creat el menu
        menu.removeItem(R.id.action_crear_equip);
        menu.removeItem(R.id.action_crear_torneig);
        menu.setQwertyMode(true);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void finish() {
        super.finish();
        startActivity(new Intent(this, MainActivity.class));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.action_crear_equip) {

            navController.navigate(R.id.action_go_to_crear_equip);
            return true;
        }
        if (id == R.id.action_crear_torneig) {
            navController.navigate(R.id.action_go_to_crear_torneig);
            return true;
        }
        if (id == R.id.action_help) {
            navController.navigate(R.id.action_go_to_helpFragment2);
            return true;
        }
        if (id == R.id.home) {
            navController.popBackStack();
            return true;
        }
        if (id == R.id.action_exit) {
            // akí acció .  log out i tancar app
            this.finishAffinity();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}