class Solution {
    class Server {
        int weight, index;
        long freeAt;

        Server(int weight, int index) {
            this.weight = weight;
            this.index = index;
            this.freeAt = 0;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Server> available = new PriorityQueue<>(
            (a, b) -> a.weight != b.weight
                ? a.weight - b.weight
                : a.index - b.index
        );
        PriorityQueue<Server> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a.freeAt != b.freeAt)
                    return Long.compare(a.freeAt, b.freeAt);

                if (a.weight != b.weight)
                    return a.weight - b.weight;

                return a.index - b.index;
            }
        );
        for (int i = 0; i < servers.length; i++) {
            available.offer(new Server(servers[i], i));
        }
        int[] ans = new int[tasks.length];
        long time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);
            while (!busy.isEmpty() && busy.peek().freeAt <= time) {
                available.offer(busy.poll());
            }
            if (available.isEmpty()) {
                time = busy.peek().freeAt;
                while (!busy.isEmpty() && busy.peek().freeAt <= time) {
                    available.offer(busy.poll());
                }
            }
            Server s = available.poll();
            ans[i] = s.index;
            s.freeAt = time + tasks[i];
            busy.offer(s);
        }
        return ans;
    }
}
