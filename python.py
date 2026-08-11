#Find Minimum in Rotated Sorted Array

class Solution:
    def findMin(self, nums: List[int]) -> int:
         n = len(nums)
         l = 0
         r = n - 1
         while l < r:
             m = (l + r)  //  2
             if nums[m] > nums[r]:
                 l = m + 1
             else:
                 r = m
         return nums[l]

#Stone Game IV

class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        dp = [False] * (n + 1)

        for i in range(1,n+1):
            j = 1

            while j * j <= i:
                if not dp[i - j * j]:
                    dp[i] = True
                    break
                j += 1
        
        return dp[n]

//Contains Duplicate II


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        nums_to_i = {}
        n = len(nums)
        for i in range(n):
            if nums[i] in nums_to_i:
                if(abs(nums_to_i[nums[i]] - i)) <= k:
                    return True
            nums_to_i[nums[i]] = i
             
        return False