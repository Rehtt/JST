package cn.rehtt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import javax.security.auth.login.LoginException;

import static cn.rehtt.Z.user;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    EditText editText;
    String m=" ";
    ListView listView;
    public static Z  ws;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        shur();
        editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);







    }


//    public void shur(){
//        EditText inputServer = new EditText(this);AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//
//
//        builder.setTitle("输入昵称").setView(inputServer)
//                .setNegativeButton("退出", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        System.exit(0);
//                    }
//                });
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//
//            public void onClick(DialogInterface dialog, int which) {
//                new Z().getMsg(inputServer.getText().toString());
//
//
//
//            }
//
//
//        });
//        builder.show();
//
//    }

//    public void h(String d){
//
//
//        if (!d.equals("false")){
//////
//            m="昵称重名";
////            Toast.makeText(getApplication(),m,Toast.LENGTH_SHORT).show();
//
//Log.i("JJJJJJJJJ",m);}
////        }
////        else {}
//
//    }




    @Override
    public void onClick(View v) {
        ws=new Z(this);
        ws.getMsg(editText.getText().toString());

       //getMss("k");


    }
public void getMss(String mss){
    Log.i("get:",mss);
//    Intent intent=new Intent(MainActivity.this,Main3Activity.class);
//    Bundle bundle = new Bundle();
//    bundle.putSerializable("ws", ws);
//    intent.putExtras(bundle);
//    startActivity(intent);
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, Main3Activity.class);
    Bundle bundle = new Bundle();
    bundle.putParcelable("WS", ws);
    intent.putExtras(bundle);
    startActivity(intent);
}




    public void i(int i){
        if(i!=0){
Intent intent=new Intent();
intent.setClass(MainActivity.this,Main3Activity.class);
startActivity(intent);


        }else {

            editText.setText("昵称占用");
        }


    }







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
            startActivity(new Intent().setClass(MainActivity.this, Main2Activity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}




class LocalR extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Dsd","dsd");
    }
}



