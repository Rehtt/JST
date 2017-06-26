package cn.rehtt;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
ListView listView;
String id,user;
EditText editText;
Button button;
Z z;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle bundle=this.getIntent().getExtras();
        id=bundle.getString("id");
        user=bundle.getString("user");
        listView=(ListView)findViewById(R.id.listView);
        editText=(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button2);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        z = (Z) b.getParcelable("WS");
        z.setCall3(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                z.sendMsg(editText.getText().toString(),id);
                Toast.makeText(getApplication(),"sd",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void Msg(ArrayList<String> fUser,String tUser,ArrayList<String> type){
        if(tUser.equals(user)) {
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, fUser);
            listView.setAdapter(arrayAdapter);
        }else ;

    }

}
