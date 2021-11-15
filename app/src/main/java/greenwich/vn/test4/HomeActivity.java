package greenwich.vn.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnLogin = findViewById(R.id.btnNewProperty);
        btnLogin.setOnClickListener(btnNewPropertyClick);
        Log.e("Main Activity", "--- OnCreate ---");

    }



    private View.OnClickListener btnNewPropertyClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent newPropertyForm = new Intent(v.getContext(), FormActivity.class);
            startActivity(newPropertyForm);
        }
    };
}