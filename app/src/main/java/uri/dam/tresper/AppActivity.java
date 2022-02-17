package uri.dam.tresper;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import uri.dam.tresper.databinding.ActivityAppBinding;

public class AppActivity extends AppCompatActivity {

    private ActivityAppBinding binding;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_app);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

// per si volem treure o posar items al menu, un cop s'ha iniciat o creat el menu
/*
        menu.removeItem(R.id.action_crear_torneig);
*/

        return super.onPrepareOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_crear_equip) {
            navController.navigate(R.id.action_go_to_helpFragment2);
            return true;
        }
        if (id == R.id.action_crear_torneig) {
            navController.navigate(R.id.action_go_to_helpFragment2);
            return true;
        }
        if (id == R.id.action_help) {
            navController.navigate(R.id.action_go_to_helpFragment2);
            return true;
        }
        if (id== R.id.action_exit){
            // akí acció .  log out i tancar app
            /*navController.navigate(R.id.action_FirstFragment_to_helpFragment);*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}