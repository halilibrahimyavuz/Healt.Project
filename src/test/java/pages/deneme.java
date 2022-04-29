package pages;

import io.cucumber.java.en.Then;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class deneme
{
    public static void main(String[] args) {


        LocalDate date = LocalDate.now();


        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'00:00");
        String timeF;
        timeF = formatter.format(time);
        System.out.println("timeF = " + timeF);

        System.out.println("date = " + date);
        System.out.println("time = " + time);

        String date1 = ReusableMethods.setTheDateByRandomWithTime("dd-MM-yyyy hh:mm",1,"feature");
        String date2 = ReusableMethods.setTheDateByRandomWithTime("dd-MM-yyyy HH:mm",1,"feature");

        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);

        List<Integer> a = new ArrayList<>();
        a.add(1); //0
        a.add(2);//1
        a.add(3);//2
        System.out.println("a.size() = " + a.size());


        /*
        @Then("TY Kullanici Room Number TextBox'ina Tiklar Ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur")
        public void tyKullaniciRoomNumberTextBoxInaTiklarVeDahaOnceKullanilmamisBirOdaNumarasiIleDoldurur()
        {

        }

         */


        // 2022-04-23T00:00

    }


}
