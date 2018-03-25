package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    int price = 5;
    String custName;
    boolean hasWhipped ;
    boolean hasChoco;
    String hasWhip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //int quantity = 1;

        CheckBox check = (CheckBox) findViewById(R.id.checkbox_view);
        if(check.isChecked()){
            hasWhipped= true;}
        else
        {hasWhipped = false;}
        CheckBox chocCheck = (CheckBox) findViewById(R.id.choco_checkbox_view);
        if(chocCheck.isChecked()){
            hasChoco= true; }
        else
        {hasChoco = false; }

        EditText name = (EditText) findViewById(R.id.customer_Name);
        custName = String.valueOf(name.getText());

        Log.v("MainActivity","customer"+custName);
        price = quantity *5;
        String priceMessage = "Total: $" +price;
        createSummaryOrder(custName,price,quantity,hasWhipped,hasChoco);
        //display(quantity);
        //displayPrice(quantity);
        ;
    }
    //findViewById returns a view type
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }

    public void createSummaryOrder(String name,int price,int quantity,boolean hasWhipped,boolean hasChoco){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        String summary = "Name: " +name;
        summary = summary + "\nAdd whipped cream ? "+ hasWhipped;
        summary = summary + "\nAdd chocolate ?" +hasChoco;
        summary = summary + "\n Quantity " + quantity;
        summary = summary + "\nTotal:" + price + "\nThank You!";
        displayMessage(summary);

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    public void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    public void displayPrice(int number) {

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        price = number *5;
        //priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        priceTextView.setText("" + price);
    }

    public void decrement(View view) {
        //int quantity = 2;
        quantity =quantity-1;

        display(quantity);
        // displayPrice(quantity*5);
    }

    public void increment(View view) {
        //int quantity = 2;
        quantity =quantity+1;
        display(quantity);
        //displayPrice(quantity*5);
    }
}