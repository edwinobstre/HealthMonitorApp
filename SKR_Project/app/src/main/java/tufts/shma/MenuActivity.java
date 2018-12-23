package tufts.shma;

import tufts.shma.BodyMassIndex.BMI;
import tufts.shma.Calendar.CalendarHelper;
import tufts.shma.Diet.DietDatabaseHelper;
<<<<<<< HEAD
import tufts.shma.StepCounter.StepDatabaseHelper;
import tufts.shma.Calendar.CalendarHelper;
=======

import android.app.Service;
>>>>>>> Qinlong
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.database.Cursor;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shinelw.library.ColorArcProgressBar;

<<<<<<< HEAD
import java.util.regex.Pattern;

import tufts.shma.BodyMassIndex.BMI;
import tufts.shma.StepCounter.SensorStepService;


=======
>>>>>>> Qinlong
public class MenuActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, SensorEventListener {

<<<<<<< HEAD
    private View step_fg,bmi_fg,diet_fg,sleep_fg,water_fg,history_fg,profile_fg;
=======
    private View step_fg,bmi_fg,diet_fg,sleep_fg,water_fg/*,history_fg,profile_fg*/;
>>>>>>> Qinlong
    private ImageView ivIndex;
    private TextView bmi_result;
    private String bmi;
    private SensorManager sManager;
    private Sensor mSensorAccelerometer;
    private TextView tv_step;
    private Button btn_start;
    private int step = 0;
    private TextView tv_date;
<<<<<<< HEAD
    private Button btn_start;
    private TextView tv_sleep;
    int sleep_time = 0;

=======
    private TextView tv_sleep;
    int sleep_time = 0;
>>>>>>> Qinlong
    private double oriValue = 0;
    private double lstValue = 0;
    private double curValue = 0;
    private boolean motiveState = true;
    private boolean processState = false;
    final int target_bottle = 8;
    Integer current_bottle = new Integer(0);
    private Vibrator myVibrator;

    private Button add,minus;
    private TextView target_ach;
    private ColorArcProgressBar bar2;


    DietDatabaseHelper myDb;
    EditText editName,editCalories, editFat,editCholesterol, editSodium;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    int totalCalories, totalFat, totalCholesterol, totalSodium;
    Button btnviewUpdate;


    private void allfg_gone(){
        bmi_fg.setVisibility(View.GONE);
        step_fg.setVisibility(View.GONE);
        diet_fg.setVisibility(View.GONE);
        sleep_fg.setVisibility(View.GONE);
        water_fg.setVisibility(View.GONE);
<<<<<<< HEAD
        history_fg.setVisibility(View.GONE);
        profile_fg.setVisibility(View.GONE);
=======
//        history_fg.setVisibility(View.GONE);
>>>>>>> Qinlong
//        profile_fg.setVisibility(View.GONE);
    }


