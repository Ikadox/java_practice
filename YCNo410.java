import java.util.Scanner;

public class YCNo410 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int px = Integer.parseInt(scan.next());
            int py = Integer.parseInt(scan.next());
            int qx = Integer.parseInt(scan.next());
            int qy = Integer.parseInt(scan.next());

            // ブロックの数を総計して2で割ると最短経路になる。時間にもなる（今回1辺が1秒のため）
            double length = ((double)Math.abs(px-qx) + (double)Math.abs(py-qy))/2;

            // Warshall–Floyd法を無理やりマス目経路に当てはめてみる。
            // 13579+1, 63578+1 の場合、 二次配列の要素数が、7.45e17のため配列の要素の許容最大値をオーバーする.
            /*
            int totalVertexNumber = calcTotalVertexNumber(Math.abs(px-qx), Math.abs(py-qy));
            int vertexPerXSide = calcVertexPerXSide(Math.abs(px-qx));
            int[][] matrixGraph = new int[totalVertexNumber][totalVertexNumber];
            matrixGraph = createGraphAdjMatrix(totalVertexNumber, vertexPerXSide, matrixGraph);
            for(int i = 0; i < totalVertexNumber; i++){
                for(int j = 0; j < totalVertexNumber; j++){
                    for(int k = 0; k < totalVertexNumber; k++){
                        matrixGraph[j][k] = Math.min(matrixGraph[j][k], matrixGraph[j][i]+matrixGraph[i][k]);
                    }
                }
            }
            for(int i = 0; i < totalVertexNumber; i++){
                for(int j = 0; j < totalVertexNumber; j++){
                    if(i != j && matrixGraph[i][j] != Integer.MAX_VALUE)
                        System.out.println(i+"から"+j+"へのコスト： "+matrixGraph[i][j]);
                }
            }
            double length
             =  (Math.min(
                    (double)matrixGraph[0][totalVertexNumber-1],(double)matrixGraph[totalVertexNumber-1][0])
                )/2;
            */
            if(length==(int)length)
                System.out.println(String.format("%d", (int)length));
            else
                System.out.println(String.format("%s", length));
        }catch(NumberFormatException e){
            System.out.println(e.toString());
        }
    }
    /**
     * 全頂点数を求める。
     * @param x |px-qx|
     * @param y |py-qy|
     * @return
     */
    private static int calcTotalVertexNumber(int x, int y){
        return (x+1)*(y+1);
    }
    /**
     * x軸に平行な1辺あたりの頂点数を求める。
     * @param x |px-qx|
     * @return
     */
    private static int calcVertexPerXSide(int x){
        return x+1;
    }
    /**
     * ある頂点から隣接する頂点への移動コストを隣接行列で作成する。
     * @param totalVertexNumber
     * @param vertexPerXSide
     * @param matrixGraph
     * @return
     */
    private static int[][] createGraphAdjMatrix(int totalVertexNumber, int vertexPerXSide, int[][] matrixGraph){
        for(int i = 0; i < totalVertexNumber; i++){
            for(int j = 0; j < totalVertexNumber; j++){
                int cost = 99999;
                if(j == i)
                    cost = 0;
                if(j == i+1 && 0 != (i+1)%vertexPerXSide ){
                    cost = 1;
                }
                if(j == i-1 && 0 != i%vertexPerXSide ){
                    cost = 1;
                }
                if(j == i+vertexPerXSide)
                    cost = 1;
                if(j == i-vertexPerXSide)
                    cost = 1;
                matrixGraph[i][j] = cost;
            }
        }
        return matrixGraph;
    }
}