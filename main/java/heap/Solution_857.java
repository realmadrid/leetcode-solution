package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            workers.add(new Worker(quality[i], wage[i]));
        }
        Collections.sort(workers);

        double res = Double.MAX_VALUE;
        int sumQuality = 0;
        // 质量队列，质量高的在堆顶
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (Worker worker : workers) {
            // 性价比高的先进入堆
            if (queue.size() < K) {
                queue.offer(worker.quality);
                sumQuality += worker.quality;
            }
            // 达到K个后，每次入堆的都是性价比最低的，堆内所有人都溢价，满足工资要求
            if (queue.size() == K) {
                res = Math.min(res, worker.wagePerQuality * sumQuality);
                sumQuality -= queue.poll();
            }
        }
        return res;
    }

    class Worker implements Comparable<Worker> {
        int quality;
        int wage;
        double wagePerQuality;

        Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.wagePerQuality = wage / (double) quality;
        }

        @Override
        public int compareTo(Worker o) {
            return Double.compare(this.wagePerQuality, o.wagePerQuality);
        }
    }
}
