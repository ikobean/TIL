from matplotlib import collections


def isPalindrome(self, head: Optional[ListNode]) -> bool:
    # print(head)
    # ListNode{val: 1, next: ListNode{val: 2, next: ListNode{val: 2, next: ListNode{val: 1, next: None}}}}

    q: Deque = collections.deque()

    # linked list가 없는 경우
    if not head:
        return True

    node = head
    while node is not None:
        q.append(node.val)
        node = node.next

    # 펠린드롬 판별
    while len(q) > 1:
        if q.popleft() != q.pop():
            return False
    return True
