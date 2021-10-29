public class Driver {

    public static void main(String[] args) {
        final int READERS = 3;
        final int WRITERS = 2;
        Database database = new Database();

        for(int i = 0; i < READERS; i++){
            new Reader(database).start();
        }

        for(int i = 0; i < WRITERS; i++){
            new Reader(database).start();
        }

    }
}
