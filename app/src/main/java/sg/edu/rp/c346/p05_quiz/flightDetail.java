package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class flightDetail extends AppCompatActivity {

    TextView flightDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_detail);

        flightDetail = findViewById(R.id.flightDetail);

        Intent intentReceived = getIntent();
        String value=intentReceived.getStringExtra("detail");
        Integer value1 = intentReceived.getIntExtra("money", 100);
        flightDetail.setText(value + "\n" + "Your air ticket cost $"+value1);
    }
}
