package com.cos.mystarbucks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView menuIcon;

    private LinearLayout mainSirenOrder;
    private LinearLayout mainCard;
    private TextView mainStore;
    private TextView mainWhatsNew;
    private TextView mainTextView;

    private View header;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setClickEventListener();
        drawerLayout();
        toolbarSetting();
    }

    private void drawerLayout(){
        toolbar = findViewById(R.id.toolbar);
        menuIcon = findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        header = navigationView.getHeaderView(0);

        btnLogin = header.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                login.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(login);
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent home = new Intent(getApplicationContext(), MainActivity.class);
                        //플래그. 간단히 현재 액티비티에서 어느 액티비티로 이동하는데, 스택 중간에 있었던 액티비티들을 지우는 역할은 한다고 이해하면 된다. 이 플래그가 없으면, 중간에 액티비티는 스택에 그대로 남아있기 때문에 이동 중간에  화면에 표출되어 UI 흐름을 망친다. 또한 시간이 지나면서 수 많은 액티비티가 쌓이게 되어 메모리 낭비를 초래한다.
                        home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //"FLAG_ACTIVITY_SINGLE_TOP" 플래그. 띄우려는 액티비티가 스택 맨위에 이미 실행 중이라면 재사용하겠다는 의미로 해석하면 된다.
                        home.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(home);

                        break;
                    case R.id.nav_sirenOrder:

                        Intent siren = new Intent(getApplicationContext(), SirenOrderActivity.class);
                        siren.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        siren.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(siren);
                        break;
                    case R.id.nav_card:

                        Intent card = new Intent(getApplicationContext(), CardActivity.class);
                        card.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        card.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(card);
                        break;
                    case R.id.nav_store:

                        Intent store = new Intent(getApplicationContext(), StoreActivity.class);
                        store.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        store.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(store);
                        break;
                    case R.id.nav_whatsNew:

                        Intent whatsNew = new Intent(getApplicationContext(), WhatsNewActivity.class);
                        whatsNew.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        whatsNew.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(whatsNew);
                        break;
                    case R.id.nav_menu:

                        Intent menu = new Intent(getApplicationContext(), MenuActivity.class);
                        menu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        menu.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(menu);
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void toolbarSetting(){
        setSupportActionBar(toolbar);
        menuIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private  void setClickEventListener(){
        mainSirenOrder = findViewById(R.id.main_sirenOrder);
        mainCard = findViewById(R.id.main_card);
        mainStore = findViewById(R.id.tv_main_store);
        mainWhatsNew = findViewById(R.id.tv_main_whatsNew);
        mainTextView = findViewById(R.id.main_text_view);

        SpannableString s = new SpannableString("마이 스타벅스 리워드 회원\n신규가입 첫 구매시,\n무료음료 혜택을 드려요!");

        s.setSpan(new ForegroundColorSpan(Color.rgb(0,180,110)), 0, 14, 0);
        s.setSpan(new ForegroundColorSpan(Color.WHITE), 14, s.length(), 0);

        mainTextView.setText(s);

        mainSirenOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siren = new Intent(getApplicationContext(), SirenOrderActivity.class);
                siren.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                siren.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(siren);
            }
        });

        mainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siren = new Intent(getApplicationContext(), CardActivity.class);
                siren.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                siren.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(siren);
            }
        });

        mainStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siren = new Intent(getApplicationContext(), StoreActivity.class);
                siren.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                siren.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(siren);
            }
        });

        mainWhatsNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siren = new Intent(getApplicationContext(), WhatsNewActivity.class);
                siren.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                siren.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(siren);
            }
        });
    }

}
