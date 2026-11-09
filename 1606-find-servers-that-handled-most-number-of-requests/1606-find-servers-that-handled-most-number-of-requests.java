class Solution {

    class Request {
        int arrival, load;

        Request(int arrival, int load) {
            this.arrival = arrival;
            this.load = load;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int n = arrival.length;

        Map<Integer, Integer> freq = new HashMap<>();

        TreeSet<Integer> available = new TreeSet<>();

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0],b[0]));

        for (int i = 0; i < k; i++) {
            available.add(i);
            freq.put(i, 0);
        }

        for (int i = 0; i < n; i++) {

            int start = arrival[i];
            int end = start + load[i];

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                int[] finished = busy.poll();
                available.add((int) finished[1]);
            }

            if (available.isEmpty()) continue;

            int preferred = i % k;

            Integer server = available.ceiling(preferred);

            if (server == null) server = available.first();

            available.remove(server);

            busy.offer(new int[]{end, server});
            freq.put(server, freq.get(server) + 1);
        }

        int maxFreq = 0;

        for (int count : freq.values()) maxFreq = Math.max(maxFreq, count);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (freq.get(i) == maxFreq) {
                result.add(i);
            }
        }
        return result;
    }
}