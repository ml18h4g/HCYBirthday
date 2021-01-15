package com.hewhywhy.hcybirthday;

//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.view.Gravity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ListView msgListView;
    private Button inputText;
//    private Button send;
    private MsgAdapter adapter;
    private Button button;

    private List<Msg> msgList = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ActionBar actionBar=getSupportActionBar();
//        actionBar.setCustomView(R.layout.actionbar_title);
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        ActionBar actionBar = getSupportActionBar();

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
            if(actionBar != null){
                actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                actionBar.setCustomView(R.layout.actionbar_title);
                TextView textView = (TextView) actionBar.getCustomView().findViewById(R.id.display_title);
                textView.setText("华晨宇");
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowCustomEnabled(true);
            }


       initMsgs();
//       continueMsgs();
        adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
//        inputText = (EditText) findViewById(R.id.input_text);
        button = (Button) findViewById(R.id.button_id);
//        send = (Button) findViewById(R.id.send);
        msgListView = (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");

                }
            }
        });
    }

        private void initMsgs() {
            Msg msg1 = new Msg("Hi~杨善惠，好久不见啦！", Msg.TYPE_RECEIVED);
            msgList.add(msg1);
            Msg msg2 = new Msg("是啊！见到花花好开心！花花在干嘛？", Msg.TYPE_SEND);
            msgList.add(msg2);
            Msg msg3 = new Msg("我在练歌哦，想听我唱歌么？给你个机会点歌我唱给你听！", Msg.TYPE_RECEIVED);
            msgList.add(msg3);
    }
//}

//    private void continueMsgs() {
//        switch(button_id){
//            case 1:
//                Msg msg4 = new Msg("太好了！我想听烟火里的尘埃！", Msg.TYPE_SEND);
//                msgList.add(msg4);
//                break;
//            case 2:
//                Msg msg5 = new Msg("太好了！我想听国王与乞丐！", Msg.TYPE_SEND);
//                msgList.add(msg5);
//                break;
//
//
//
//
//        }
//
//    }
}

