package tufts.shma;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import tufts.shma.Calendar.CalendarHelper;


public class UserInfoActivity extends AppCompatActivity {

    private Button previous_activity, next_activity;
    private RadioButton male, female;
    private SeekBar  height_cm, age, cur_weight, ideal_weight, time_period;
    private TextView txt_height, txt_age, txt_cw, txt_iw, txt_tp;
    private String gender, height = "175", s_age = "20", c_weight = "60", i_weight = "60", time_p = "15";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        bindViews();

        previous_activity = (Button) findViewById(R.id.button2);
        next_activity = (Button) findViewById(R.id.button1);

        male = (RadioButton) findViewById(R.id.radioButton1);
        female = (RadioButton) findViewById(R.id.radioButton2);
        final String username = getIntent().getExtras().getString("username_to_userinfo");
        final String password = getIntent().getExtras().getString("password_to_userinfo");
        previous_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (male.isChecked())
                    gender = "male";
                else if (female.isChecked())
                    gender = "female";
                User user1 = new User();
                user1.setUsername(username);
                user1.setPassword(password);

                user1.setAge(s_age);
                user1.setHeight_cm(height);
                user1.setGender(gender);
                user1.setCur_weight(c_weight);
                user1.setIdeal_weight(i_weight);
                user1.setTime_period(time_p);
//                CalendarHelper ch1 = new CalendarHelper();
//                user1.setCreate_date(ch1.getDay());

                SharedPreferences sp = getSharedPreferences("Login", MODE_MULTI_PROCESS);
                SharedPreferences.Editor Ed=sp.edit();
                Ed.putString("Unm",user1.getUsername());
                Ed.putString("Psw",user1.getPassword());
                Ed.putString("Age",user1.getAge());
                Ed.putString("Height",user1.getHeight_cm());
                Ed.putString("Gender",user1.getGender());
                Ed.putString("C_weight",user1.getCur_weight());
                Ed.putString("I_weight",user1.getIdeal_weight());
                Ed.putString("Period",user1.getTime_period());
                CalendarHelper ch1 = new CalendarHelper();
                Ed.putInt("Create_Date",ch1.getDay());
                Ed.commit();

                try {
                    Toast.makeText(getApplicationContext(), "successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UserInfoActivity.this, MenuActivity.class));
                    finishAffinity();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Failed to create user's information!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void bindViews() {
        height_cm = (SeekBar) findViewById(R.id.seekBar_Height);
        age = (SeekBar) findViewById(R.id.seekBar_Age);
        cur_weight = (SeekBar) findViewById(R.id.seekBar_CurrentWeight);
        ideal_weight = (SeekBar) findViewById(R.id.seekBar_IdealWeight);
        time_period = (SeekBar) findViewById(R.id.seekBar_timeperiod);

        txt_height = (TextView) findViewById(R.id.textView);
        txt_age = (TextView) findViewById(R.id.textView2);
        txt_cw = (TextView) findViewById(R.id.textView3);
        txt_iw = (TextView) findViewById(R.id.textView4);
        txt_tp = (TextView) findViewById(R.id.textView5);

        txt_height.setText("Height:" + height + "cm" );
        txt_age.setText("Age:" + s_age );
        txt_cw.setText("Current Weight:" + c_weight + "kg" );
        txt_iw.setText("Ideal Weight:" + i_weight + "kg" );
        txt_tp.setText("Time Period:" + time_p + "days" );

        height_cm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                height = String.valueOf(progress + 100);
                txt_height.setText("Height:" + height + "cm" );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "触碰SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "放开SeekBar", Toast.LENGTH_SHORT).show();
            }
        });

        age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               s_age = String.valueOf(progress + 10);
                txt_age.setText("Age:" + s_age );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "触碰SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "放开SeekBar", Toast.LENGTH_SHORT).show();
            }
        });

        cur_weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                c_weight = String.valueOf(progress + 30);
                txt_cw.setText("Current Weight:" + c_weight + "kg" );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "触碰SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "放开SeekBar", Toast.LENGTH_SHORT).show();
            }
        });

        ideal_weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                i_weight = String.valueOf(progress + 30);
                txt_iw.setText("Ideal Weight:" + i_weight + "kg" );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "触碰SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "放开SeekBar", Toast.LENGTH_SHORT).show();
            }
        });

        time_period.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                time_p = String.valueOf(progress + 5);
                txt_tp.setText("Time Period:" + time_p + "days" );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "触碰SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "放开SeekBar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
