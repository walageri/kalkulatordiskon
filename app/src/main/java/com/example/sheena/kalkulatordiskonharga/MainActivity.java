package com.example.sheena.kalkulatordiskonharga;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    EditText harga, discount;
    Button hitung;
    TextView hasil;
    TextView hasil2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        harga = (EditText)findViewById(R.id.harga_barang);
        discount = (EditText)findViewById(R.id.discount);
        hitung = (Button)findViewById(R.id.hitung);
        hasil = (TextView)findViewById(R.id.hasil);
        hasil2 = (TextView)findViewById(R.id.hasil2);


        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mHarga =harga.getText().toString().trim();
                String mDiscount=discount.getText().toString().trim();
//                fungsi if else adalah saat pengecekan si if pertama selsai maka ia sambungkan ke pengecekan si if yang kesua
                if (TextUtils.isEmpty(mHarga.trim())){
                    //ini buat netuin ketika textutils ngecek kosong
                    harga.setError("masukkan harga");
                    harga.requestFocus();
                }else if (TextUtils.isEmpty(mDiscount.trim())){
                    discount.setError("masukkan jumlah discount");
                    discount.requestFocus();
                    //else yang terakhir adalah perintah terakhir yang akan dikerjakan si button
                }else{
                    //tambahkan import static java.lang.Double.parseDouble;
                //agar code kita gak perlu mendefinisikan lagi bahwa yang kita kerjakan adalah parse double
                    //ingat kalau kita menggunakan perhitungan pembagian tidak menutup keungkinan hasilya ada diblakang koma bukan
                    //maka kita pakai double jangn int
                    Double nilaiharga = parseDouble(mHarga);
                    Double nilaidiscount=parseDouble(mDiscount);
                    //hitungan discount
                    Double totaldiscount=nilaidiscount/100;
                    Double hasildiscount=nilaiharga*totaldiscount;
                    hasil.setText("total discount: "+ hasildiscount);
                    // bisa dibuat lebih mudah dan simple
                    Double simple_discount_=nilaiharga*nilaidiscount/100;
                    hasil2.setText("hasil: "+ simple_discount_);
                }
            }
        });

    }
    public void keluar(View view){
        finish();
    }
}
