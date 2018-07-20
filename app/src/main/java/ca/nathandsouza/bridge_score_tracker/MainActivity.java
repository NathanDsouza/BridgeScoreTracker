package ca.nathandsouza.bridge_score_tracker;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
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

    int numPlayers, curRound, totalRound, bidDiff, winnerPosition;
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



        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (curRound == 0) {
                    newGame();
                } else if (curRound == totalRound) {
                    endGame();

                } else if (curRound == -1) {
                    resetGame();
                }else{
                    updateScore();
                    resetBidsAndWins();
                }



            }
        });

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

        for (int i = 0; i < 6; i++){
            bid[i].setVisibility(View.INVISIBLE);
            win[i].setVisibility(View.INVISIBLE);
            score[i].setVisibility(View.INVISIBLE);
        }


    }

    private void newGame(){
        for (int i = 0; i < 6; i++) {
            if (name[i].getText().toString().equals("")) {
                if (i == 0)  {
                    Toast.makeText(getApplicationContext(),"Input names u clown", Toast.LENGTH_LONG).show();
                    return;
                }
                numPlayers = i;
                break;
            }

            bid[i].setVisibility(View.VISIBLE);
            win[i].setVisibility(View.VISIBLE);
            score[i].setVisibility(View.VISIBLE);
            score[i].setText(Integer.toString(curScore[i]));
            name[i].setEnabled(false);
        }

        for (int j = numPlayers; j  < 6; j++) {
            name[j].setVisibility(View.INVISIBLE);
        }



        nextButton.setText("Next Round");
        totalRound = 52/numPlayers;
        curRound++;
        round.setText("Round " + curRound);

        //Toast.makeText(getApplicationContext(),"Input Bids and Wins", Toast.LENGTH_LONG).show();
    }

    private void updateScore(){
        for (int i = 0; i < numPlayers; i++){
            if (bid[i].getText().toString().equals("") ||
                   (win[i].getText().toString()).equals("")){
                Toast.makeText(getApplicationContext(),"bro input a number", Toast.LENGTH_LONG).show();
                return;
            }
        }

        for (int i = 0; i < numPlayers; i++){
            int bids = Integer.valueOf(bid[i].getText().toString());
            int wins = Integer.valueOf(win[i].getText().toString());
            bidDiff = bids - wins;
            // bidDiff = Integer.valueOf(bid[i].getText().toString()) - Integer.valueOf(win[i].getText().toString());


            //curScore[i] += (bidDiff == 0) ? (10 + bidDiff * bidDiff) : -(bidDiff*bidDiff);
            if (bidDiff == 0){
                curScore[i] += bids * bids + 10;
            } else {
                curScore[i] -= bidDiff * bidDiff;
            }
            score[i].setText(Integer.toString(curScore[i]));

        }

        curRound++;
        round.setText("Round " + curRound);
    }

    private void resetBidsAndWins(){
        for (int i = 0; i < numPlayers; i++){
            bid[i].setText("");
            win[i].setText("");
        }
    }

    private void endGame(){
        winnerPosition = 0;
        for (int i = 0; i < numPlayers; i++){
            if (curScore[i] > curScore[winnerPosition]) winnerPosition = i;
            bid[i].setVisibility(View.INVISIBLE);
            win[i].setVisibility(View.INVISIBLE);
        }
        nextButton.setText("New Game");
        round.setText(name[winnerPosition].getText().toString() + "wins!!!!!");
        round.setTextColor(Color.RED);
        round.setTypeface(null, Typeface.BOLD);
        curRound = -1;


    }

    private void resetGame(){
        for (int i = 0; i < 6; i++){
            curScore[i] = 0;
            name[i].setVisibility(View.VISIBLE);
            name[i].setEnabled(true);
            name[i].setText("");
            bid[i].setText("");
            win[i].setText("");
            score[i].setText("");
            score[i].setVisibility(View.INVISIBLE);
        }
        nextButton.setText("Start Game");
        round.setText("Input Names and Click Start");
        curRound = 0;
    }
}
