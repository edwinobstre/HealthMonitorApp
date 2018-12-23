package tufts.shma;

import android.content.Context;
import java.io.FileOutputStream;
import java.io.IOException;

public class User {

    private String username;
    private String password;
    private String gender;
    private String height_cm;
    private String age;
    private String cur_weight;
    private String ideal_weight;
    private String time_period;


    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    public void setHeight_cm(String height_cm) {
        this.height_cm = height_cm;
    }
    public String getHeight_cm() {
        return height_cm;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getAge() {
        return age;
    }

    public void setCur_weight(String cur_weight) {
        this.cur_weight = cur_weight;
    }
    public String getCur_weight() {
        return cur_weight;
    }

    public void setIdeal_weight(String ideal_weight) {
        this.ideal_weight = ideal_weight;
    }
    public String getIdeal_weight() {
        return ideal_weight;
    }

    public void setTime_period(String time_period) {
        this.time_period = time_period;
    }
    public String getTime_period() {
        return time_period;
    }


}
