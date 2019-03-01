package htl.grieskirchen.aedinger16woche21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;

//Navigate to the folder that contains the files for your project.
  //      If you have not yet created a .git file, run the git commit command.
    //    Create a .gitignore file by running touch .gitignore. The file name ".gitignore" is case sensitive and the name of the file matters. Git will look for a file with that name and will not stage (add) or commit files that is is told to ignore.
      //  Use vim to open the file by running vim .gitignore. This will open a text editor called "Vim" inside your console.
        //Press the escape key to enter and exit text-entry mode.
        //Once you have updated your .gitignore files you can save and exit vim by pressing escape, entering :wq, and pressing return/enter

public class MainActivity extends AppCompatActivity {

    //region members
    private ListView datagrid;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datagrid = findViewById(R.id.listViewEintraege);


    }

    private void fillGrid() {
        for(int i=0; i< 10; i++) {
            TableRow row = new TableRow(this);
            //set row
            for(int j=0; j< 3; j++) {
                TextView actualData = new TextView(this);
                //set properties
                row.addView(actualData);
            }


        }
    }


}
