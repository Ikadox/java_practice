import java.util.HashMap;
import java.util.Scanner;

public class YCNo586{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int hotelCharge = scan.nextInt();
        int transferCharge = scan.nextInt();
        int reservationNumber = scan.nextInt();

        HashMap<Integer, Integer> overlappingRoom = new HashMap<>();
        for(int i=0; i<reservationNumber; i++){
            int roomNumber = scan.nextInt();
            if(overlappingRoom.containsKey(roomNumber)){
                overlappingRoom.put(roomNumber, overlappingRoom.get(roomNumber)+1);
            }else{
                overlappingRoom.put(roomNumber, 0);
            }
        }
        int overlappingNumber = 0;
        for(int n: overlappingRoom.values()){
            overlappingNumber += n;
        }
        int amountOfLoss = (hotelCharge + transferCharge)*overlappingNumber;
        System.out.println(amountOfLoss);
        scan.close();
    }
}