package software.rsquared.textdecorator.sample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import software.rsquared.textdecorator.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        Text text = new Text("Test", Text.color(this, R.color.colorPrimary).bold())
                .append(" ")
                .append("clickable", Text.color(Color.RED).underline().click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Działa :D", Toast.LENGTH_SHORT).show();
                    }
                }))
                .append("2", Text.superscript().size(0.5f).color(Color.BLUE))
                .append(" ")
                .withContext(this)
                .append(R.string.app_name, Text.strikethrough().italic().backgroundColor(this, R.color.colorAccent));

        textView.setText(text);
    }

//    Text.apply("asd").apply(Text.apply("asd", TextStyle.bold(), TextStyle.italic()), TextStyle.color(R.color.red_300))
}
