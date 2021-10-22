package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edit_name  =findViewById(R.id.ed_name);
        TextView status     =findViewById(R.id.tv_text);
        RadioGroup radioGroup =findViewById(R.id.radioGroup);
        RadioButton btn_scissor  =findViewById(R.id.btn_scissor);
        RadioButton btn_stone    =findViewById(R.id.btn_stone);
        RadioButton btn_paper    =findViewById(R.id.btn_paper);
        Button btn_mora     =findViewById(R.id.btn_mora);
        TextView tv_name    =findViewById(R.id.tv_name);
        TextView tv_winner  =findViewById(R.id.tv_winner);
        TextView tv_mmora   =findViewById(R.id.tv_mmora);
        TextView tv_cmora   =findViewById(R.id.tv_cmora);

        btn_mora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit_name.length()<1)
                    status.setText("請輸入玩家命名");
                else {
                    tv_name.setText("名字是\n" + edit_name.getText().toString());

                    if (btn_scissor.isChecked())
                        tv_mmora.setText("玩家出\n剪刀");
                    else if(btn_stone.isChecked())
                        tv_mmora.setText("玩家出\n石頭");
                    else
                        tv_mmora.setText("玩家出\n布");

                    int computer=(int)(Math.random()*3);
                    if (computer==0)
                            tv_cmora.setText("電腦出\n剪刀");
                    else if (computer==1)
                            tv_cmora.setText("電腦出\n石頭");
                    else
                            tv_cmora.setText("電腦出\n布");

                    if ((btn_scissor.isChecked()&&computer==0)||
                            (btn_stone.isChecked()&&computer==1)||
                                (btn_paper.isChecked()&&computer==2)) {
                        tv_winner.setText("勝利者\n平手");
                        status.setText("平手");
                    }

                    else if  ((btn_scissor.isChecked()&&computer==2)||
                                (btn_stone.isChecked()&&computer==0)||
                                    (btn_paper.isChecked()&&computer==1)) {
                        tv_winner.setText("勝利者\n玩家");
                        status.setText("你贏了");
                    }
                    else {
                        tv_winner.setText("勝利者\n電腦");
                        status.setText("你輸了");
                    }

                }
            }
        });

    }
}