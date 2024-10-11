from itertools import combinations

def can_place(h1, w1, h2, w2, H, W):
    return (h1 + h2 <= H and max(w1, w2) <= W) or (max(h1, h2) <= H and w1 + w2 <= W)

def solve_sticker_problem():
    H, W = map(int, input().split())
    N = int(input())
    stickers = [tuple(map(int, input().split())) for _ in range(N)]

    max_area = 0

    for s1, s2 in combinations(stickers, 2):
        for h1, w1 in [(s1[0], s1[1]), (s1[1], s1[0])]:
            for h2, w2 in [(s2[0], s2[1]), (s2[1], s2[0])]:
                if can_place(h1, w1, h2, w2, H, W):
                    max_area = max(max_area, h1*w1 + h2*w2)

    return max_area

if __name__ == "__main__":
    result = solve_sticker_problem()
    print(result)