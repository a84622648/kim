package com.example.projeck1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Hongc extends Activity
        implements OnClickListener{

    CheckBox checkBox, checkBox10, checkBox11, checkBox12, checkBox19,checkBox20,checkBox21;
    TextView textView2,textView3;
    Button button1,button2;
    EditText editText;
    String num1;      //사용된 메소드 정의

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hongc);

        editText = (EditText) findViewById(R.id.editText);
        checkBox10 = (CheckBox) findViewById(R.id.checkBox10);
        checkBox11 = (CheckBox) findViewById(R.id.checkBox11);
        checkBox12 = (CheckBox) findViewById(R.id.checkBox12);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox19 = (CheckBox) findViewById(R.id.checkBox19);
        checkBox20 = (CheckBox) findViewById(R.id.checkBox20);
        checkBox21 = (CheckBox) findViewById(R.id.checkBox21);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView2 = (TextView) findViewById(R.id.textView2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        textView3 = (TextView) findViewById(R.id.textView3);
        checkBox10.setChecked(true);

        button1.setOnClickListener(this);

        num1 = editText.getText().toString();

        Intent intent3 = getIntent(); //2번째액티비에서의 자료를 getExtra()를 활용하여 받아오기

        String getName = intent3.getExtras().getString("name");



        TextView cc = (TextView) findViewById(R.id.hongb_textview);        //텍스트뷰를 통해 받아온자료 보여주기
        cc.setText(getName );

    }
    public void saveData(View view)  //좌석번호를 받고 저장하기위해 만든 함수 
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        String strSaveData = editText.getText().toString();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.savedata_private_key), strSaveData);
        editor.commit();

        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(strSaveData);
        num1 = strSaveData;
    }


    @Override
    public void onClick(View v) { //클릭이벤트를 만들기 위해 넣은함수

        Intent i; //시스템액티비티를 부를 Intent 참조변수
        Uri uri;

        String msg = "";


        if (checkBox10.isChecked()) {//체크박스에 체크후 주문누를시 메세지에 메뉴출력

            msg += checkBox10.getText().toString() + ",";
        }

        if (checkBox11.isChecked()) {
            msg += checkBox11.getText().toString() + ",";
        }

        if (checkBox12.isChecked()) {
            msg += checkBox12.getText().toString() + ",";
        }
        if (checkBox.isChecked()) {

            msg += checkBox.getText().toString() + ",";
        }
        if (checkBox19.isChecked()) {

            msg += checkBox19.getText().toString() + ",";
        }
        if (checkBox20.isChecked()) {

            msg += checkBox20.getText().toString() + ",";
        }
        if (checkBox21.isChecked()) {

            msg += checkBox21.getText().toString() + ",";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        uri= Uri.parse("smsto:01032029369"); //sms 문자와 관련된 Data는 'smsto:'로 시작. 이후는 문자를 받는 사람의 전화번호
        i= new Intent(Intent.ACTION_SENDTO,uri); //시스템 액티비티인 SMS문자보내기 Activity의 action값
        i.putExtra("sms_body","좌석번호 : "+ num1 + "  "+"메뉴 :" + msg);  //보낼 문자내용을 추가로 전송, key값은 반드시 'sms_body'
        startActivity(i);
    }
}












