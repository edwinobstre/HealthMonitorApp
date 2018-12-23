package tufts.shma;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity {

    Button sign_up, sign_in;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        sign_up = (Button)findViewById(R.id.button1);
        sign_in = (Button)findViewById(R.id.button2);
        username = (EditText)findViewById(R.id.editText2);
        password = (EditText)findViewById(R.id.editText1);
        SharedPreferences sp1= getSharedPreferences("Login", MODE_MULTI_PROCESS);
        final String  unm = sp1.getString("Unm", null);
        final String pass = sp1.getString("Psw", null);
        sign_in.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals(unm) && password.getText().toString().equals(pass)) {
                    Toast.makeText(getApplicationContext(), "Redirecting",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LogActivity.this, MenuActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("") || password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please input username and password",Toast.LENGTH_SHORT).show();
                }
                else if(username.getText().toString().equals(unm)){
                    Toast.makeText(getApplicationContext(), "Username Already Exist",Toast.LENGTH_SHORT).show();
                }
                else {
                    Bundle bd = new Bundle();
                    bd.putString("username_to_userinfo", username.getText().toString());
                    bd.putString("password_to_userinfo", password.getText().toString());
                    startActivity((new Intent(LogActivity.this, UserInfoActivity.class)).putExtras(bd));
                }
            }
        });
    }
}
