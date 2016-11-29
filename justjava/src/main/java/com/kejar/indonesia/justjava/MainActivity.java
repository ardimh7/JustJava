package com.kejar.indonesia.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayOrder(View view) {
        updateQty(1);
    }

    private void updateQty(int order) {
        TextView qtyView = (TextView) findViewById(R.id.quantity_text_view);
        qtyView.setText(String.valueOf(order));
    }
}
