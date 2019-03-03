package htl.grieskirchen.aedinger16woche21;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Navigate to the folder that contains the files for your project.
  //      If you have not yet created a .git file, run the git commit command.
    //    Create a .gitignore file by running touch .gitignore. The file name ".gitignore" is case sensitive and the name of the file matters. Git will look for a file with that name and will not stage (add) or commit files that is is told to ignore.
      //  Use vim to open the file by running vim .gitignore. This will open a text editor called "Vim" inside your console.
        //Press the escape key to enter and exit text-entry mode.
        //Once you have updated your .gitignore files you can save and exit vim by pressing escape, entering :wq, and pressing return/enter

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //region members
    private ListView data;
    private EditText editTextDate;
    private Spinner spinnerAOE;
    private int mYear, mMonth, mDay;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTodaysDate();

        data = findViewById(R.id.listViewEintraege);

        editTextDate = findViewById(R.id.textViewDatum);
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        spinnerAOE = findViewById(R.id.dropdownAOE);
        ArrayAdapter<CharSequence> adapterAOE = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapterAOE.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAOE.setAdapter(adapterAOE);
        spinnerAOE.setOnItemSelectedListener(this);

    }

    private void showDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        editTextDate.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void setTodaysDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        String dateString = dateFormat.format(date).toString();
        String[] dateParts = dateString.split("\\.");
        mDay = Integer.parseInt(dateParts[0]);
        mMonth = Integer.parseInt(dateParts[1]);
        mYear = Integer.parseInt(dateParts[2]);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
