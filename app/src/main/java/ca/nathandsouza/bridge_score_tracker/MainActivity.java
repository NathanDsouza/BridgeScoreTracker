package ca.nathandsouza.bridge_score_tracker;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    int numPlayers, curRound, totalRound;
    class Player{
        String name;
        int guess;
        int score;
    };

    EditText [] name = new EditText[6];
    EditText [] bid = new EditText[6];
    EditText [] win = new EditText[6];
    TextView [] score = new TextView[6];
    TextView round;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
        curRound = 0;

        Toast.makeText(getApplicationContext(),"BRIDGE", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"SCORE", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"TRACKER", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"YEA!!!", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Input names and click Start", Toast.LENGTH_LONG).show();




        numPlayers = getNumPlayers();
        Player [] playerArray = new Player [numPlayers];


        }
    private void initializer() {
        name[0] = (EditText) findViewById(R.id.name1);
        name[1] = (EditText) findViewById(R.id.name2);
        name[2] = (EditText) findViewById(R.id.name3);
        name[3] = (EditText) findViewById(R.id.name4);
        name[4] = (EditText) findViewById(R.id.name5);
        name[5] = (EditText) findViewById(R.id.name6);

        bid[0] = (EditText) findViewById(R.id.bid1);
        bid[1] = (EditText) findViewById(R.id.bid2);
        bid[2] = (EditText) findViewById(R.id.bid3);
        bid[3] = (EditText) findViewById(R.id.bid4);
        bid[4] = (EditText) findViewById(R.id.bid5);
        bid[5] = (EditText) findViewById(R.id.bid6);

        win[0] = (EditText) findViewById(R.id.win1);
        win[1] = (EditText) findViewById(R.id.win2);
        win[2] = (EditText) findViewById(R.id.win3);
        win[3] = (EditText) findViewById(R.id.win4);
        win[4] = (EditText) findViewById(R.id.win5);
        win[5] = (EditText) findViewById(R.id.win6);

        round = (TextView) findViewById(R.id.round);
        nextButton = (Button) findViewById(R.id.nextButton);


    }
    }

}
