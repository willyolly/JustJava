package com.example.justjava;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitPlus (View view){

        if((0 <= quantity) && (quantity <= 100)){
            quantity +=1;
        }
        displayQuantity(quantity);
    }
    public void submitMinus (View view){
        if((0 <= quantity) && (quantity <= 100)){
            quantity -=1;
        }
        displayQuantity(quantity);
    }
    private String createOrderSummary(int quantity, String nameText, boolean isWhippedCream, boolean isChocolate){
        int price = price(quantity);
        String priceMessage = "Name: ";
        priceMessage += nameText;
        priceMessage += "/nQuantity of Cappuccino: " + quantity;
        if (isWhippedCream){
            priceMessage += "and whipped cream";
            price += 50;
        }
        if (isChocolate){
            priceMessage += "and chocolate";
            price += 80;
        }
        priceMessage += "/nTotal Price: " + price;
        priceMessage += "/nThank You!";
        return priceMessage;
    }

    public void submitOrder (View view){
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String nameText = editText.getText().toString();
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.first_checkbox);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.second_checkbox);
        boolean isWhippedCream = checkBox1.isChecked();
        boolean isChocolate = checkBox2.isChecked();
        displayPrice(createOrderSummary(quantity, nameText, isWhippedCream, isChocolate));
    }
    private void displayQuantity(int number){
        TextView quantityNumberView = (TextView) findViewById(R.id.quantity_number_view);
        quantityNumberView.setText(number);
    }
    private void displayPrice(String priceMessage){
        TextView priceNumberView = (TextView) findViewById(R.id.order_summary_text_view);
        priceNumberView.setText(priceMessage);
    }
    private int price(int number){
        return number * 30;
    }
}