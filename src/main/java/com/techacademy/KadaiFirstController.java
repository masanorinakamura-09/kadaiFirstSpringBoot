package com.techacademy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{day}")
    public String dispDayOfWeek(@PathVariable String day){
        try {
        String yobi[]= {"Sunday","Monday","Tuesday","Wendesday","Thursday","Friday","Saturday"};


        SimpleDateFormat sdf=new SimpleDateFormat(day);
        sdf.setLenient(false);
        sdf.parse(day);


        int y=Integer.parseInt(day.substring(0,4));
        int m=Integer.parseInt(day.substring(4,6))-1;
        int d=Integer.parseInt(day.substring(6,8));

        Calendar cal=Calendar.getInstance();
        cal.set(y,m,d);

        return yobi[cal.get(Calendar.DAY_OF_WEEK)-1];
        }catch(Exception ex) {
        return null;
        }
    }

    @GetMapping("/plus/{val1}/{val2}")
    public int calcPlus(@PathVariable int val1,@PathVariable int val2 ) {
        int result=val1+val2;
        return result;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public int calcMinus(@PathVariable int val1,@PathVariable int val2 ) {
        int result=val1-val2;
        return result;
    }

    @GetMapping("/times/{val1}/{val2}")
    public int calcTimes(@PathVariable int val1,@PathVariable int val2 ) {
        int result=val1*val2;
        return result;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public int calcDivide(@PathVariable int val1,@PathVariable int val2 ) {
        int result=val1/val2;
        return result;
    }

}
