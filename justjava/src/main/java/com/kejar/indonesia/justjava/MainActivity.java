package com.kejar.indonesia.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.order_button);
        button.setOnClickListener(this);
    }

    private void updateQty(int order) {
        TextView qtyView = (TextView) findViewById(R.id.quantity_text_view);
        qtyView.setText(String.valueOf(order));
    }

    @Override
    public void onClick(View view) {
        updateQty(1);
    }
}
