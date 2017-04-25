package lincyu.homework4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.et_input);
        Button submit = (Button)findViewById(R.id.btn_submit);
        submit.setOnClickListener(calcResult);
    }

    private View.OnClickListener calcResult = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent();
            intent.setAction("lincyu.SAYHELLO");
            String msg = input.getEditableText().toString();
            intent.putExtra("KEY_NAME", msg);
            sendBroadcast(intent);
        }
    };
}
