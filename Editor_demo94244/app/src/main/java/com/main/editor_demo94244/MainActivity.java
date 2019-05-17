package com.main.editor_demo94244;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView testText = null;
    private Button redBtn = null;
    private Button blueBtn = null;
    private Button greenBtn = null;

    private Button biggerBtn = null;
    private Button smallerBtn = null;

    private Button blodBtn = null;
    private Button italicBtn = null;
    private Button normalBtn = null;

    private EditText contentEt = null;

    private SizeListener sizeListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testText = (TextView) findViewById(R.id.testText);
        redBtn = (Button) findViewById(R.id.redBtn);
        blueBtn = (Button) findViewById(R.id.blueBtn);
        greenBtn = (Button) findViewById(R.id.greenBtn);

        biggerBtn = (Button) findViewById(R.id.biggerBtn);
        smallerBtn = (Button) findViewById(R.id.smallerBtn);

        blodBtn = (Button) findViewById(R.id.blodBtn);
        italicBtn = (Button) findViewById(R.id.italicBtn);
        normalBtn = (Button) findViewById(R.id.normalBtn);

        contentEt = (EditText)findViewById(R.id.contentEt);


        ColorListener colorListener = new ColorListener();
        redBtn.setOnClickListener(colorListener);
        blueBtn.setOnClickListener(colorListener);
        greenBtn.setOnClickListener(colorListener);

        sizeListener = new SizeListener(testText);
        biggerBtn.setOnClickListener(sizeListener);
        smallerBtn.setOnClickListener(sizeListener);

        blodBtn.setOnClickListener(this);
        italicBtn.setOnClickListener(this);
        normalBtn.setOnClickListener(this);


        contentEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testText.setText(contentEt.getText().toString());
            }
        });


    }

    @Override
    public void onClick(View v) {
        Typeface typeface = testText.getTypeface();
        switch (v.getId()) {
            case R.id.blodBtn:
                if (typeface.isItalic()){
                    testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
                }
                else
                    testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
                break;
            case R.id.italicBtn:
                if (typeface.isBold()){
                    testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
                }
                else
                    testText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);
                break;
            case R.id.normalBtn:
                testText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
                break;
            default:
                break;
        }
    }

    private class ColorListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case  R.id.redBtn:
                    testText.setTextColor(Color.RED);break;
                case  R.id.greenBtn:
                    testText.setTextColor(Color.GREEN);break;
                case  R.id.blueBtn:
                    testText.setTextColor(Color.BLUE);break;
                    default:break;

            }
        }
    }

}
