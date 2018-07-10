package com.example.lo_wh.uitest;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    Dialog paymentDialog;
    ImageView closePaymentDialogImg;
    Button proceedPaymentBtn;
    CardView payment_card;
    CardView details_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paymentDialog = new Dialog(this);

        payment_card = findViewById(R.id.paymentCard);
        details_card = findViewById(R.id.detailsCard);

        payment_card.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showPaymentDialog();
                Log.d("LOGCAT", "Payment Dialog");
            }

        });

        details_card.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.d("LOGCAT", "Details Dialog");
            }

        });
    }

    public void showPaymentDialog(){
        paymentDialog.setContentView(R.layout.payment_popout);

        proceedPaymentBtn = paymentDialog.findViewById(R.id.proceedPaymentBtn);
        closePaymentDialogImg = paymentDialog.findViewById(R.id.closePaymentDialogImg);


        closePaymentDialogImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paymentDialog.dismiss();
                Log.d("LOGCAT", "Closed");
            }
        });

        proceedPaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paymentDialog.dismiss();
                Log.d("LOGCAT", "Proceed to Payment SDK");
            }
        });

        paymentDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        paymentDialog.show();
    }
}



