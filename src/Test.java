import java.util.*;

public class Test {
    public int adjust(int a) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int count = 0;
        while (a != 0) {
            map.put(a % 10, count);
            priorityQueue.offer(a % 10);
            list.add(a % 10);
            count++;
            a = a / 10;
        }
        int high = map.size() - 1;
        while (map.get(priorityQueue.peek()) == high) {
            priorityQueue.poll();
            high--;
        }
        if (high != 0) {
            int temp = list.get(high);
            int highNum = priorityQueue.poll();
            list.set(high, highNum);
            list.set(map.get(highNum), temp);
            int result = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                result = result * 10 + list.get(i);
            }
            return result;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(new Test().adjust(sc.nextInt()));
        }
    }
}
