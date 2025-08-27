class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] changeHave = new int[3];      // 0: 5$   1:  10$   2:20$

        int i = 0;

        while(i<bills.length){

            if(bills[i]==10){
                if(changeHave[0]>=1){
                    changeHave[0]--;
                }else{
                    return false;
                }
            }

            if(bills[i]==20){
               if(changeHave[0]>=1 && changeHave[1]>=1){
                    changeHave[0]-=1;
                    changeHave[1]-=1;
                }else if(changeHave[0]>=3){
                    changeHave[0]-=3;
                }else{
                    return false;
                }
            }

            if(bills[i]==5) changeHave[0]+=1;
            else if(bills[i]==10) changeHave[1]+=1;
            else if(bills[i]==20) changeHave[2]+=1;

            i++;
        }

        return true;
    }
}