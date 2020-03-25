package md.max.jzhou.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //tracking whose turn it is
    private boolean redPlays = true;

    ImageView[][] tiles = new ImageView[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Custom OnClickListener
        TileListener tileListener = new TileListener();

        //Finding all the xml ImageViews and giving them a listener
        tiles[0][0] = findViewById(R.id.tile00);
        tiles[0][1] = findViewById(R.id.tile01);
        tiles[0][2] = findViewById(R.id.tile02);
        tiles[1][0] = findViewById(R.id.tile10);
        tiles[1][1] = findViewById(R.id.tile11);
        tiles[1][2] = findViewById(R.id.tile12);
        tiles[2][0] = findViewById(R.id.tile20);
        tiles[2][1] = findViewById(R.id.tile21);
        tiles[2][2] = findViewById(R.id.tile22);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tiles[i][j].setOnClickListener(tileListener);
            }
        }

    }

    private class TileListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v.getTag().equals("blank")) {
                if(redPlays) {
                    v.setY(-1000f);
                    v.setBackgroundResource(R.drawable.red);
                    v.animate().translationY(0f).setDuration(1000);
                    v.setTag("red");
                    redPlays = !redPlays;
                }
                else {
                    v.setY(-1000f);
                    v.setBackgroundResource(R.drawable.yellow);
                    v.animate().translationY(0f).setDuration(1000);
                    v.setTag("yellow");
                    redPlays = !redPlays;
                }
            }
        }
    }
}
