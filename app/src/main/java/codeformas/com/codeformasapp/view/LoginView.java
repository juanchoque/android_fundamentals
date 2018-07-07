package codeformas.com.codeformasapp.view;

import android.content.Intent;
import android.content.IntentSender;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import codeformas.com.codeformasapp.R;
import codeformas.com.codeformasapp.util.Constants;

public class LoginView extends AppCompatActivity {
    @BindView(R.id.btn_acept)
    Button btnAcept;
    @BindView(R.id.txt_user)
    TextView txtUser;
    @BindView(R.id.txt_pass)
    TextView txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        this.btnAcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadMainActivity();
            }
        });
    }

    public void loadMainActivity(){
        //validate data
        boolean nextActivity = true;
        String user = this.txtUser.getText().toString();
        String pass = this.txtPass.getText().toString();
        if(user.isEmpty()){
            nextActivity = false;
            this.txtUser.setError(Constants.MESSAGE_ERROR);
        }

        if(pass.isEmpty()){
            nextActivity = false;
            this.txtPass.setError(Constants.MESSAGE_ERROR);
        }

        if(nextActivity){
            Intent intent = new Intent(LoginView.this, MainView.class);
            startActivity(intent);
            finish();
        }

    }
}
