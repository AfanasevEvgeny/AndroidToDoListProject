package com.example.mainactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView mTaskListView;
    final static String TAG = "...";
    ArrayAdapter<String> mAdapter;
    String[] taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView (R.layout.activity_main );
        mTaskListView = (ListView) findViewById(R.id.list_todo);
        mAdapter = new ArrayAdapter<String>(this,
                R.layout.todo_item,
                R.id.task_title,
                taskList);;
        mTaskListView . setAdapter ( mAdapter );

    }

    @Override
    public boolean onCreateOptionsMenu ( Menu menu ) {
        getMenuInflater () . inflate (R. menu . main_menu , menu );
        return super . onCreateOptionsMenu ( menu ) ;
    }
    @Override
    public boolean onOptionsItemSelected ( MenuItem item ) {
        switch ( item . getItemId () ) {
            case R.id. action_add_task :
                Log.d(" MainClass " , " Add a new task ");
                final EditText taskEditText = new EditText ( this );
                AlertDialog dialog = new AlertDialog . Builder ( this )
                        . setTitle (" Add a new task " )
                        . setMessage ( " What do you want to do next ?")
                        . setView ( taskEditText )
                        . setPositiveButton (" Add " , new DialogInterface.
                                OnClickListener () {
                            @Override
                            public void onClick ( DialogInterface dialog , int which )
                            {
                                String task = String . valueOf ( taskEditText . getText ()
                                );
                                Log .d(TAG , " Task to add : " + task ) ;
                            }
                        })
                        . setNegativeButton (" Cancel " , null )
                        . create () ;
                dialog . show () ;

                return true ;
            default :
                return super . onOptionsItemSelected ( item );
        }
    }

}
