public class Reader extends Thread{

    private static int numberOfReaders = 0;
    private int number;
    private Database database;

    public Reader(Database database){
        this.database = database;
        this.number = numberOfReaders++;
    }

    public void run(){
        while(true){
            final int DELAY = 5000;
            try{
                Thread.sleep((int)Math.random() * DELAY);
            }catch(InterruptedException e){

            }
            this.database.read(number);
        }
    }

}
