package alvarez.manuel.helloworld;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       fab.setBackgroundColor(getColor(R.color.colorAccent));
       fab.setOnClickListener(new View.OnClickListener() {
            int counter = 0;
            @Override
            public void onClick(View view) {
                EditText txtName = findViewById(R.id.txtName);
                TextView txtSayHello = findViewById(R.id.txtSayHello);
                counter++;
                //Snackbar.make(view, "Hello World !!!", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                Calendar c = new GregorianCalendar();
                String eventTime = c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
                String complement = "\n\nI have said hello to you " + counter + " times";
                Toast toast =Toast.makeText(getApplicationContext(),"Button Pushed " + eventTime,Toast.LENGTH_SHORT);
                toast.show();
                if(txtName.getText().toString().isEmpty()){
                    txtSayHello.setText("Hello Human with no name"+complement);
                }
                else{
                    txtSayHello.setText("Hello "+txtName.getText().toString()+complement);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Toast toast =Toast.makeText(getApplicationContext(),"App created by Jose Manuel Alvarez Martinez",Toast.LENGTH_SHORT);
            toast.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
