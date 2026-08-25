class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        nums.sort()
        a = k
        for i in nums:
            if i == a:
                a += k
        return a