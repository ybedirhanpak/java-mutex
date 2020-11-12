public class SwapMutex implements Lock{
    boolean[] key = {false};
    boolean[][] block = {{true}, {true}};

    @Override
    public void requestCS(int i) {
        Swap.execute(key, block[i]);
        while(block[i][0]) {
            Swap.execute(key, block[i]);
        }
    }

    @Override
    public void releaseCS(int i) {
        Swap.execute(key, block[i]);
    }
}