    //BMI
    private void ivRotate(double percent) {
        double percent_new;
        RotateAnimation rotateAnimation;
        if (percent <= 0){
            rotateAnimation = new RotateAnimation(0.0f, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        } else if (percent < 25){
            percent_new = percent - 12;
            rotateAnimation = new RotateAnimation(0.0f, 72 * ((int) percent_new / 13f), Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        } else if(percent >= 25 && 100 > percent){
            percent_new = percent - 25;
            rotateAnimation = new RotateAnimation(0.0f, 72 + 108 * ((int) percent_new / 15f), Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        } else{
            rotateAnimation = new RotateAnimation(0.0f, 180.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        }
        rotateAnimation.setDuration(1500);
        rotateAnimation.setFillAfter(true);
        ivIndex.startAnimation(rotateAnimation);
    }
    //~BMI
    //Sleep
    public String sleep_gap() {
        CalendarHelper cal = new CalendarHelper();
        int current_minutes = cal.getMinutes();
        int current_hours = cal.getHours();
        if(current_minutes % 5 == 0 && processState == false) {
            if (current_hours >= 21 || current_hours <= 9){
                sleep_time += 5*60;
<<<<<<< HEAD
                }
                else if(current_hours == 10){
=======
            }
            else if(current_hours == 10){
>>>>>>> Qinlong
                sleep_time = 0;
            }
        }

<<<<<<< HEAD
            return (cal.convertSeconds(sleep_time));
    }
=======
        return (cal.convertSeconds(sleep_time));
    }
    //~sleep
>>>>>>> Qinlong
    //Step
    @Override
    public void onSensorChanged(SensorEvent event) {
        double range = 11;
        float[] value = event.values;
        curValue = magnitude(value[0], value[1], value[2]);

        if (motiveState == true) {
            if (curValue >= lstValue) lstValue = curValue;
            else {
                if (Math.abs(curValue - lstValue) > range) {
                    oriValue = curValue;
                    motiveState = false;
                }
            }
        }

        if (motiveState == false) {
            if (curValue <= lstValue) lstValue = curValue;
            else {
                if (Math.abs(curValue - lstValue) > range) {
                    oriValue = curValue;
                    if (processState == true) {
                        step++;
                        if (processState == true) {
                            tv_step.setText(step + "");
                        }
                    }
                    motiveState = true;
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void onClick(View v) {
        step = 0;
        tv_step.setText("0");
        if (processState == true) {
            btn_start.setText("START");
            processState = false;
        } else {
            btn_start.setText("STOP");
            processState = true;
        }
    }

    public double magnitude(float x, float y, float z) {
        double magnitude = 0;
        magnitude = Math.sqrt(x * x + y * y + z * z);
        return magnitude;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sManager.unregisterListener(this);
    }
    //~Step
    //Diet
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editName.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MenuActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MenuActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editName.getText().toString(),
                                editCalories.getText().toString(),
                                editFat.getText().toString(),
                                editCholesterol.getText().toString(),
                                editSodium.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MenuActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MenuActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editName.getText().toString().equals("") || editCalories.getText().toString().equals("") || editFat.getText().toString().equals("") || editCholesterol.getText().toString().equals("") || editSodium.getText().toString().equals("")) {
                            Toast.makeText(MenuActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
                        }
                        else {
                            boolean isInserted = myDb.insertData(editName.getText().toString(), editCalories.getText().toString(), editFat.getText().toString(), editCholesterol.getText().toString(), editSodium.getText().toString());
                            if (isInserted == true)
                                Toast.makeText(MenuActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else{
                                Toast.makeText(MenuActivity.this, "Data Fail To Inserted", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Message","Nothing found");
                            return;
                        }

                        StringBuffer name_buff = new StringBuffer();
                        StringBuffer fat_buff = new StringBuffer();
                        StringBuffer cal_buff = new StringBuffer();
                        StringBuffer chl_buff = new StringBuffer();
                        StringBuffer sod_buff = new StringBuffer();

                        while(res.moveToNext()) {
                            name_buff.append("Name: "+ res.getString(0)+"\n");
                            totalCalories += Integer.parseInt(res.getString(1));
                            totalFat += Integer.parseInt(res.getString(2));
                            totalCholesterol += Integer.parseInt(res.getString(3));
                            totalSodium += Integer.parseInt(res.getString(4));
                        }

                        name_buff.append("\n" + "TOTAL \n");

                        if (totalCalories >= 2000) {
                            cal_buff.append("Calories: " + Integer.toString(totalCalories) + " TOO HIGH \n");
                        } else {
                            cal_buff.append("Calories: " + Integer.toString(totalCalories) + "\n");
                        }

                        if (totalFat >= 77) {
                            fat_buff.append("Fat: " + Integer.toString(totalFat) + " TOO HIGH \n");
                        } else {
                            fat_buff.append("Fat: " + Integer.toString(totalFat) + "\n");
                        }

                        if (totalCholesterol >= 300) {
                            chl_buff.append("Cholesterol: " + Integer.toString(totalCholesterol) + " TOO HIGH\n");
                        } else {
                            chl_buff.append("Cholesterol: " + Integer.toString(totalCholesterol) + "\n");
                        }

                        if (totalSodium >= 2300) {
                            sod_buff.append("Sodium: " + Integer.toString(totalSodium) + " TOO HIGH \n\n");
                        } else {
                            sod_buff.append("Sodium: " + Integer.toString(totalSodium) + "\n\n");
                        }

                        // Show all data
                        showMessage("DATA",name_buff.toString() + cal_buff.toString()
                                + fat_buff.toString() + chl_buff.toString() + sod_buff.toString());

                        totalCalories = 0;
                        totalFat = 0;
                        totalSodium = 0;
                        totalCholesterol = 0;

                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    //~Diet


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //BMI function
        ivIndex = (ImageView)findViewById(R.id.iv_index);
        bmi_result=(TextView)findViewById(R.id.bmi_text);
        SharedPreferences sp2= getSharedPreferences("Login", MODE_MULTI_PROCESS);
        BMI bmi1 = new BMI();
        bmi = bmi1.BMI_caculate(sp2.getString("C_weight", null),sp2.getString("Height", null));
        ivRotate(Double.valueOf(bmi));
        bmi_result.setText(bmi);
<<<<<<< HEAD
=======
        //fitness_progress.setMax(Integer.valueOf(max_date).intValue());
>>>>>>> Qinlong
        //sleep
        tv_sleep = (TextView) findViewById(R.id.tv_sleep);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000 * 60);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // update TextView here!
                                tv_sleep.setText(sleep_gap());
                            }
                        });
                    }
                }
                catch (InterruptedException e) {
                }
            }
        };
        t.start();
        CalendarHelper cal = new CalendarHelper();
        tv_date=(TextView)findViewById(R.id.tv_date);
        tv_date.setText(cal.dateGet());
<<<<<<< HEAD
        //progress
        String max_date = sp2.getString("Period","0");
        fitness_progress.setProgress(4);
        fitness_progress.setMax(Integer.valueOf(max_date).intValue());
=======
>>>>>>> Qinlong
        //Step function
        sManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorAccelerometer = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sManager.registerListener(this, mSensorAccelerometer, SensorManager.SENSOR_DELAY_UI);
        tv_step = (TextView) findViewById(R.id.tv_step);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
        //Water function
        bar2 = (ColorArcProgressBar) findViewById(R.id.bar2);
        add = (Button) findViewById(R.id.add);
        minus = (Button)findViewById(R.id.minus);
        target_ach = (TextView)findViewById(R.id.target_ach);
        myVibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minus.setEnabled(true);
                current_bottle++;
                bar2.setCurrentValues(current_bottle);
                if(current_bottle >= target_bottle){
                    target_ach.setText("Daily Target Is Achieved.");
                }
                if(current_bottle == 8){
                    add.setEnabled(false);
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add.setEnabled(true);
                current_bottle--;
                bar2.setCurrentValues(current_bottle);
                if (current_bottle < target_bottle) {
                    target_ach.setText("Cheer Up.");
                }
                if (current_bottle == 0){
                    minus.setEnabled(false);
                }
            }
        });

