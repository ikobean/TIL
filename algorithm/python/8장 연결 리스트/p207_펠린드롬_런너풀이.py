def isPalindrome(self, head: ListNode) -> bool:
    # reverse 연결 리스트
    rev = None
    slow = fast = head

    # ListNode 가 true라는 게 무슨 말일까? 인자가 있다는 건가?

    # 러너를 이용해 역순 연결 리스트 구성
    while fast and fast.next:
        # 두개씩 이동
        fast = fast.next.next
        rev, rev.next, slow = slow, rev, slow.next

    if fast:
        slow = slow.next

    # 펠린드롬 여부 확인
    while rev and rev.val == slow.val:
        slow, rev = slow.next, rev.next
    return not rev


'''
1. 빠른 런너가 끝에 다다를 떄 느린 런너는 정확히 중간 지점에 도달.
2. 느린 런너는 중간까지 이동하며 역순으로 연결 리스트 rev를 만든다
3. 중간에 도달한 느린 런너가 나머지 경로를 이동할 때 역순으로 만든 연결 리스트의 값들과 일치하는지 확인
'''
