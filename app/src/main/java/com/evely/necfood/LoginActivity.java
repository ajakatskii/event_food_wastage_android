package com.evely.necfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.evely.necfood.data.Registry;
import com.evely.necfood.data.User;
import com.evely.necfood.utils.Utils;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;

    private EditText etPassword;

    private Button btnNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = this.findViewById(R.id.txtUsername);
        etPassword = this.findViewById(R.id.txtPassword);
        this.btnNewUser = this.findViewById(R.id.btnSignup);
        Registry.getInstance().context = this;
    }

    public void btnLogin_click(View vw)
    {
        User user = User.initUser(this.etUsername.getText().toString(), this.etPassword.getText().toString());
        Registry.getInstance().user = user;
        if(user == null) {
            //clear values from text fields?
            //do something?
            return;
        } else {
            //correct password entered, according to the user redirect to correct activity
            Intent intent;
            if(user.isOrganizer) {
                intent = new Intent(this.getApplicationContext(), FlavorActivity.class);
            } else {
                intent = new Intent(this.getApplicationContext(), MainActivity.class);
            }
            this.startActivity(intent);
        }
    }

    /**
     * hide the new user button since functionality is not implemented.
     * @param vw
     */
    public void btnNewUser_Click(View vw) {
        Utils.showMessage("Contact Administrator");
        this.btnNewUser.setVisibility(View.INVISIBLE);
    }

}
