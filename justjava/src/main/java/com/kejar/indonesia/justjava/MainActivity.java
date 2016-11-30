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

    private void updateQty(int qty) {
        TextView qtyView = (TextView) findViewById(R.id.quantity_text_view);
        qtyView.setText(String.valueOf(qty));
    }

    private void updatePrice(int price) {
        TextView priceView = (TextView) findViewById(R.id.price_text_view);
        priceView.setText(String.format(getString(R.string.price_format), price));
    }

    @Override
    public void onClick(View view) {
        int numberOfCoffees = 2;

        updateQty(numberOfCoffees);
        updatePrice(numberOfCoffees * 5);
    }
}
