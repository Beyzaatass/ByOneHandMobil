package io.grpc.helloworldexample;

import android.support.v7.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity
{
    EditText username;
    EditText password;
    Button grsBtn;
    TextView kytBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);



        final Users user=new Users();

        final Database db=new Database(LoginPage.this);
        user.setUsername(db.VeriEkle("1","admin","admin@gmail.com","IO"));

        final EditText editusername=(EditText)findViewById(R.id.lgnkullanicitxt);
        final EditText editpassword=(EditText)findViewById(R.id.lgnsifretxt);

        username=(EditText)findViewById(R.id.lgnkullanicitxt);
        password=(EditText)findViewById(R.id.lgnsifretxt);
        grsBtn =(Button)findViewById(R.id.grsbtn);
        kytBtn=findViewById(R.id.kytactivitybtn);


        grsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(username.getText().toString().equalsIgnoreCase(""))
                {
                    username.setError("Lütfen Alanı Doldurunuz!");
                    if(password.getText().toString().equalsIgnoreCase(""))
                    {
                        password.setError("Lütfen Alanı Doldurunuz!");
                    }
                }
                else if(password.getText().toString().equalsIgnoreCase(""))
                {
                    password.setError("Lütfen Alanı Doldurunuz!");
                    if(username.getText().toString().equalsIgnoreCase("")) {
                        username.setError("Lütfen Alanı Doldurunuz!");
                    }
                }
                else{
                    grsBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent giris=new Intent(LoginPage.this, MainActivity.class);
                            startActivity(giris);
                            finish();
                        }
                    });
                }
            }
        });
        kytBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kayit=new Intent(LoginPage.this, RegisterPage.class);
                startActivity(kayit);
                finish();
            }
        });
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Çıkmak istediğinize emin misiniz?");
        builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Hayır'a baslınca yapılacak işmeleri yazınız
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}

