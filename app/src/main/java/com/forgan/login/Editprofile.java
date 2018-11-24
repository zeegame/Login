package com.forgan.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Editprofile extends AppCompatActivity {
    private Button btn_editsummit;
    private EditText editfname,editlname;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference ref = db.getReference("message"); // SetKey//// ref.setValue("This is a test message"); // SetValue
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        btn_editsummit = (Button)findViewById(R.id.btn_editsummit);
        editfname = (EditText)findViewById(R.id.editfname);
        editlname = (EditText)findViewById(R.id.editlname);

        btn_editsummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String get_fname = editfname.getText().toString();
                String get_lname = editlname.getText().toString();
                if (TextUtils.isEmpty(get_fname)){
                    Toast.makeText(getApplicationContext(),"PLS FILL FNAME",Toast.LENGTH_SHORT);
                }
                if(TextUtils.isEmpty(get_lname)){
                    Toast.makeText(getApplicationContext(),"PLS FILL LNAME",Toast.LENGTH_SHORT);
                }
                sendToFireBase(get_fname,get_lname);
            }

        });
    }
    private void sendToFireBase (String get_fname, String get_lname) {
        DatabaseReference childRef;
        DatabaseReference listTopic;
        DatabaseReference listContent;
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        childRef = ref.child("users");
        listTopic = childRef.child("firstname");
        listTopic.setValue(get_fname);
        listContent = childRef.child("lastname");
        listContent.setValue(get_lname);
        Toast.makeText(getApplicationContext(), "EditDone", Toast.LENGTH_SHORT).show();
    }
}

