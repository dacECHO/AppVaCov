package co.edu.unipiloto.appvacov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText user;
    private EditText password;
    private Button login;
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user =(EditText) findViewById(R.id.edUser);
        password = (EditText) findViewById(R.id.edPassword);
        login = (Button) findViewById(R.id.btnLogin);
        info = (TextView) findViewById(R.id.txvInfo);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.onEditorAction(EditorInfo.IME_ACTION_DONE);    //Esconder teclado
                password.onEditorAction(EditorInfo.IME_ACTION_DONE);
                validate(user.getText().toString(),password.getText().toString()); //Valida los datos

            }
        });
    }
    private void validate (String usr, String passwrd){
        if(usr.equals("Admin") && passwrd.equals("Admin")){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent); //lanza la segunda actividad
        }else{
            info.setText("Datos incorrectos."); //Actualiza los datos de info
        }
    }
}