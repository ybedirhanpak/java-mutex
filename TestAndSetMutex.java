public class TestAndSetMutex implements Lock{
    private final TestAndSet testAndSet = new TestAndSet(0);
    private final boolean[] stop = new boolean[2];
    private final boolean[] want = new boolean[2];

    @Override
    public void requestCS(int i) {
        want[i] = true;
        while(testAndSet.execute(1) == 1 || stop[i]) {
        }
        want[i] = false;
    }

    @Override
    public void releaseCS(int i) {
        stop[i] = want[1-i];
        testAndSet.execute(0);
    }
}
