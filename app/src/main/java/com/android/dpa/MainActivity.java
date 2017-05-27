package com.android.dpa;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button btnChangeEmail, btnChangePassword, btnSendResetEmail, btnRemoveUser,
            changeEmail, changePassword, sendEmail, remove, signOut;

    private EditText oldEmail, newEmail, password, newPassword;
    private ProgressBar progressBar;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    ListView listview;
    private task_db myDb = new task_db(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, SigninActivity.class));
                    finish();
                }
            }
        };
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }

        populateListview();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                View parent1 = (View) view.getParent();
                TextView taskTextView = (TextView) view.findViewById(R.id.id);
                String task = String.valueOf(taskTextView.getText().toString());
                Intent i = new Intent(getApplicationContext(), task_detail.class);
                i.putExtra("reference", task);
                startActivity(i);
            }
        });






    }

    public void populateListview()
    {
        Cursor cursor=myDb.getData();
        String[] fromFieldNames=new String[]{task_db.COL1,task_db.COL6};
        int[] findViewId=new int[]{R.id.tv_name,R.id.id};
        SimpleCursorAdapter myAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.list_item,cursor,fromFieldNames,findViewId,0);
        listview = (ListView)findViewById(R.id.task_listview);
        listview.setAdapter(myAdapter);







    }

    public void deleteTask(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.id);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = myDb.getWritableDatabase();
        db.delete(task_db.TABLE_NAME,
                task_db.COL6 + " = ?",
                new String[]{task});
        db.close();
       populateListview();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        switch (item.getItemId())
        {
            case R.id.menu_signout:
                // Single menu item is selected do something
                // Ex: launching new activity/screen or show alert message
                auth.signOut();
                startActivity(new Intent(MainActivity.this, SigninActivity.class));
                finish();

                return true;




            case R.id.menu_deleteaccount:
                if (user != null) {
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this, "Your profile is deleted:( Create a account now!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(MainActivity.this, SignupActivity.class));
                                        finish();
                                        progressBar.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(MainActivity.this, "Failed to delete your account!", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                }

                return true;

            case(R.id.add):

                Intent i=new Intent(this,register.class);
                startActivity(i);
                finish();

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public AdapterView getListView() {
        return listview;
    }
}
