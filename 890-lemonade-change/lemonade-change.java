class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] changeHave = new int[2];      // 0: 5$   1:  10$

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
               if(changeHave[0]>=1 && changeHave[1]>=1){    //Note: keep $10,$5 giving first
                    changeHave[0]-=1;
                    changeHave[1]-=1;
                }else if(changeHave[0]>=3){                 //Note: then keep 3x$5 giving
                                                            //  as, $5 is more flexible (to do any payment) than $10 and $20.   So, priority($5>$10>$20)
                    changeHave[0]-=3;
                }else{
                    return false;
                }
            }

            if(bills[i]==5) changeHave[0]+=1;
            else if(bills[i]==10) changeHave[1]+=1;

            i++;
        }

        return true;
    }
}