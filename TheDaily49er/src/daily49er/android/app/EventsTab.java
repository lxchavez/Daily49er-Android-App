package daily49er.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EventsTab extends Activity {
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("This is the Events tab");
        setContentView(textview);
    }

}