def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    node, prev = head, None

    while node:
        next, node.next = head.next, prev
        prev, node = node, next

    return prev


'''
node.next 를 이전 prev 리스트로 계속 연결 하면서 끝날 때 까지 반복한다.
node가 None이 될 떄 prev는 뒤집힌 연결 리스트의 첫번째 노드가 된다

'''
