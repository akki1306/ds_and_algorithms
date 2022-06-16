package string;

public class DigitalClock {
    public static void main(String[] args) {
        System.out.println(convert_to_digital_time(1439));
    }

    private static String convert_to_digital_time(int minutes){

        int hours = 0;
        while(minutes >= 60){
            hours += minutes / 60;
            minutes = minutes % 60;
        }

        return String.format("%02d:%02d", hours, minutes);
    }
}