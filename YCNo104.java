import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YCNo104{
    public static void main(String[] args){
        int[] node = {1, 2, 3};//node = {parent, leftChild, rightChild}
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            br.readLine().chars().forEach(ch -> {
                if((char)ch == 'L'){
                    node[0] = node[1];
                }
                if((char)ch == 'R'){
                    node[0] = node[2];
                }
                node[1] = node[0]*2;
                node[2] = node[1]+1;
            });
            System.out.println(node[0]);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}