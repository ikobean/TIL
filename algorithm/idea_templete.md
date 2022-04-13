```python
 # 펠린드롬 판별
    while len(q) > 1:
        if q.popleft() != q.pop():
            return False
    return True
```
