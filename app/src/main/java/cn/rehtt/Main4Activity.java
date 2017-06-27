package cn.rehtt;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
ListView listView;
String id,user;
EditText editText;
Button button;
Z z;
TextView textView;
ArrayList<String> si=new ArrayList<>();
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
        textView=(TextView)findViewById(R.id.textView);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        z = (Z) b.getParcelable("WS");
        z.setCall3(this);
        if(!id.equals("ALL") && z.getSiLiao()!=null){
            userMsg(z.getSiLiao());
        }
        else if (z.getUserTomsgg()!=null){
            Msg(z.getUserTomsgg());
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                z.sendMsg(editText.getText().toString(),id,user);
//                Toast.makeText(getApplication(),"成功",Toast.LENGTH_LONG).show();
                editText.setText("");
            }
        });
    }
    public void Msg(ArrayList<String> msg){

        if(id.equals("ALL")) {
            textView.setText("群聊大厅");
            arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, msg);
            listView.setAdapter(arrayAdapter);
        }

    }

    public void userMsg(ArrayList<String > siLiao){
        textView.setText("正在与"+user+"聊天");
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,siLiao);
        listView.setAdapter(arrayAdapter);
    }


}
