package com.example.engineering.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
RadioButton capuchino, espreso;
    int numberOfCoffees=0;//number of coffees initialised
    int unitPrice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //getting the information from text
    public void textInfo(){
        EditText quantity_text_view=findViewById(R.id.quantity_text_view);
        String quantity=quantity_text_view.getText().toString();
        numberOfCoffees=Integer.parseInt(quantity);

    }
    //listening to radio button and updating the unit price apropriately
    public void addListenerOnButtonClick(){
        capuchino= findViewById(R.id.capuchino);
        espreso= findViewById(R.id.espreso);
        if (capuchino.isChecked()){unitPrice=10;}
        else {
            unitPrice=5;
        }

    }

    //function for increment
    public void increment(View view){
        textInfo();
        numberOfCoffees+=1;
        display(numberOfCoffees);}

        //function for decreasing the value
    public void decrement(View view){
        textInfo();
        numberOfCoffees -=1;
        display(numberOfCoffees);}

    //submit order button handler
    public void submitOrder(View view){
        addListenerOnButtonClick();
        textInfo();
        int price=unitPrice*numberOfCoffees;
        String priceMessage= "total: $ "+price+"\n thank you";
        displayMessage(priceMessage);

    }
    //function to update total amount
    private void displayMessage(String message){
    TextView priceTextView= findViewById(
            R.id.price_text_view);
    priceTextView.setText(message);}
    //funtion to update quantity
    private void display(int number){
        TextView quantityTextView= findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

}
