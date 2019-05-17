package com.main.editor_demo94244;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class SizeListener implements View.OnClickListener {

    private TextView testText = null;

    public SizeListener(TextView testText){
        this.testText = testText;
    }
    @Override
    public void onClick(View v) {
        float textSize =testText.getTextSize();
        switch (v.getId()){
            case  R.id.biggerBtn:
                textSize = textSize + 2;
                break;
            case  R.id.smallerBtn:
                textSize = textSize - 2;
                break;
            default:break;
        }

        testText.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);

    }
}
