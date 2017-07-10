package sky.kr.co.autolmssendapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import co.kr.sky.AccumThread;
import sky.kr.co.autolmssendapp.common.CommonUtil;

public class MainActivity extends Activity {
    Map<String, String> map = new HashMap<String, String>();
    AccumThread mThread;
    CommonUtil dataSet = CommonUtil.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        map.clear();
        map.put("url", dataSet.SERVER + "Join.php");
        map.put("phone", dataSet.PHONE);
        map.put("reg_id", "");
        mThread = new AccumThread(this , mAfterAccum , map , 0 , 0 , null);

        mThread.start();		//스레드 시작!!


        findViewById(R.id.btn1).setOnClickListener(btnListener);
        findViewById(R.id.btn2).setOnClickListener(btnListener);
        findViewById(R.id.btn3).setOnClickListener(btnListener);
        findViewById(R.id.btn4).setOnClickListener(btnListener);

    }
    Handler mAfterAccum = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if (msg.arg1  == 0 ) {
                String res = (String)msg.obj;
                Log.e("SKY" , "RESULT  -> " + res);
                res = res.trim();
                /*
                if(res.equals("true")){
                    Check_Preferences.setAppPreferences(IntroduceActivity.this , "Introduce_FLAG" , "true");

                    //가입성공
                    Intent intent = new Intent(IntroduceActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext() , "" + res , 0).show();
                    //가입성공
                    Intent intent = new Intent(IntroduceActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                */

            }
        }
    };
    View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn1:
                    startActivity(new Intent(MainActivity.this, LMSMainActivity.class));
                    break;
                case R.id.btn2:
                    //startActivity(new Intent(MainActivity.this, LMSMainActivity.class));
                    break;
                case R.id.btn3:
                    Toast.makeText(getApplicationContext() , "준비중입니다.(8월 OPEN 예정)" , Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, LMSMainActivity.class));
                    break;
                case R.id.btn4:
                    //startActivity(new Intent(MainActivity.this, LMSMainActivity.class));
                    break;

            }
        }
    };
}
