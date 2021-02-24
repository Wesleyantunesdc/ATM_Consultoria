package com.example.atm_consultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void enviarEmail(){
        String celular= "tel:419985072967";
        String imagem = "https://miro.medium.com/max/1280/0*kdPYTcHaaGRa4uvN.jpg";
        String endereco = "https://www.google.com/maps/place/CC+Miranda+Loteria+%26+Lan+House/@-25.5308806,-49.2723415,3a,75y,300.74h,82.14t/data=!3m6!1e1!3m4!1s1F9eSC_9uOMAEpGlwBS1HA!2e0!7i13312!8i6656!4m13!1m7!3m6!1s0x94dcfb81816eaa0d:0x6069b7ebf95f06b3!2sR.+D%C3%ADdio+Sampaio+-+S%C3%ADtio+Cercado,+Curitiba+-+PR,+81900-748!3b1!8m2!3d-25.5320612!4d-49.275834!3m4!1s0x94dcfb8475750af7:0xd5a7a2037621b5ae!8m2!3d-25.5332334!4d-49.2789523";
        //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(imagem));
        //Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse(celular));
        //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(endereco));
        Intent intent = new Intent( Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"wesleyantunesdca@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Desenvolvimento do aplicativo");
        intent.putExtra(Intent.EXTRA_TEXT,"Mensagem automárica");
          intent.setType("message/rfc822");
        //intent.setType("text/plain");
        startActivity(Intent.createChooser( intent,"Enviar Email"));
//      startActivity(intent);
    }
}