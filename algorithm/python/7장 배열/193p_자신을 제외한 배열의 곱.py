def productExceptSelf(self, nums: List[int]) -> List[int]:
    # 4 3 2 1
    #

    out = []
    p = 1
    # 왼쪽 곰셈
    # 왜 P=1이냐면 처음 시작하는 자기 자신이랑은 안곱해야하니까!
    # 그래서 먼저 append 하고 p에 곱해줌!
    for i in range(0, len(nums)):
        print(i)
        out.append(p)
        p = p*nums[i]
    p = 1

    # 왼쪽 곰셈 결과에 오른쪽 값을 차례대로 곱셉
    #range(start, stop, gap)
    for i in range(len(nums) - 1, 0 - 1, -1):
        # 4 12 24 24
        #       24*24  24
        out[i] = out[i] * p
        p = p * nums[i]
        return out
