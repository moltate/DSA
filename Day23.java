//Sqrt(x)
class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x, root = 0;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(mid <= x/mid){
                root = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return root;
    }
}

//Valid Perfect Square
class Solution {
    public boolean isPerfectSquare(int num) {
        int min = 1, max = 46340;
        while(min<=max){
            int mid = (min+max)/2;
            int product = mid * mid;
             if(product == num){
                return true;
             }else if(product<num){
                min = mid + 1;
             }else{
                max = mid - 1;
             }
        }
          return false;
    }
}

//Sum of Square Numbers
class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0, b =(long)Math.sqrt(c); 
        while(a<=b){
            long t = a * a + b * b;
            if(t == c){
                return true;
            }else if(t<c){
                a++;
            }else{
                b--;
            }
        }
        return false;
    }
}
