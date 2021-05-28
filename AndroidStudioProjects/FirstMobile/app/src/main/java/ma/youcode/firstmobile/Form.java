package ma.youcode.firstmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Validator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Form extends AppCompatActivity   {

    //button
    private Button btnValid;
    //four text fiels
    EditText fname,lname,email,password;

    // one boolean variable to check whether all the text fields
    // are filled by the user, properly or not.
    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        // register all
        fname = findViewById(R.id.activity_main_fname_input);
        lname = findViewById(R.id.activity_main_lname_input);
        email = findViewById(R.id.activity_main_email_input);
        password = findViewById(R.id.activity_main_password_input);
        btnValid = (Button) findViewById(R.id.activity_main_play_btn);


        // handle the PROCEED button
        btnValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked) {
                    Intent i = new Intent(Form.this, FinalPage.class);
                    startActivity(i);
                }
                // startActivity(new Intent(Form.this, FinalPage.class));
            }
        });
    }
        // function which checks all the text fields
        // are filled or not by the user.
        // when user clicks on the PROCEED button
        // this function is triggered.
        private boolean CheckAllFields() {
            if (fname.length() == 0) {
                fname.setError("This field is required");
                return false;
            }

            if (lname.length() == 0) {
                lname.setError("This field is required");
                return false;
            }

            if (email.length() == 0) {
                email.setError("Email is required");
                return false;
            }

            if (password.length() == 0) {
                password.setError("Password is required");
                return false;
            } else if (password.length() < 8) {
                password.setError("Password must be minimum 8 characters");
                return false;
            }

            // after all validation return true.
            return true;
    }
}