package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText    ed_name;
    private TextView    tv_text,tv_name,tv_winner,tv_mmora,tv_cmora;
    private Button      btn_mora;
    private RadioButton  btn_scissor,btn_stone,btn_paper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ed_name =findViewById(R.id.ed_name);
        tv_text =findViewById(R.id.tv_text);
        tv_name =findViewById(R.id.tv_name);
        tv_winner =findViewById(R.id.tv_winner);
        tv_mmora =findViewById(R.id.tv_mmora);
        tv_cmora =findViewById(R.id.tv_cmora);

        btn_mora =findViewById(R.id.btn_mora);
        btn_scissor =findViewById(R.id.btn_scissor);
        btn_stone =findViewById(R.id.btn_stone);
        btn_paper =findViewById(R.id.btn_paper);

        btn_mora.setOnClickListener(view ->
        {
            if (ed_name.length() < 1)
            {
                tv_text.setText("請輸入玩家姓名");
            }
            else
            {
                tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()));

                if (btn_scissor.isChecked())
                {
                    tv_mmora.setText("我方出拳\n剪刀");
                }
                else if (btn_stone.isChecked())
                {
                    tv_mmora.setText("我方出拳\n石頭");
                }
                else
                {
                    tv_mmora.setText("我方出拳\n布");
                }
                int computer_random = (int) (Math.random() * 3);
                if (computer_random == 0)
                {
                    tv_cmora.setText("電腦出拳\n剪刀");
                }
                else if (computer_random == 1)
                {
                    tv_cmora.setText("電腦出拳\n石頭");
                }
                else
                {
                    tv_cmora.setText("電腦出拳\n布");
                }
// 判斷勝負
                if ((btn_scissor.isChecked() && computer_random == 2) ||
                        (btn_stone.isChecked() && computer_random == 0) ||
                        (btn_paper.isChecked() && computer_random == 1))
                {
                    tv_winner.setText("勝利者\n" + ed_name.getText().toString());
                    tv_text.setText("恭喜您獲勝了!!!");
                }
                else if ((btn_scissor.isChecked() && computer_random == 1) ||
                (btn_stone.isChecked() && computer_random == 2) ||
                (btn_paper.isChecked() && computer_random == 0))
                {
                    tv_winner.setText("勝利者\n電腦");
                    tv_text.setText("可惜,電腦贏了!");
                }
                else
                {
                    tv_winner.setText("勝利者\n平手");
                    tv_text.setText("平局,請再試一次!");
                }
            }

        });
    }
}