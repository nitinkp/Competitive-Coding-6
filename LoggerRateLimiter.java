import java.util.HashMap;

public class LoggerRateLimiter {
    HashMap<String, Integer> map;

    public LoggerRateLimiter() {
        this.map = new HashMap<>();
    }

    //O(n) S.C, O(1) amortized T.C
    public boolean shouldPrintMessage(int timeStamp, String message) {
        if(map.containsKey(message) && timeStamp < map.get(message) + 10) return false;
        map.put(message, timeStamp);
        return true;
    }

    public static void main(String[] args) {
        LoggerRateLimiter loggerRateLimiter = new LoggerRateLimiter();

        System.out.println(loggerRateLimiter.shouldPrintMessage(1, "foo"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(2, "bar"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(3, "foo"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(8, "bar"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(10, "foo"));
        System.out.println(loggerRateLimiter.shouldPrintMessage(11, "foo"));
    }
}