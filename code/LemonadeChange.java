public class LemonadeChange {

    static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int fiveChange = 0;
            int tenChange = 0;
            for(int bill : bills){
                switch(bill){
                    case 5:
                        fiveChange++;
                        break;
                    case 10:
                        if(fiveChange == 0)
                            return false;
                        fiveChange--;
                        tenChange++;
                        break;
                    case 20:
                        if(fiveChange!=0 && tenChange != 0) {
                            fiveChange--;
                            tenChange--;
                        }else if(fiveChange > 2){
                            fiveChange = fiveChange -3;
                        }else{
                            return false;
                        }
                        break;
                }
            }
            return true;
        }
    }
}
