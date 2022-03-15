package com.example.labfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText UserName;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName  = (EditText)findViewById(R.id.username);
        Password  = (EditText)findViewById(R.id.password);
        Info  = (TextView)findViewById(R.id.infoText);
        Login  = (Button) findViewById(R.id.btn);

        Info.setText("No of Attempts remaining:  ");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(UserName.getText().toString(),Password.getText().toString());

            }
        });
    }

    private void Validate (String Username,String Password)
    {
        if((Username=="Admin")&& (Password =="1234"))
        {
            Intent intent = new Intent(MainActivity.this ,SecondActivity.class);
            startActivity(intent);//this is goes into next activity
        }else
        {
            counter--;
            if (counter == 0 )
            {
                Info.setText("No of Attempts remaining:  "+ String.valueOf( counter));
                Login.setEnabled(false);
            }
        }
    }

}