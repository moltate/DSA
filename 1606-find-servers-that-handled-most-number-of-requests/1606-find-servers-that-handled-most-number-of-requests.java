class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for(int i = 0; i < k; i++) available.add(i);

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0],b[0]));

        int[] count = new int[k];

        for(int i = 0; i < arrival.length; i++){
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] finished = busy.poll();
                available.add(finished[1]);
            }
            int preferred = i % k;
            Integer server = available.ceiling(preferred);
            if (server == null) server = available.isEmpty() ? null : available.first();
            if(server == null) continue;
            available.remove(server);
            count[server]++;
            busy.offer(new int[]{arrival[i] + load[i], server});
        }
        int maxRequest = 0;
        for(int c : count) maxRequest = Math.max(maxRequest, c);

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
           if(count[i] == maxRequest) result.add(i);
        }
        return result;
    }
}