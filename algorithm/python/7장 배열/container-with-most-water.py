# https://leetcode.com/problems/container-with-most-water/submissions/
def maxArea(self, height: List[int]) -> int:
        left = answer = 0
        right = len(height) - 1
        
        for num in height:
            answer = max(answer, (right-left) * min(height[left], height[right]) )
            
            if height[left] < height[right]:
                left += 1
            else: right -= 1
                
        return answer
