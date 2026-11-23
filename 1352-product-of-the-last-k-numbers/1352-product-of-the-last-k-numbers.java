class ProductOfNumbers {
    private List<Integer> nums;
    private int n;
    public ProductOfNumbers() {
        nums = new ArrayList<>();
        nums.add(1);
        n = 0;
    }
    public void add(int num) {
        if (num == 0) {
            nums.clear();
            nums.add(1);
            n = 0;
            return;
        }
        nums.add(nums.get(n) * num);
        n++;
    }
    public int getProduct(int k) {
        if (k > n) {
            return 0;
        }

        return nums.get(n) / nums.get(n - k);
    }
}