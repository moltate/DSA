class Solution:
    def isRectangleOverlap(self, A: List[int], B: List[int]) -> bool:
        return not (A[2] <= B[0] or A[3] <= B[1] or A[0] >= B[2] or A[1] >= B[3])