package cn.rehtt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketException;
import de.tavendo.autobahn.WebSocketHandler;

public class Main3Activity extends AppCompatActivity {
ListView listView;
    Z ws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView=(ListView)findViewById(R.id.name);
//        new Z().getUserAll();
        Intent i = getIntent();
        Bundle b = i.getExtras();
        ws = (Z) b.getParcelable("WS");
        ws.setCall2(this);







    }



    ArrayAdapter<String> arrayAdapter_u;
    public void getUser(ArrayList<String> user,ArrayList<String> idd){
        user.remove(ws.user_r());
        idd.remove(ws.id_r());

        arrayAdapter_u=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,user);
        listView.setAdapter(arrayAdapter_u);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(Main3Activity.this,Main4Activity.class);
                Bundle bundle=new Bundle();

                bundle.putString("id",idd.get(position));
                bundle.putString("user",user.get(position));
                bundle.putParcelable("WS", ws);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });
    }




}
