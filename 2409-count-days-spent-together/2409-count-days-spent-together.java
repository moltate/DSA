class Solution {
    final int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    public int Day(String date){
        int month = Integer.parseInt(date.substring(0,2));
        int day = Integer.parseInt(date.substring(3,5));
        return days[month - 1] + day;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int start = Math.max(Day(arriveAlice), Day(arriveBob));
        int end = Math.min(Day(leaveAlice), Day(leaveBob));
        return Math.max(0, end - start + 1);
    }
}