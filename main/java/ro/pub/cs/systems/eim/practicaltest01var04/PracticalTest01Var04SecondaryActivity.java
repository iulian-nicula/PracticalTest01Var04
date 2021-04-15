package ro.pub.cs.systems.eim.practicaltest01var04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button3:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.button4:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctivity_practical_test01_var04_secondary);
        Button ok = findViewById(R.id.button3);
        Button cancel = findViewById(R.id.button4);
        ok.setOnClickListener(buttonClickListener);
        cancel.setOnClickListener(buttonClickListener);
    }
}
