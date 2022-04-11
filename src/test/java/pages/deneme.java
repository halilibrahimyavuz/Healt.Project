package pages;

public class deneme
{
    public static void main(String[] args) {


        // buraya gelen  gun ay yil gg.aa.yyyy
        String tarih = "04-08-2022";
               String day = tarih.substring(0,2);
               String month = tarih.substring(3,5);
               String year = tarih.substring(6);

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("day = " + day);

        String formatDateString = day + "-" + month + "-" +year;

    }

    public static String stringDateFormat(String date)
    {


        String year = date.substring(0,4);
        String month = date.substring(5,7);
        String day = date.substring(8);

        String formatDateString = day + "-" + month + "-" +year;

        return formatDateString;

    }
}
