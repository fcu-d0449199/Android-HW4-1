package lincyu.homework4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Button submit;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.tv_result);
        input = (EditText)findViewById(R.id.et_input);
        submit = (Button)findViewById(R.id.btn_submit);
        submit.setOnClickListener(calcResult);
    }

    private OnClickListener calcResult = new OnClickListener() {

        @Override
        public void onClick(View v) {

            String input_str =input.getText().toString();
            input.setText("");

            if (input_str.length() == 0) {
                Toast.makeText(MainActivity.this,
                        R.string.input_error,
                        Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent();
                intent.setAction("lincyu.SAYHELLO");
                String msg = input.getEditableText().toString();
                intent.putExtra("KEY_NAME", msg);
                sendBroadcast(intent);
            }
        }
    };
}
