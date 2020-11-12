public class TestAndSet {
    private int value = 0;

    public TestAndSet(int defaultValue) {
        this.value = defaultValue;
    }

    public synchronized int execute(int newValue) {
        int oldValue = value;
        value = newValue;
        return oldValue;
    }
}
