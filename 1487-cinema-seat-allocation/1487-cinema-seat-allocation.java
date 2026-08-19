class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int res = 2*n, j=0;
        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);

        while(j<reservedSeats.length){
           int row = reservedSeats[j][0];
           boolean isle1 = false, isle2left = false, isle2right = false, isle3 = false;
           while(j<reservedSeats.length && reservedSeats[j][0]==row){
            int seat = reservedSeats[j][1];
            if(seat==2 || seat==3){
                isle1=true;
            }else if(seat==4 || seat==5){
                isle2left=true;
            }else if(seat==6 || seat==7){
                isle2right=true;
            }else if(seat==8 || seat==9){
                isle3=true;
            }
                j++;
           }
            if (!isle1 && !isle2left && !isle2right && !isle3) {
                continue;
            }

            if (!isle1 && !isle2left && !isle2right && !isle3) {
                res -= 0;
            }

            boolean left = !isle1 && !isle2left;

            boolean right = !isle2right && !isle3;

            if (left && right) {
                res -= 0;
            } 
            else if (left || right || (!isle2left && !isle2right)) {
                res -= 1;      
            } 
            else {
                res -= 2;     
            }
        }
        return res;
    }
}