        minus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                add.setEnabled(true);
                current_bottle = 0;
                bar2.setCurrentValues(current_bottle);
                target_ach.setText("Cheer Up.");
                minus.setEnabled(false);
                myVibrator.cancel();
                myVibrator.vibrate(500);
                return true;
            }
        });
        //~~

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Developed by SKR: Fuzhong, Qinlong, Shi, Winne, Yulei.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_signout) {
            startActivity(new Intent(MenuActivity.this, LogActivity.class));
            finishAffinity();
            return true;
        }else if(id == R.id.action_quit){
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        bmi_fg = findViewById(R.id.bmi_fg);
        step_fg = findViewById(R.id.step_fg);
        diet_fg = findViewById(R.id.diet_fg);
        sleep_fg = findViewById(R.id.sleep_fg);
        water_fg = findViewById(R.id.water_fg);
//        history_fg = findViewById(R.id.history_fg);
//        profile_fg = findViewById(R.id.profile_fg);


        myDb = new DietDatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editCalories = (EditText)findViewById(R.id.editText_calories);
        editFat = (EditText)findViewById(R.id.editText_fat);
        editCholesterol = (EditText)findViewById(R.id.editText_cholesterol);
        editSodium = (EditText)findViewById(R.id.editText_sodium);

        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate = (Button)findViewById(R.id.button_update);
        btnDelete = (Button)findViewById(R.id.button_delete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();

<<<<<<< HEAD

=======
>>>>>>> Qinlong
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        int id = item.getItemId();

        if (id == R.id.nav_bmi) {
            toolbar.setTitle("BMI");
            //index action redo
            ivRotate(Double.valueOf(bmi));
            allfg_gone();
            bmi_fg.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.nav_steps) {
<<<<<<< HEAD

=======
            toolbar.setTitle("STEPS");
>>>>>>> Qinlong
            allfg_gone();
            step_fg.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.nav_diet) {
            toolbar.setTitle("DIET");
            allfg_gone();
            diet_fg.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.nav_sleep) {
            toolbar.setTitle("SLEEP");
            allfg_gone();
            sleep_fg.setVisibility(View.VISIBLE);
        }
        else if (id == R.id.nav_water) {
            toolbar.setTitle("Water");
            allfg_gone();
            water_fg.setVisibility(View.VISIBLE);
        }
//        else if (id == R.id.nav_history) {
//            toolbar.setTitle("History");
//            allfg_gone();
//            history_fg.setVisibility(View.VISIBLE);
//        }
        else if (id == R.id.nav_profile) {
            User user2 = new User();
            Bundle bd2 = new Bundle();
            bd2.putString("username_to_userinfo", user2.getUsername());
            bd2.putString("password_to_userinfo", user2.getPassword());
            startActivity((new Intent(MenuActivity.this, UserInfoActivity.class)).putExtras(bd2));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
