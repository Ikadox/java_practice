package gui_test;
/**
 * Swing を使用してGUIプログラムを作成する。
 * このクラスはプログラム自体を起動させるクラス。
 */
public class Bootup{
    public static void main(String[] args){
        // Frameを呼び出す。引数にはウィンドウに表示されるタイトルを指定
        Frame frame = new Frame("calculator");
        frame.setVisible(true);
    }
}