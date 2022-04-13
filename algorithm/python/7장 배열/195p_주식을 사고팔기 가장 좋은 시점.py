# 내 풀이
# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
# 내 풀이가 아아주 조금 더 빨랐음(ㅋㅋㅋ)
def maxProfit(self, prices: List[int]) -> int:
    # 뒤에 숫자보다 앞에 숫자가 작으면 버려
    # 크면 빼서 갖고 있어
    min_price = prices[0]
    max_price = 0

    for i in range(1, len(prices)):
        if min_price > prices[i]:
            min_price = prices[i]
        else:
            max_price = max(max_price, prices[i] - min_price)

    return max_price


def bookSoulution(self, prices: List[int]) -> int:
    profit = 0
    min_price = sys.maxsize
    for price in prices:
        min_price = min(min_price, price)
        profit = max(profit, price-min_price)
    return profit
