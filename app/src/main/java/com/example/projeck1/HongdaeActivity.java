package com.example.projeck1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HongdaeActivity extends Activity {

    private String[] name = {//리스트뷰의 목록이름 쓰기
            "음식주문하기",
            "음료주문하기",
            "기타주문하기"
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


        ListView aa = (ListView) findViewById(R.id.second_list);    //리스트뷰 만들기
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.simpleitem, name);


        aa.setAdapter(arrayAdapter);        //각리스트별로 클릭이벤트 넣어주기
        aa.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                String ss = (String) parent.getItemAtPosition(position);   //다음 액티비티로 자료 넘겨주기
                if (position == 0) {
                    Intent intent1 = new Intent(HongdaeActivity.this, Honga.class);
                    intent1.putExtra("name", ss);
                    startActivity(intent1);
                }
                String dd = (String) parent.getItemAtPosition(position);   //다음 액티비티로 자료 넘겨주기
                if (position == 1) {
                    Intent intent2 = new Intent(HongdaeActivity.this, Drink.class);
                    intent2.putExtra("name", dd);
                    startActivity(intent2);
                }
                String ff = (String) parent.getItemAtPosition(position);   //다음 액티비티로 자료 넘겨주기
                if (position == 2) {
                    Intent intent3 = new Intent(HongdaeActivity.this, Gitar.class);
                    intent3.putExtra("name", ff);
                    startActivity(intent3);
                }



            }


        });


    }

}


