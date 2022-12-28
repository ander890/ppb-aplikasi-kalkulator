package xyz.dvlprs.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioTambah, radioKurang, radioKali, radioBagi;
    EditText angka1, angka2;
    TextView txtHasil;
    RecyclerView history;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    ArrayList<History> listHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        angka1 = findViewById(R.id.angka1);
        angka2 = findViewById(R.id.angka2);
        radioTambah = (RadioButton) findViewById(R.id.radioTambah);
        radioKurang = (RadioButton) findViewById(R.id.radioKurang);
        radioKali = (RadioButton) findViewById(R.id.radioKali);
        radioBagi = (RadioButton) findViewById(R.id.radioBagi);
        txtHasil = (TextView) findViewById(R.id.hasil);

        history = findViewById(R.id.history);
        listHistory = new ArrayList<History>();

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        history.setLayoutManager(linearLayoutManager);

        adapterData = new AdapterData(this, listHistory);
        history.setAdapter(adapterData);
    }

    public void hitung(View v){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if(selectedId == -1) {
            Toast.makeText(MainActivity.this,
                    "SILAHKAN PILIH OPERASI ARITMATIKA", Toast.LENGTH_SHORT).show();
            return;
        }


        int hasil = 0;
        String operator = "";
        if(selectedId == radioTambah.getId()){
            hasil = Integer.parseInt(angka1.getText().toString()) + Integer.parseInt(angka2.getText().toString());
            operator = "+";
        }else if(selectedId == radioKurang.getId()){
            hasil = Integer.parseInt(angka1.getText().toString()) - Integer.parseInt(angka2.getText().toString());
            operator = "-";
        }else if(selectedId == radioKali.getId()){
            hasil = Integer.parseInt(angka1.getText().toString()) * Integer.parseInt(angka2.getText().toString());
            operator = "x";
        }else if(selectedId == radioBagi.getId()){
            hasil = Integer.parseInt(angka1.getText().toString()) / Integer.parseInt(angka2.getText().toString());
            operator = "/";
        }

        listHistory.add(0, new History(Integer.parseInt(angka1.getText().toString()), Integer.parseInt(angka2.getText().toString()), hasil, operator));
        adapterData.notifyDataSetChanged();

        txtHasil.setText(String.valueOf(hasil));
    }
}