package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox oneWay, roundTrip;
    Button btnSubmit, btnAdd, btnMinus;
    TextView paxNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneWay = findViewById(R.id.onewayCheckBox);
        roundTrip = findViewById(R.id.roundTripCheckBox);
        btnSubmit = findViewById(R.id.submitButton);
        btnAdd = findViewById(R.id.addButton);
        btnMinus = findViewById(R.id.minusbutton);
        paxNumber = findViewById(R.id.paxNumber);

        int pax = Integer.parseInt(paxNumber.getText().toString());
        if(pax == 0){
            btnMinus.setEnabled(false);
        }


        btnMinus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int paxNumber2 = Integer.parseInt(paxNumber.getText().toString());
                paxNumber.setText((paxNumber2 - 1) + "");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int paxNumber2 = Integer.parseInt(paxNumber.getText().toString());
                paxNumber.setText((paxNumber2 + 1) + "");
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oneWay.isChecked() && roundTrip.isChecked()) {
                    Toast.makeText(MainActivity.this, "Only can choose one type", Toast.LENGTH_SHORT).show();
                    return;
                }
                int pax = Integer.parseInt(paxNumber.getText().toString());
                if(pax <= 0){
                    Toast.makeText(MainActivity.this, "No less than 1 pax", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(oneWay.isChecked()== false && roundTrip.isChecked() == false){
                    Toast.makeText(MainActivity.this, "Please choose either one", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(MainActivity.this, flightDetail.class);
                if(oneWay.isChecked()) {
                    int total = 100 * pax;
                    intent.putExtra("detail", "You have selected One Way Trip");
                    intent.putExtra("money", total);
                    startActivity(intent);
                }
                if(roundTrip.isChecked()){
                    int total = 100 * pax * 2;
                    intent.putExtra("detail", "You have selected Round Trip");
                    intent.putExtra("money", total);
                    startActivity(intent);
                }
            }
        });

    }
}
