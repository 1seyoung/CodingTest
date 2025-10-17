import java.util.Scanner;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String date = sc.next();
        String day = sc.next();
        String weather = sc.next();

        weatherInfo wi = new weatherInfo(date, day, weather);


        for (int i = 0; i < n-1; i++) {
            String date_ = sc.next();
            String day_ = sc.next();
            String weather_ = sc.next();
            // Please write your code here.


            wi.updateWeatherRecentlyRain(date_, day_, weather_);
        }

        wi.printInfo();
    }
}

class weatherInfo {
    String date;
    String day;
    String weather;
    boolean update = false;

    public weatherInfo(String date,String day, String weather){
        this.date = date;
        this.day = day;
        this.weather = weather;
    }

    public void updateWeatherRecentlyRain(String date, String day, String weather){
        if(weather.equals("Rain")) {
            if(this.update== false){
                this.update = true;

                this.date = date;
                this.day = day;
                this.weather = weather;
            } else {
                LocalDate dateOrigin = LocalDate.parse(this.date);
                LocalDate dateNew = LocalDate.parse(date);

                if(dateOrigin.isAfter(dateNew)){
                    this.date = date;
                    this.day = day;
                    this.weather = weather;
                }
            }

        }
    }

    public void printInfo(){
        System.out.print(this.date +" "+this.day+" "+this.weather);
    }
}