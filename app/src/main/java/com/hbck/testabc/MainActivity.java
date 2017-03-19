package com.hbck.testabc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initView();
        Intent intent = new Intent(this, MyService.class);
        startService(intent);

    }

   /* private void initView() {
        et_content = (EditText) findViewById(R.id.et_content);
    }

    public void myClick(View view) {
        int type = view.getId() == R.id.btn_1 ? 1 : 2;
        String content = et_content.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            Toast.makeText(this, "content不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        sendMsg(type,content);

    }

    private void sendMsg(int type,String content){
        ContentResolver resolver = getContentResolver();
        ContentValues values = new ContentValues();
        values.put("address", "15733128702");
        values.put("type", type);//1为收 2为发
        values.put("date", getTime());
        values.put("body", content);
        //阅读状态  0未读， 1已读
        values.put("read", 0);

        Uri uri = Uri.parse("content://sms/");
        resolver.insert(uri, values);
    }


    private long getTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2015);
        cal.set(Calendar.MONTH, 6);
        cal.set(Calendar.DAY_OF_MONTH, 9);
        cal.set(Calendar.HOUR, 9);
//        return cal.getTimeInMillis();
        return System.currentTimeMillis();
    }*/

    public void jump(View v){
        startActivity(new Intent(this,KeepAliveActivity.class));
        finish();
    }
}
