package com.example.hw_3_1_chyngyz_omorov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText theme;
    private EditText massage;
    public static final String KEY_FOR_INTENT = "intent.key";
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        theme = findViewById(R.id.theme);
        massage = findViewById(R.id.massage);
        buttonSend = findViewById(R.id.btn_send);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!email.getText().toString().isEmpty() && !theme.getText().toString().isEmpty()
                && !massage.getText().toString().isEmpty()) {


                    Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:?subject=" + theme.getText().toString() + "&body=" + massage.getText().toString()  + "&to=" + email.getText().toString());
                    mailIntent.setData(data);




                    startActivity(Intent.createChooser(mailIntent, "Send mail..."));
                }else {
                    Toast.makeText(MainActivity.this, "Заполните все поля",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}