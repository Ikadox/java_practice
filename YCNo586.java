import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class YCNo586{
    public static void main(String[] args){
        try{
            Scanner scan = new Scanner(System.in);

            int hotelCharge = 0;
            do{
                hotelCharge = scan.nextInt();
            }while(!isChargeRange(hotelCharge));

            int transferCharge = 0;
            do{
                transferCharge = scan.nextInt();
            }while(!isChargeRange(transferCharge));
            
            int reservationNumber = 0;
            do{
                reservationNumber = scan.nextInt();
            }while(!isReservationsRange(reservationNumber));

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
        }catch(InputMismatchException e){
            System.out.println("全て整数で入力してください");
        }
    }
    /**
     * 料金が指定範囲内か判定する
     * @param charge
     * @return
     */
    public static boolean isChargeRange(int charge){
        if(charge >= 1 && charge <= 100000){
            return true;
        }
        System.out.println("料金が指定範囲外です。再入力してください");
        return false;
    }
    /**
     * 予約件数の指定範囲内か判定する
     * @param reservationNumber
     * @return
     */
    public static boolean isReservationsRange(int reservationNumber){
        if(reservationNumber >= 1 && reservationNumber <= 100){
            return true;
        }
        System.out.println("予約件数が指定範囲外です。再入力してください");
        return false;
    }
}