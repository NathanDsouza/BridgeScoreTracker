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

    int numPlayers, curRound, totalRound, bidDiff;
    int [] curScore = new int[6];
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
        initializeViews();
        curRound = 0;


        Toast.makeText(getApplicationContext(),"Input names and click Start", Toast.LENGTH_LONG).show();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nextButton.getText().toString().equals("Start Game")) {
                    initializeTracker();
                } else if (curRound == totalRound) {


                } else {
                    updateScore();
                    resetBidsAndWins();
                }
                curRound++;
                round.setText("Round " + curRound);


            }
        });




       // numPlayers = getNumPlayers();


        }
    private void initializeViews(){
        //test
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

        score[0] = (TextView) findViewById(R.id.score1);
        score[1] = (TextView) findViewById(R.id.score2);
        score[2] = (TextView) findViewById(R.id.score3);
        score[3] = (TextView) findViewById(R.id.score4);
        score[4] = (TextView) findViewById(R.id.score5);
        score[5] = (TextView) findViewById(R.id.score6);

        round = (TextView) findViewById(R.id.round);
        nextButton = (Button) findViewById(R.id.nextButton);


    }

    private void initializeTracker(){
        for (int i = 0; i < 6; i++) {
            if (name[i].getText().toString().equals("")) {
                numPlayers = i;
                break;
            }
            score[i].setText(Integer.toString(curScore[i]));
        }

        for (int j = numPlayers; j  < 6; j++) {
            name[j].setVisibility(View.INVISIBLE);
            bid[j].setVisibility(View.INVISIBLE);
            win[j].setVisibility(View.INVISIBLE);
            score[j].setVisibility(View.INVISIBLE);
        }



        nextButton.setText("Next Round");
        totalRound = 52/numPlayers;

        Toast.makeText(getApplicationContext(),"Input Bids and Wins", Toast.LENGTH_LONG).show();
    }

    private void updateScore(){
        for (int i = 0; i < numPlayers; i++){
            bidDiff = Integer.valueOf(bid[i].getText().toString()) - Integer.valueOf(win[i].getText().toString());


            curScore[i] += (bidDiff == 0) ? (10 + bidDiff * bidDiff) : -(bidDiff*bidDiff);
            score[i].setText(Integer.toString(curScore[i]));
        }
    }

    private void resetBidsAndWins(){
        for (int i = 0; i < numPlayers; i++){
            bid[i].setText("");
            win[i].setText("");
        }
    }
}
