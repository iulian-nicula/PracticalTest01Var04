package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    int checkbox1 = 0;
    int checkbox2 = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button2:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
                    startActivityForResult(intent, 0);
                    break;
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv1 = (TextView)findViewById(R.id.editText);
                String str1 = tv1.getText().toString();
                TextView tv2 = (TextView)findViewById(R.id.editText2);
                String str2 = tv2.getText().toString();
                if ((checkbox1 == 1 && str1.equals("")) || (checkbox2 == 1 && str2.equals(""))) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if (checkbox1 == 1 && checkbox2 == 1) {
                    TextView tv = (TextView)findViewById(R.id.textView3);
                    tv.setText(str1 + " " + str2);
                }
            }
        });
        final CheckBox cb1 = findViewById(R.id.checkBox);
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked()) checkbox1 = 1;
                else checkbox1 = 0;
            }
        });
        final CheckBox cb2 = findViewById(R.id.checkBox2);
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb2.isChecked()) checkbox2 = 1;
                else checkbox2 = 0;
            }
        });
        final Button secondarybutton = findViewById(R.id.button2);
        secondarybutton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            EditText et1 = findViewById(R.id.editText);
            EditText et2 = findViewById(R.id.editText2);
            String str1 = savedInstanceState.getString("mystring1");
            String str2 = savedInstanceState.getString("mystring2");
            et1.setText(str1);
            et2.setText(str2);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText et1 = findViewById(R.id.editText);
        EditText et2 = findViewById(R.id.editText2);
        savedInstanceState.putString("mystring1", et1.getText().toString());
        savedInstanceState.putString("mystring2", et2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        EditText et1 = findViewById(R.id.editText);
        EditText et2 = findViewById(R.id.editText2);
        String str1 = savedInstanceState.getString("mystring1");
        String str2 = savedInstanceState.getString("mystring2");
        savedInstanceState.putString(str1, et1.getText().toString());
        savedInstanceState.putString(str2, et2.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
    }
}
