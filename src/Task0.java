public class Task0 {
    public static int checkLength(int[] arr, int minLength) {
        if (arr.length < minLength) {
            return -1;
        }
        return arr.length;
    }
}