package com.example.nursultan.tabdemotutorial;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.*;

import org.w3c.dom.Text;


public class MainActivity extends TabActivity {
    final String TABS_TAG_1 = "Tag 1";
    final String TABS_TAG_2 = "Tag 2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // получаем TabHost
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabspec;

        tabspec = tabHost.newTabSpec(TABS_TAG_1);
        tabspec.setContent(Tabf);
        tabspec.setIndicator("Nursultan", getResources().getDrawable(R.drawable.ab_icon_selector));
       // tabspec.setContent(new Intent(this,SecondActivity.class));
        tabHost.addTab(tabspec);

        tabspec = tabHost.newTabSpec(TABS_TAG_2);
        tabspec.setContent(Tabf);
        tabspec.setIndicator("Jazgul", getResources().getDrawable(R.drawable.ab_icon_selector));
        //tabspec.setContent(new Intent(this,ThirdActivity.class));
        tabHost.addTab(tabspec);


       /* TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        // инициализация
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        // создаем вкладку и указываем тег
        tabSpec = tabHost.newTabSpec("tag1");
        // название вкладки
        tabSpec.setIndicator("Вкладка 1");
        // указываем id компонента из FrameLayout, он и станет содержимым
        tabSpec.setContent(R.id.tvTab1);
        // добавляем в корневой элемент
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        // указываем название и картинку
        // в нашем случае вместо картинки идет xml-файл,
        // который определяет картинку по состоянию вкладки
        tabSpec.setIndicator("Вкладка 2", getResources().getDrawable(R.drawable.ab_icon_selector));
        tabSpec.setContent(R.id.tvTab2);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        // создаем View из layout-файла
        View v = getLayoutInflater().inflate(R.layout.tab_header, null);
        // и устанавливаем его, как заголовок
        tabSpec.setIndicator(v);
        tabSpec.setContent(R.id.tvTab3);
        tabHost.addTab(tabSpec);

        // вторая вкладка будет выбрана по умолчанию
        tabHost.setCurrentTabByTag("tag2");

        // обработчик переключения вкладок
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                Toast.makeText(getBaseContext(), "tabId = " + tabId, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    TabHost.TabContentFactory Tabf= new TabHost.TabContentFactory() {
        @Override
        public View createTabContent(String tag) {
            if(tag == TABS_TAG_1){
                return getLayoutInflater().inflate(R.layout.tab,null);
            }else if(tag == TABS_TAG_2){
                TextView txt = new TextView(MainActivity.this);
                txt.setText("Cj");
                return  txt;
            }
            return null;
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
