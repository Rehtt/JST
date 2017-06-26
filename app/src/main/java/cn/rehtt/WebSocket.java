//package cn.rehtt;
//
//
//import android.util.Log;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//import de.tavendo.autobahn.WebSocketConnection;
//import de.tavendo.autobahn.WebSocketException;
//import de.tavendo.autobahn.WebSocketHandler;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//
///**
// * Created by dsres on 2017/6/21.
// */
//
//public class WebSocket {
//    private String url="ws://zlibraj.cn:8080/websockettest/websocket";
//    private String TAG="TT";
//    private WebSocketConnection webSocketConnection =new WebSocketConnection();
//
//    /**
//     * websocket连接，接收服务器消息
//     */
//
//        private void connect(){
//
//            Log.i(TAG, "ws connect....");
//            try {
//                webSocketConnection.connect(url, new WebSocketHandler() {
//                    @Override
//                    public void onOpen() {
//                        Log.i(TAG, "Status:Connect to " + url);
//                        sendUsername();
//                    }
//
//                    @Override
//                    public void onTextMessage(String payload) {
//                        Log.i(TAG, payload);
//
//
////                    mConnect.sendTextMessage("I am android client");
//                    }
//
//                    @Override
//                    public void onClose(int code, String reason) {
//                        Log.i(TAG, "Connection lost..");
//                    }
//                });
//            } catch (WebSocketException e) {
//                e.printStackTrace();
//            }
//        }
//
//        /**
//         * 发送用户名给服务器
//         */
//
//    private void sendUsername(String u) {
//
//
//        if (u != null && u.length() != 0)
//            webSocketConnection.sendTextMessage(u);
//        else
//            Log.e("sendUsername", "为空");
//    }
//
//    /**
//     * 发送消息
//     *
//     * @param msg
//     */
//    private void sendMessage(String msg) {
//        if (webSocketConnection.isConnected()) {
//            webSocketConnection.sendTextMessage(msg);
//        } else {
//            Log.i(TAG, "no connection!!");
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        onDestroy();
//        webSocketConnection.disconnect();
//    }
//
//
//    public void onClick(View view) {
//
//        if (view == button) {
//            String content ="k&SYS&setName&k";
//            if (content != null && content.length() != 0)
//                sendMessage(content);
//            else
//                Toast.makeText(getApplicationContext(), "不能为空", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//}
//
