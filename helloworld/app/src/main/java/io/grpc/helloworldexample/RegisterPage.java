package io.grpc.helloworldexample;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;


public class RegisterPage extends AppCompatActivity {
    Button kayitol;
    TextView kyttxt;
    EditText email,username,tcno,password1,password2;
    String isim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        new GrpcTask(this)
                .execute();


        final Database db=new Database(RegisterPage.this);
        tcno=findViewById(R.id.tcnoedittxt);
        final EditText user=(EditText)findViewById(R.id.kullaniciadiedittxt);
        final EditText passw=(EditText)findViewById(R.id.sifreedittxt);
        final EditText e_mail=(EditText)findViewById(R.id.emailedittxt);
        kyttxt=findViewById(R.id.kayioltxt);

        kyttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterPage.this,LoginPage.class);
                startActivity(intent);
                finish();
            }
        });

        username=(EditText)findViewById(R.id.kullaniciadiedittxt);
        email=(EditText)findViewById(R.id.emailedittxt);
        password1=(EditText)findViewById(R.id.sifreedittxt);
        password2=(EditText)findViewById(R.id.sifretekraredittxt);

        final Users User=new Users();

        kayitol=(Button)findViewById(R.id.kytolbtn);

        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernm=user.getText().toString();
                String userpassw=passw.getText().toString();
                String useremail=e_mail.getText().toString();
                String tcnum=tcno.getText().toString();

                if(db.UserRegisterCheck(usernm,useremail).equalsIgnoreCase("true")){
                    if(username.getText().toString().equalsIgnoreCase(""))
                    {
                        username.setError("Lütfen Alanı Doldurunuz!");
                        if(password1.getText().toString().equalsIgnoreCase(""))
                        {
                            password1.setError("Lütfen Alanı Doldurunuz!");
                            if(password2.getText().toString().equalsIgnoreCase("")){
                                password2.setError("Lütfen Alanı Doldurunuz!");
                                if(email.getText().toString().equalsIgnoreCase("")){
                                    email.setError("Lütfen Alanı DOldurunuz!");
                                }
                            }
                        }
                    }
                    else if(password1.getText().toString().equalsIgnoreCase("")&&password2.getText().toString().equalsIgnoreCase("")&&username.getText().toString().equalsIgnoreCase("")&&email.getText().toString().equalsIgnoreCase("")){
                        password1.setError("Lütfen Alanı Doldurunuz!");
                        email.setError("Lütfen Alanı DOldurunuz!");
                        password2.setError("Lütfen Alanı Doldurunuz!");
                        username.setError("Lütfen Alanı Doldurunuz!");
                    }
                    else if(password1.getText().toString().equalsIgnoreCase(""))
                    {
                        password1.setError("Lütfen Alanı Doldurunuz!");
                        if(username.getText().toString().equalsIgnoreCase(""))
                        {
                            username.setError("Lütfen Alanı Doldurunuz!");
                            if(password2.getText().toString().equalsIgnoreCase("")){
                                password2.setError("Lütfen Alanı Doldurunuz!");
                                if(email.getText().toString().equalsIgnoreCase("")){
                                    email.setError("Lütfen Alanı DOldurunuz!");
                                }
                            }
                        }
                    }
                    else if(email.getText().toString().equalsIgnoreCase(""))
                    {
                        email.setError("Lütfen Alanı Doldurunuz!");
                        if(username.getText().toString().equalsIgnoreCase(""))
                        {
                            username.setError("Lütfen Alanı Doldurunuz!");
                            if(password2.getText().toString().equalsIgnoreCase("")){
                                password2.setError("Lütfen Alanı Doldurunuz!");
                                if(password1.getText().toString().equalsIgnoreCase("")){
                                    password1.setError("Lütfen Alanı DOldurunuz!");
                                }
                            }
                        }
                    }
                    else if(password2.getText().toString().equalsIgnoreCase(""))
                    {
                        password2.setError("Lütfen Alanı Doldurunuz!");
                        if(username.getText().toString().equalsIgnoreCase(""))
                        {
                            username.setError("Lütfen Alanı Doldurunuz!");
                            if(password1.getText().toString().equalsIgnoreCase("")){
                                password1.setError("Lütfen Alanı Doldurunuz!");
                                if(email.getText().toString().equalsIgnoreCase("")){
                                    email.setError("Lütfen Alanı DOldurunuz!");
                                }
                            }
                        }
                    }
                    else{
                        if(password1.getText().toString().equalsIgnoreCase(password2.getText().toString()))
                        {

                            String username=user.getText().toString();
                            String password=passw.getText().toString();
                            String email=e_mail.getText().toString();

                            final Intent login=new Intent(RegisterPage.this, LoginPage.class);
                            login.putExtra("usernamekayit",username);
                            login.putExtra("passwordkyt",password);

                            db.VeriEkle(tcnum,passw.getText().toString(),e_mail.getText().toString(),user.getText().toString());
                            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(RegisterPage.this);
                            builder.setCancelable(false);
                            builder.setMessage("Başarıyla kayıt oldun  "+ isim);
                            builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                                @Override            public void onClick(DialogInterface dialog, int which) {

                                    startActivity(login);
                                }
                            });
                            android.app.AlertDialog alert = builder.create();
                            alert.show();
                        }
                        else
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterPage.this);
                            builder.setMessage("Şifreler Uyuşmuyor!");
                            builder.setNegativeButton("Tamam", null);
                            builder.show();                        }
                    }

                }
                else if(db.UserRegisterCheck(usernm,useremail).equalsIgnoreCase("false")){
                    user.setError("Kullanıcı Adı Alınmış!");
                    e_mail.setError("E-Mail Alınmış!");
                }
                else if(db.UserRegisterCheck(usernm,useremail).equalsIgnoreCase("usernamealinmis")){
                    user.setError("Kullanıcı Adı Alınmış!");
                }
                else {
                    e_mail.setError("E-Mail Alınmış!");
                }
            }
        });
    }
    public void onBackPressed() {
        Intent intent=new Intent(RegisterPage.this,LoginPage.class);
        startActivity(intent);
        finish();
    }

    public void sendMessage() {


    }
    private class GrpcTask extends AsyncTask<String, Void, JSONObject> {
        private final WeakReference<Activity> activityReference;
        private ManagedChannel channel;

        private GrpcTask(Activity activity) {
            this.activityReference = new WeakReference<Activity>(activity);
        }

        @Override
        protected JSONObject doInBackground(String... params) {
            String host = "10.0.2.2";
            String message = "world";
            String portStr = "50051";
            JSONObject json;
            int port = TextUtils.isEmpty(portStr) ? 0 : Integer.valueOf(portStr);
            try {
                channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
                GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
                HelloRequest request = HelloRequest.newBuilder().setName(message).build();
                HelloReply reply = stub.sayHello(request);
                JSONParser jsonParser = new JSONParser();
                json = jsonParser.getJSONFromUrl(reply.getMessage());
                return json;
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                pw.flush();
                return new JSONObject();
            }
        }
        @Override
        protected void onPostExecute(JSONObject result) {
            try {
                channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Activity activity = activityReference.get();
            if (activity == null) {
                return;
            }
            try {
                isim = result.getString("name");
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
