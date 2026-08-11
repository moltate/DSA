class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        
        prev1 = 2
        prev2 = 1

        for i in range(3,n+1,1):
            current = prev2 + prev1
            prev2 = prev1
            prev1 = current
        
        return prev1