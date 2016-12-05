package com.kejar.indonesia.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Example how to make global variable
    // Structure of variable:
    // [access_modified] [variable type] [variable name]
    private int quantity = 0;

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
                quantity = quantity + 1;
                updateQty(quantity);
            }
        });

        Button decrementButton = (Button) findViewById(R.id.decrement_button);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = quantity - 1;
                updateQty(quantity);
            }
        });


    }

    /**
     * Update quantity textview
     * @param qty
     */
    private void updateQty(int qty) {
        if (qty < 0) {
            return;
        }

        TextView qtyView = (TextView) findViewById(R.id.quantity_text_view);
        qtyView.setText(String.valueOf(qty));
    }

    /**
     * Calculate price based on quantity
     * @param quantity int
     * @return int
     */
    private int calculatePrice(int quantity) {
        int basePrice = 5;

        // if using cream topping, charge $1
        if (usingCreamToping()) {
            basePrice = basePrice + 1;
        }

        // TODO: check if using chocolate topping, charge $2

        // Example: If customer using cream and chocolate topping
        // price total = (base price + charge cream topping + charge chocolate topping) * quantity
        return quantity * basePrice;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.order_button) {

            // call method calculatePrice and strore it to variable int price
            int price = calculatePrice(quantity);

            // call method usingCreamToping and store it to variable boolean creamToping
            boolean creamToping = usingCreamToping();

            // call method getCustomerName and store it to variable string customerName
            String customerName = getCustomerName();

            // call method sendOrderSummary and passing 4 parameter (price, quantity, creamToping, customerName)
            sendOrderSummary(price, quantity, creamToping, customerName);
        }
    }

    /**
     * Send order summary to email using common intent
     * @param price int
     * @param quantity int
     * @param creamToping boolean
     * @param customerName boolean
     */
    private void sendOrderSummary(int price,
                                  int quantity,
                                  boolean creamToping,
                                  String customerName) {

        // Calling common intent
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(
                price, quantity, creamToping, customerName
        ));

        if (intent.resolveActivity(getPackageManager()) != null) {
            // if device have an application
            Toast.makeText(this, "Application found", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            // if device not have an application
            Toast.makeText(this, "Application not found", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Get string value from edit text
     * @return string
     */
    private String getCustomerName() {
        EditText nameInput = (EditText) findViewById(R.id.name_input);
        return nameInput.getText().toString();
    }

    /**
     * Check if checkbox cream topping selected
     * @return boolean
     */
    private boolean usingCreamToping() {
        CheckBox creamTopping = (CheckBox) findViewById(R.id.cream_topping);
        return creamTopping.isChecked();
    }

    /**
     * Create string order summary formated string resource
     * @param price int
     * @param quantity int
     * @param usingCreamTopping boolean
     * @param customerName boolean
     * @return string
     */
    private String createOrderSummary(int price,
                                      int quantity,
                                      boolean usingCreamTopping,
                                      String customerName) {

        return getString(R.string.order_summary,
                customerName,
                usingCreamTopping ? "true" : "false",
                quantity,
                price);
    }

}
