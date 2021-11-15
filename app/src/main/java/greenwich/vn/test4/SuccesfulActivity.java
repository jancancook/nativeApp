package greenwich.vn.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SuccesfulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succesful);
        String notification_2 = getResources().getString(R.string.notification_2);
        Toast.makeText(this, notification_2, Toast.LENGTH_LONG).show();

        Button btnBackToHome = findViewById(R.id.btnBackToHomeScreen);
        btnBackToHome.setOnClickListener(_btnBackToHomeScreen);
    }

    private View.OnClickListener _btnBackToHomeScreen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent back = new Intent(v.getContext(), HomeActivity.class);
            startActivity(back);
            finish();
        }
    };
}