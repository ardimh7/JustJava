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

        Button orderButton = (Button) findViewById(R.id.order_button);
        orderButton.setOnClickListener(this);

        Button incrementButton = (Button) findViewById(R.id.increment_button);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = 3;
                updateQty(quantity);
            }
        });

        Button decrementButton = (Button) findViewById(R.id.decrement_button);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = 1;
                updateQty(quantity);
            }
        });

        initDefaultValue();
    }

    private void initDefaultValue() {
        int quantity = 2;
        updateQty(quantity);
        updatePrice(quantity * 5);
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
        if (view.getId() == R.id.order_button) {
            int quantity = 5;
            updateQty(quantity);
            updatePrice(quantity * 5);
        }
    }
}
