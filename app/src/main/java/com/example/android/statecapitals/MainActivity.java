package com.example.android.statecapitals;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private HashMap<String,String> stateAbbreviation = null; // holds the pair state-abbreviation
    private HashMap<String,String> stateCapitals = null; // holds the pair state-capital
    private String[] states=null; //holds an array with all the states.
    private String targetState= null; //holds a state name selected at random
    private String targetAbbreviation=null; //holds the abbreviation of the state
    private String targetCapital=null;  //holds the state capital
    private int abbreviationAttempt = 0; //number of guess attempts for the state abbreviation
    private int capitalAttempt = 0;  // number of guess attempts for the state capitals

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFacts();
        selectState();

    }

    /**
     * sets the dictionaries and array containing state names, capitals and abbreviations
     */
    private void setFacts()
    {
        stateAbbreviation = new HashMap<String, String>();

        stateAbbreviation.put("Alabama", "AL");
        stateAbbreviation.put("Alaska", "AK");
        stateAbbreviation.put("American Samoa", "AS");
        stateAbbreviation.put("Arizona", "AZ");
        stateAbbreviation.put("Arkansas", "AR");
        stateAbbreviation.put("California", "CA");
        stateAbbreviation.put("Colorado", "CO");
        stateAbbreviation.put("Connecticut", "CT");
        stateAbbreviation.put("Delaware", "DE");
        stateAbbreviation.put("District Of Columbia", "DC");
        stateAbbreviation.put("Federated States Of Micronesia", "FM");
        stateAbbreviation.put("Florida", "FL");
        stateAbbreviation.put("Georgia", "GA");
        stateAbbreviation.put("Guam", "GU");
        stateAbbreviation.put("Hawaii", "HI");
        stateAbbreviation.put("Idaho", "ID");
        stateAbbreviation.put("Illinois", "IL");
        stateAbbreviation.put("Indiana", "IN");
        stateAbbreviation.put("Iowa", "IA");
        stateAbbreviation.put("Kansas", "KS");
        stateAbbreviation.put("Kentucky", "KY");
        stateAbbreviation.put("Louisiana", "LA");
        stateAbbreviation.put("Maine", "ME");
        stateAbbreviation.put("Marshall Islands", "MH");
        stateAbbreviation.put("Maryland", "MD");
        stateAbbreviation.put("Massachusetts", "MA");
        stateAbbreviation.put("Michigan", "MI");
        stateAbbreviation.put("Minnesota", "MN");
        stateAbbreviation.put("Mississippi", "MS");
        stateAbbreviation.put("Missouri", "MO");
        stateAbbreviation.put("Montana", "MT");
        stateAbbreviation.put("Nebraska", "NE");
        stateAbbreviation.put("Nevada", "NV");
        stateAbbreviation.put("New Hampshire", "NH");
        stateAbbreviation.put("New Jersey", "NJ");
        stateAbbreviation.put("New Mexico", "NM");
        stateAbbreviation.put("New York", "NY");
        stateAbbreviation.put("North Carolina", "NC");
        stateAbbreviation.put("North Dakota", "ND");
        stateAbbreviation.put("Northern Mariana Islands", "MP");
        stateAbbreviation.put("Ohio", "OH");
        stateAbbreviation.put("Oklahoma", "OK");
        stateAbbreviation.put("Oregon", "OR");
        stateAbbreviation.put("Palau", "PW");
        stateAbbreviation.put("Pennsylvania", "PA");
        stateAbbreviation.put("Puerto Rico", "PR");
        stateAbbreviation.put("Rhode Island", "RI");
        stateAbbreviation.put("South Carolina", "SC");
        stateAbbreviation.put("South Dakota", "SD");
        stateAbbreviation.put("Tennessee", "TN");
        stateAbbreviation.put("Texas", "TX");
        stateAbbreviation.put("Utah", "UT");
        stateAbbreviation.put("Vermont", "VT");
        stateAbbreviation.put("Virgin Islands", "VI");
        stateAbbreviation.put("Virginia", "VA");
        stateAbbreviation.put("Washington", "WA");
        stateAbbreviation.put("West Virginia", "WV");
        stateAbbreviation.put("Wisconsin", "WI");
        stateAbbreviation.put("Wyoming", "WY");

        stateCapitals = new HashMap<String, String>();

        stateCapitals.put("Alabama","Montgomery");
        stateCapitals.put("Alaska","Juneau");
        stateCapitals.put("Arizona","Phoenix");
        stateCapitals.put("Arkansas","Little Rock");
        stateCapitals.put("California","Sacramento");
        stateCapitals.put("Colorado","Denver");
        stateCapitals.put("Connecticut","Hartford");
        stateCapitals.put("Delaware","Dover");
        stateCapitals.put("Florida","Tallahassee");
        stateCapitals.put("Georgia","Atlanta");
        stateCapitals.put("Hawaii","Honolulu");
        stateCapitals.put("Idaho","Boise");
        stateCapitals.put("Illinois ","Springfield");
        stateCapitals.put("Indiana","Indianapolis");
        stateCapitals.put("Iowa","Des Moines");
        stateCapitals.put("Kansas","Topeka");
        stateCapitals.put("Kentucky","Frankfort");
        stateCapitals.put("Louisiana","Baton Rouge");
        stateCapitals.put("Maine","Augusta");
        stateCapitals.put("Maryland","Annapolis");
        stateCapitals.put("Massachusetts","Boston");
        stateCapitals.put("Michigan","Lansing");
        stateCapitals.put("Minnesota","St. Paul");
        stateCapitals.put("Mississippi","Jackson");
        stateCapitals.put("Missouri","Jefferson City");
        stateCapitals.put("Montana","Helena");
        stateCapitals.put("Nebraska","Lincoln");
        stateCapitals.put("Nevada","Carson City");
        stateCapitals.put("New Hampshire","Concord");
        stateCapitals.put("New Jersey","Trenton");
        stateCapitals.put("New Mexico","Santa Fe");
        stateCapitals.put("New York","Albany");
        stateCapitals.put("North Carolina","Raleigh");
        stateCapitals.put("North Dakota","Bismarck");
        stateCapitals.put("Ohio","Columbus");
        stateCapitals.put("Oklahoma","Oklahoma City");
        stateCapitals.put("Oregon","Salem");
        stateCapitals.put("Pennsylvania","Harrisburg");
        stateCapitals.put("Rhode Island","Providence");
        stateCapitals.put("South Carolina","Columbia");
        stateCapitals.put("South Dakota","Pierre");
        stateCapitals.put("Tennessee","Nashville");
        stateCapitals.put("Texas","Austin");
        stateCapitals.put("Utah","Salt Lake City");
        stateCapitals.put("Vermont","Montpelier");
        stateCapitals.put("Virginia","Richmond");
        stateCapitals.put("Washington","Olympia");
        stateCapitals.put("West Virginia","Charleston");
        stateCapitals.put("Wisconsin","Madison");
        stateCapitals.put("Wyoming","Cheyenne");

        states = new String[]{
                "Alabama",
                "Alaska",
                "Arizona",
                "Arkansas",
                "California",
                "Colorado",
                "Connecticut",
                "Delaware",
                "Florida",
                "Georgia",
                "Hawaii",
                "Idaho",
                "Illinois",
                "Indiana",
                "Iowa",
                "Kansas",
                "Kentucky",
                "Louisiana",
                "Maine",
                "Maryland",
                "Massachusetts",
                "Michigan",
                "Minnesota",
                "Mississippi",
                "Missouri",
                "Montana",
                "Nebraska",
                "Nevada",
                "New Hampshire",
                "New Jersey",
                "New Mexico",
                "New York",
                "North Carolina",
                "North Dakota",
                "Ohio",
                "Oklahoma",
                "Oregon",
                "Pennsylvania",
                "Rhode Island",
                "South Carolina",
                "South Dakota",
                "Tennessee",
                "Texas",
                "Utah",
                "Vermont",
                "Virginia",
                "Washington",
                "West Virginia",
                "Wisconsin",
                "Wyoming"};
    }

    /**
     * Called from the NEW STATE button to get new state information
     * @param v
     */
    public void newState(View v)
    {
        selectState();
    }

    /**
     * Resets all EditText objects, Selects a state at random and retrieves the right answers.
     */
    public void selectState()
    {
        resetAbb();
        resetCap();
        Random rnd = new Random();
        int stateNumber = rnd.nextInt(50);

        targetState = states[stateNumber];
        targetAbbreviation=stateAbbreviation.get(targetState);
        targetCapital=stateCapitals.get(targetState);
        TextView tv = (TextView) findViewById(R.id.stateToBeGuessed);
        tv.setText(targetState);

    }

    /**
     * Called from the FINAL ANSWER button to check if the user entered the right abbreviation
     * @param v
     */
    public void checkAbbreviation(View v)
    {
        EditText et = (EditText) findViewById(R.id.state_abbreviation);
        String guess = et.getText().toString();

        Log.v("MainActivity",Integer.toString(abbreviationAttempt));

        if(targetAbbreviation.equalsIgnoreCase(guess))
        {
            if(abbreviationAttempt>=0)
            {
                Toast.makeText(this,"YOU GOT IT!!", Toast.LENGTH_SHORT).show();
                abbreviationAttempt = -100;
            }

            return;
        }
        else
        {
            abbreviationAttempt ++;
            if (abbreviationAttempt<6)
            {
                Toast.makeText(this,"Try Again!!", Toast.LENGTH_SHORT).show();
                et.setText("");
                return;
            }

            et.setText(targetAbbreviation);
            return;

        }

    }

    /**
     * Resets the EditText for the State Abbreviation.
      */
    public void resetAbb()
    {
        abbreviationAttempt=0;
        EditText et = (EditText) findViewById(R.id.state_abbreviation);
        et.setText("");

    }

    /**
     * Called from the RESET ANSWER button to reset the state abbreviation EditText
     * @param v
     */
    public void resetAbbreviation(View v)
    {
        resetAbb();
    }

    /**
     * gets user input from the capital EditText object and compares against the targetCapital
     * @param v
     */
    public void checkCapital(View v)
    {
        EditText et = (EditText) findViewById(R.id.state_capital);
        String guess = et.getText().toString();

        Log.v("MainActivity",Integer.toString(capitalAttempt));

        if(targetCapital.equalsIgnoreCase(guess))
        {
            if(capitalAttempt>=0)
            {
                Toast.makeText(this,"YOU GOT IT!!", Toast.LENGTH_SHORT).show();
                capitalAttempt = -100;
            }

            return;
        }
        else
        {
            capitalAttempt ++;
            if (capitalAttempt<6)
            {
                Toast.makeText(this,"Try Again!!", Toast.LENGTH_SHORT).show();
                et.setText("");
                return;
            }

            et.setText(targetCapital);
            return;

        }

    }

    /**
     * resets the capital EditText object
     */
    public void resetCap()
    {
        capitalAttempt=0;
        EditText et = (EditText) findViewById(R.id.state_capital);
        et.setText("");

    }

    /**
     * resets the capital EditText when called from Reset button
     * @param v
     */
    public void capitalReset(View v)
    {
        resetCap();
    }

}
