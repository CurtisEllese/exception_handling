package third_lesson;

import java.io.IOException;

public class Task6Counter implements AutoCloseable{
    private int counter = 0;

    public void add() throws IOException {
        checkClose();
        counter++;
    }

    public int getCounter() throws IOException {
        checkClose();
        return counter;
    }

    private void checkClose() throws IOException{
        if (counter == -1) {
            throw new IOException("Экземпляр закрыт");
        }
    }

    @Override
    public void close() {
        System.out.println("Метод close");
        counter = -1;
    }
}
