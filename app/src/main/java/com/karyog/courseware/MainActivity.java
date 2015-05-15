package com.karyog.courseware;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();

        try {
            display.getSize(size);
        } catch (java.lang.NoSuchMethodError ignore) { // Older device
            size.x = display.getWidth();
            size.y = display.getHeight();
        }

        int screen_width = size.x;
        int screen_height = size.y;

        // Prepare screen based on width and height of the display
        prepare_screen_default(screen_width, screen_height);
    }

    @SuppressLint("InflateParams")
    private void prepare_screen_default(int screen_width, int screen_height) {
        LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout v = (RelativeLayout) li.inflate(R.layout.activity_main,
                null);

        // Divide the space equally for the controls
        // width has the be divided into 5 as there are 5 columns.
        // height has to be divided by 7.5 -> 6 for buttons, 1 for the display,
        // and .5 for the mini display that keeps track of operation sequence
        // equals symbol will have twice the height, zero will have twice the
        // width
        int width = screen_width;
        int height = screen_height - (screen_height % 15);

        String subjects[] = {"java", "cpp"};
        for (String subject:subjects) {
//            ImageView = new ImageView()
            subject = subject + ".jpg";
        }
        setContentView(R.layout.activity_main);

        ImageView img = (ImageView) findViewById(R.id.btnJava);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FaqActivity.class);
                startActivity(intent);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
