package com.example.day07contentprovider;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 0);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                getContact();
                break;
            case R.id.button2:
                addContact();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void getContact() {
        ContentResolver resolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        Cursor cursor = resolver.query(uri,null,null,null);
        while (cursor.moveToNext()) {
            String cName =cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String cNum = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Log.d("1","姓名:"+ cName);
            Log.d("1","号码:"+ cNum);
            Log.d("1","===================");
        }
        cursor.close();
    }

    private void addContact() {

        int permission = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_CONTACTS);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CONTACTS},0);
        }

        try {
            Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
            Uri dataUri = Uri.parse("content://com.android.contacts/data");
            ContentResolver resolver = getContentResolver();
            ArrayList<ContentProviderOperation> operations = new ArrayList<ContentProviderOperation>();
            ContentProviderOperation operation1 = ContentProviderOperation.newInsert(uri)
                    .withValue("account_name",null)
                    .build();
            operations.add(operation1);

            ContentProviderOperation operation2 = ContentProviderOperation.newInsert(dataUri)
                    .withValueBackReference("raw_contact_id",0)
                    .withValue("mimetype","vnd.android.cursor.item/name")
                    .withValue("data2","马云")
                    .build();
            operations.add(operation2);

            ContentProviderOperation operation3 = ContentProviderOperation.newInsert(dataUri)
                    .withValueBackReference("raw_contact_id",0)
                    .withValue("mimetype","vnd.android.cursor.item/phone_v2")
                    .withValue("data1","13688886666")
                    .withValue("data2","2")
                    .build();
            operations.add(operation3);

            ContentProviderOperation operation4 = ContentProviderOperation.newInsert(dataUri)
                    .withValueBackReference("raw_contact_id",0)
                    .withValue("mimetype","vnd.android.cursor.item/email_v2")
                    .withValue("data1","13688886666@163.com")
                    .withValue("data2","2")
                    .build();
            operations.add(operation4);

            resolver.applyBatch("com.android.contacts",operations);
            Toast.makeText(getApplicationContext(),"新增通讯录成功",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Log.d("1","ee" + e.getLocalizedMessage());
        }
    }
}