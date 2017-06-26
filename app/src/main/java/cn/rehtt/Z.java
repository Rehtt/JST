package cn.rehtt;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketException;
import de.tavendo.autobahn.WebSocketHandler;



/**
 * Created by dsres on 2017/6/21.
 */

public  class Z implements Parcelable{
    static String user;
    static String id;
    static int q=0;
    static String e=null;
    String msg;
    String getMsg;
    static String getUserAll;

    MainActivity call1;
    static Main3Activity call2;
    Main4Activity call3;

    protected Z(Parcel in) {
        msg = in.readString();
        getMsg = in.readString();
        url = in.readString();
        i = in.readInt();
        userAlll = in.createStringArray();
        userAl = in.createStringArrayList();
        idAl = in.createStringArrayList();
        userAll = in.createStringArray();
    }
    public void setCall2(Main3Activity ac3){
        call2=ac3;
        Log.d("ac3", "对象更新成功");
        getUserAll();
    }
    public  void setCall3(Main4Activity ac4){
        call3=ac4;
    }

    public static final Creator<Z> CREATOR = new Creator<Z>() {
        @Override
        public Z createFromParcel(Parcel in) {
            return new Z(in);
        }

        @Override
        public Z[] newArray(int size) {
            return new Z[size];
        }
    };

    public void user_s(String s){
       user=s;
//Log.i("Z_U_S",user);

    }
    public String user_r(){
//        Log.i("Z_U_R",user);

        return user;
    }


    public void id_s(String a){
        id=a;
//        Log.i("Z_I_S",id);

    }
    public String id_r(){
//        Log.i("Z_I_S",id);
        return id;


    }
    public Z(MainActivity a){
        call1=a;
    }

    public void q_s(int a){
        q=a;
    }
    public int q_r(){
        return q;
    }






    private String url="ws://zlibraj.cn:8080/websockettest/websocket";

    private static WebSocketConnection webSocketConnection =new WebSocketConnection();

    /**
     * websocket连接，接收服务器消息
     */
    public void connect() {


        Log.i("3_1", "ws connect....");
        try {
            webSocketConnection.connect(url, new WebSocketHandler() {
                @Override
                public void onOpen() {
                    Log.i("3_2", "Status:Connect to " + url);


                    sendUsername();
                }

                @Override
                public void onTextMessage(String payload) {
//                    M(payload);
                    Json json=new Json();




                        switch (e) {

                            case "getMsg":
                                sendId(payload);
                                break;
                            case "getUserAll":
                                if (json.json(payload, "form").equals("SYS")) {
                                    getUserAlll(payload);
                                } else {
                                   getMsgAll(payload);

                                    Log.i("v","fsdsd");
                                }

                                break;

                            default:
                                ;
                        }

                    Log.i("3_3", payload);

                }

                @Override
                public void onClose(int code, String reason) {
                    Log.i("3_4", "Connection lost..");
                }
            });
        } catch (WebSocketException e) {
            e.printStackTrace();
        }

    }



    /**
     * 发送用户名给服务器
     */

    private void sendUsername() {

        String user="q";
        if (msg != null && msg.length() != 0)
            webSocketConnection.sendTextMessage(msg);
        else{
//            Toast.makeText(getApplicationContext(), "不能为空", Toast.LENGTH_SHORT).show();
    }
    }





//    protected void onDestroy() {
//        super.onDestroy();
//
//        webSocketConnection.disconnect();
//    }
    public void getMsg(String msgg){
//
        msg =msgg+"&SYS&setName&"+msgg;
        e="getMsg";
        connect();



    }

    int i=0;
    private LocalBroadcastManager localBroadcastManager;

public void sendId(String msgg){
    String[] b ;
    String a = null;
    a = msgg;


    b = a.split("\\{|\\}|\\\"|\\:|\\,");
    if (b[23].equals("false")) {
//new MainActivity().i(0);

        } else {

        id_s(b[23]);
        user_s(b[11]);
        Log.i("3",id_r()+"\\"+user_r());

        call1.getMss("kkk");




//

        }
     }




    public void getUserAll(){
    msg=user_r()+"&SYS&getAllUser&vone";
    e="getUserAll";
    webSocketConnection.sendTextMessage(msg);

    android.os.Handler handler=new android.os.Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {

            webSocketConnection.sendTextMessage(msg);

            handler.postDelayed(this,5000);

        }
    };
    handler.postDelayed(runnable,5000);
    if(false){
        handler.removeCallbacks(runnable);
    }


}

    String[] userAlll;
    ArrayList<String> userAl=new ArrayList<>();
    ArrayList<String> idAl=new ArrayList<>();

     String[] userAll;
    public void getUserAlll(String getUserAll){

        userAlll=getUserAll.split("\\\"");

        userAll=userAlll[15].split("\\[|\\]|\\,");
        int j=0;
        int k=2;
        userAl.clear();
        idAl.clear();
        userAl.add("群聊");

        idAl.add("ALL");

        userAl.add(userAll[0]);

        idAl.add(userAll[2]);
        for(int i=1;j<userAll.length-4&&k<userAll.length-4;i++){
            userAl.add(userAll[j=j+3]);
            idAl.add(userAll[k=k+3]);
        }
        Log.i("ggg",userAl+"|"+idAl);
        //
        Log.i("cal2",call2.toString());
        call2.getUser(userAl,idAl);




    }

    public void sendMsg(String getMsg,String id){
        e="sendMsg";
        String msgl=user_r()+"&"+id+"&text"+"&"+getMsg;
        if(webSocketConnection.isConnected()){
            webSocketConnection.sendTextMessage(msgl);
            Log.i("sdsdsd",msgl);
        }

    }
    Json json;
    ArrayList<String> fUser,fType;
    String tUser,conten;
    private void getMsgAll(String payload) {

        tUser=(json.json(payload,"to"));
        fType.add(json.json(payload,"type"));
        switch (json.json(payload,"type")){
            case "text":fUser.add(json.json(payload,"from")+":"+json.json(payload,"content"));
            Log.i("AAAAAAAAAAAAAAa", String.valueOf(fUser));break;
            default:;
        }
        call3.Msg(fUser,tUser,fType);

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(msg);
        dest.writeString(getMsg);
        dest.writeString(url);
        dest.writeInt(i);
        dest.writeStringArray(userAlll);
        dest.writeStringList(userAl);
        dest.writeStringList(idAl);
        dest.writeStringArray(userAll);
    }
}
