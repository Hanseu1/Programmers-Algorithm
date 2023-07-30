package day6;

import java.util.*;

/* [2023-07-29] 코딩테스트 연습 - 코딩 기초 트레이닝 - 수열과 구간 쿼리 2 
 * 정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
 * 각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 k보다 크면서 가장 작은 arr[i]를 찾습니다.
 * 각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
 * 단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.
 * 
 * 입출력 예 #1
 * arr [0, 1, 2, 4, 3]	
 * queries [[0, 4, 2],[0, 3, 2],[0, 2, 2]]
 * result [3, 4, -1]
 * 
 * 첫 번째 쿼리의 범위에는 0, 1, 2, 4, 3이 있으며 이 중 2보다 크면서 가장 작은 값은 3입니다.
 * 두 번째 쿼리의 범위에는 0, 1, 2, 4가 있으며 이 중 2보다 크면서 가장 작은 값은 4입니다. 
 * 세 번째 쿼리의 범위에는 0, 1, 2가 있으며 여기에는 2보다 큰 값이 없습니다.
 * 따라서 [3, 4, -1]을 return 합니다.
 */
public class seqAndQueris2 {

	public static void main(String[] args) {
		
		int[] arr = {0, 1, 2, 4, 3};
		int[][] queries = {{0, 4, 2},{0, 3, 2},{0, 2, 2}};
		
		int[] result = seqAndQueris2(arr, queries);
		System.out.println(Arrays.toString(result));
	}

	private static int[] seqAndQueris2(int[] arr, int[][] queries) {
		
        List<Integer> grp = new ArrayList<>();
        List<Integer> asrLst = new ArrayList<>();
        
        for (int[] query: queries) {
            
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            for (int i = s; i <= e; i++) {
                if (arr[i] > k) 
                    grp.add(arr[i]);
            }
            
            if (!grp.isEmpty())
                asrLst.add(Collections.min(grp));
            else 
                asrLst.add(-1);
            
            grp.clear();
        }
        
        int[] answer = new int[asrLst.size()];
        
        for (int i = 0; i < asrLst.size(); i++) {
            answer[i] = asrLst.get(i);
        }
        
        return answer;
	}

}
