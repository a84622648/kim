package com.example.projeck1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //첫밴째 액티비티에 버튼하나를 생성
        ImageButton button = (ImageButton) findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {

                @Override
            public void onClick(View v) {        //클릭이벤트를 처리 버튼클릭시
                Intent intent1 = new Intent(MainActivity.this, Honga.class);
                    intent1.putExtra("name", "음식주문하기");
                startActivity(intent1);
            }
        });

    }


}