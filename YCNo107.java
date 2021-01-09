import java.util.Scanner;

public class YCNo107 {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){
            int hp = 100, maxHp = 100;
            //limitation: 1 <= n <= 16
            int n = scan.nextInt();
            int[] badMonsterArr = new int[n];
            int[] goodMonsterArr = new int[n];
            for(int i = 0, j = 0; i < n; i++){
                j = scan.nextInt();
                if(j > 0){
                    goodMonsterArr[i] = j;
                }else {
                    badMonsterArr[i] = j;
                }
            }

            while(n > 0){
                if(hasBattlePhase(badMonsterArr, hp)){
                    int badMonsterIndex = getBadMonster(badMonsterArr, hp);
                    hp += badMonsterArr[badMonsterIndex];
                    //最大hpアップ
                    maxHp += 100;
                    //倒したbadMonsterの値を0に変更
                    badMonsterArr[badMonsterIndex] = 0;
                }else if(hasCuredPhase(goodMonsterArr, badMonsterArr)){
                    int goodMonsterIndex = getGoodMonster(goodMonsterArr, badMonsterArr);
                    hp += goodMonsterArr[goodMonsterIndex];
                    if( hp > maxHp){
                        hp = maxHp;
                    }
                    //回復に使ったgoodMonsterの値を0に変更
                    goodMonsterArr[goodMonsterIndex] = 0;
                }
                n--;
            }
            //badMonsterが残存していたらhpを0にする
            if(hasBadMonster(badMonsterArr))
                hp = 0;
            System.out.println(hp);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 倒せる悪monsterがいるか判定
     * @param badMonsterArr
     * @param hp
     * @return hpよりもattackが低い悪monsterがいる場合trueを返し、それ以外の場合はfalseを返す
     */
    private static boolean hasBattlePhase(int[] badMonsterArr, int hp){
        for(int v:badMonsterArr){
            if(v < 0 && v * -1 < hp){
                return true;
            }
        }
        return false;
    }
    /**
     * 倒す悪monsterを選択する
     * 悪monsterのattackがhp未満でかつ最も高いものを選択する
     * @param badMonsterArr
     * @param hp
     * @return 選択された悪monsterのインデックス
     */
    private static int getBadMonster(int[] badMonsterArr, int hp){
        int maxAttack = 0, getBadMonsterIndex = 0;

        for(int i=0;i<badMonsterArr.length; i++){
            if(badMonsterArr[i] * -1 < hp){
                if(badMonsterArr[i] < maxAttack){
                    maxAttack = badMonsterArr[i];
                    getBadMonsterIndex = i;
                }
            }
        }
        return getBadMonsterIndex;
    }
    /**
     * 回復に適した善monsterがいるか判定
     * @param gootMonsterArr
     * @param badMonsterArr
     * @return 悪monsterが存在しないか1番attackが低い悪monsterよりcureが高い善monsterがいる場合はtrueを返し、それ以外の場合はfalseを返す
     */
    private static boolean hasCuredPhase(int[] gootMonsterArr, int[] badMonsterArr){
        //limitation : -1600 <= attack < 0
        int minAttack = -1601;

        for(int v:badMonsterArr){
            if(v < 0 && v > minAttack)
                minAttack = v;
        }
        //If minAttack is 1601, There are not badMonster. 
        if(minAttack == -1601)
            return true;
        for(int v:gootMonsterArr){
            if(v > minAttack * -1)
                return true;
        }
        return false;
    }
    /**
     * 回復に使う善monsterを選択
     * 悪monsterが存在しない場合は添字の低いほうから選択する
     * 悪monsterが存在する場合は1番attackが低い悪monsterよりcureが高い善monsterの中で値が一番低いものを選択する
     * @param goodMonsterArr
     * @param badMonsterArr
     * @return 選択された善monsterのインデックス
     */
    private static int getGoodMonster(int[] goodMonsterArr, int[] badMonsterArr){
        //limitation : -1600 <= attack < 0
        int minAttack = -1601;
        for(int v:badMonsterArr){
            if(v < 0 && v > minAttack)
                minAttack = v;
        }
        //If minAttack is 1601, There are not badMonster. 
        if(minAttack == -1601){
            for(int i = 0; i < goodMonsterArr.length; i++){
                if(goodMonsterArr[i] > 0)
                    return i;
            }
        }

        //limitation : 0 < cure <= 1600
        int minCure = 1601;
        int goodMonsterIndex = 0;
        for(int i = 0; i < goodMonsterArr.length; i++){
            if(minAttack * -1 <= goodMonsterArr[i]){
                if(minCure > goodMonsterArr[i]){
                    minCure = goodMonsterArr[i];
                    goodMonsterIndex = i;
                }
            }
        }
        return goodMonsterIndex;
    }
    /**
     * 悪monsterが存在しているか判定
     * @param badMonsterArr
     * @return 存在している場合trueを返し、それ以外はfalseを返す
     */
    private static boolean hasBadMonster(int[] badMonsterArr) {
        for(int v:badMonsterArr){
            if(v < 0)
                return true;
        }
        return false;
    }
}