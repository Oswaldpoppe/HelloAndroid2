package com.oswald.android.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class HelloAndroid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_android);


    }

    public void maps(View view) {
        String map = "http://maps.google.co.in/maps?q=" + getString(R.string.address);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
        startActivity(intent);
    }

    /**
     * This method is called when the contact us button is clicked.
     */
    public void contactUs(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("message/rfc822");
        intent.setData(Uri.parse(getString(R.string.mail_address)));
        intent.putExtra(intent.EXTRA_SUBJECT, getString(R.string.subject));
        intent.putExtra(intent.EXTRA_TEXT, getString(R.string.mail_content));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

