package tryby.and.tresh;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends Activity {

	Button btn1;
	EditText tf1;
	int counter = 0;
	
	CheckBox cb_1;
	CheckBox cb_2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
      
        cb_1 = (CheckBox)findViewById(R.id.cb_color);
        cb_2 = (CheckBox)findViewById(R.id.cb_bold);

        
        btn1 = (Button)findViewById(R.id.btn_1);
        tf1 = (EditText)findViewById(R.id.et_1);
        
        tf1.setSingleLine();
        tf1.setInputType(InputType.TYPE_NULL);
        
        btn1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				if(cb_1.isChecked())
					tf1.setTextColor(Color.RED);
				else
					tf1.setTextColor(Color.BLACK);
				
				if(cb_2.isChecked())
					tf1.setTypeface(Typeface.DEFAULT_BOLD);
				else
					tf1.setTypeface(Typeface.DEFAULT);
				
				tf1.setText("Clicked"+ ++counter);
			}
		}); 
     }
}
