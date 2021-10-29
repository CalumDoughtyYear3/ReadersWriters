public class Database {

    private int readers;

    public Database(){
        this.readers = 0;
    }

    public void read(int number){
        synchronized (this){
            readers++;
            System.out.println("Reader " + number + " starts reading.");
        }

        final int DELAY = 5000;
        try{
            Thread.sleep((int)(Math.random() * DELAY));
        }catch(InterruptedException e){
            //e.printStackTrace();
        }

        synchronized (this){
            System.out.println("Reader " + number + " stops reading.");
            readers--;
            if(readers == 0){
                this.notifyAll(); //lets all the thread know that there are no readers anymore (if any are waiting on the lock being freed then they can)
            }
        }
    }

    public synchronized void write(int number){ //must be synchronized, multiple writers could have been writing until I added "Synchronized"
        while(readers != 0){
            try{
                this.wait();
            }catch(InterruptedException e){

            }
        }

        System.out.println("Writer " + number + " starts writing.");

        final int DELAY = 5000;
        try{
            Thread.sleep((int)(Math.random() * DELAY));
        }catch(InterruptedException e){
            //e.printStackTrace();
        }

        System.out.println("Writer " + number + " stops writing.");
        this.notifyAll();
    }

}
