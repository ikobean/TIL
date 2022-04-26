def mergeTwoLists(self, list1: ListNode, list2: ListNode) -> ListNode:
    if (not list1) or (list2 and list1.val > list2.val):
        list1, list2 = list2, list1

    if list1:
        list1.next = self.mergeTwoLists(list1.next, list2)
    return list1


'''
연산자 우선 순위
>
not list1
and
or
'''

print(type(ListNode))
# ListNode 가 false == 포인터가 null을 만났다 ==RMxdl skTek
'''
list1:  ListNode{val: 1, next: ListNode{val: 2, next: ListNode{val: 4, next: None}}}
list2:  ListNode{val: 1, next: ListNode{val: 3, next: ListNode{val: 4, next: None}}}

이건뭐여 ListNode{val: 1, next: ListNode{val: 2, next: ListNode{val: 4, next: None}}}

list1:  ListNode{val: 2, next: ListNode{val: 4, next: None}}
list2:  ListNode{val: 1, next: ListNode{val: 3, next: ListNode{val: 4, next: None}}}

이건뭐여 ListNode{val: 1, next: ListNode{val: 3, next: ListNode{val: 4, next: None}}}

list1:  ListNode{val: 3, next: ListNode{val: 4, next: None}}
list2:  ListNode{val: 2, next: ListNode{val: 4, next: None}}

이건뭐여 ListNode{val: 2, next: ListNode{val: 4, next: None}}

list1:  ListNode{val: 4, next: None}
list2:  ListNode{val: 3, next: ListNode{val: 4, next: None}}
이건뭐여 ListNode{val: 3, next: ListNode{val: 4, next: None}}
list1:  ListNode{val: 4, next: None}
list2:  ListNode{val: 4, next: None}
이건뭐여 ListNode{val: 4, next: None}
list1:  None
list2:  ListNode{val: 4, next: None}

이건뭐여 ListNode{val: 4, next: None}
list1:  None
list2:  None

'''
