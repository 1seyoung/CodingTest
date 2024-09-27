def solution(ineq, eq, n, m):
    # ineq = < or >
    # eq = = or !
    # n,m이 Ineq 와 eq 조건에 맞으면 1
    
    if ineq == ">" and eq == "=":
        return 1 if n >=m else 0
    elif ineq == "<" and eq == "=":
        return 1 if n <=m else 0
    elif ineq == ">" and eq == "!":
        return 1 if n >m else 0
    elif ineq == "<" and eq == "!":
        return 1 if n <m else 0
    