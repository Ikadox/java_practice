import java.util.Scanner;

public class YCNo908 {
    public static void main(final String[] args) {
        final String inputString = new Scanner(System.in).nextLine();

        int cycleNumber = 1;
        checker:for(; cycleNumber <= inputString.length(); cycleNumber++){
            if(0 == (cycleNumber)%2){
                if(!inputString.substring(cycleNumber-1, cycleNumber).matches("\\h")){
                    System.out.println("No");
                    break checker;
                }
            }else {
                if(!inputString.substring(cycleNumber-1, cycleNumber).matches("[a-z]")){
                    System.out.println("No");
                    break checker;
                }
            }
        }
        if(cycleNumber > inputString.length()){
            System.out.println("Yes");
        }
    }
}