class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean aliceTurn = true;
        while(true){
            if(n < remove) return !aliceTurn;
            n -= remove;
            remove--;
            aliceTurn = !aliceTurn;
        }
    }
}