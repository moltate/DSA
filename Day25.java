//Capacity to Ship Packages Within D Days
class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity) {

        int currentWeight = 0;
        int requiredDays = 1;

        for (int w : weights) {

            if (currentWeight + w > capacity) {

                requiredDays++;
                currentWeight = 0;
            }

            currentWeight += w;
        }

        return requiredDays <= days;
    }
}

//Minimum Speed to Arrive on Time

class Solution {

    public int minSpeedOnTime(int[] dist, double hour) {

        int low = 1;
        int high = 10000000;

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(dist, hour, mid)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReach(int[] dist, double hour, int speed) {

        double time = 0;

        for (int i = 0; i < dist.length; i++) {

            double t = (double) dist[i] / speed;

            if (i != dist.length - 1) {

                time += Math.ceil(t);

            } else {

                time += t;
            }
        }

        return time <= hour;
    }
}