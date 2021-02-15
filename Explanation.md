## How testAndSet Mutex algorithm works
Stop flags ensures that when a thread leaves the critical section, it must wait the other thread.

## How swap algorithm works
Block flags ensures that in order to pass the while block it needs to be false and there's only one block flag is false at any time.