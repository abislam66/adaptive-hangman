import java.util.*;

public class wordinfo {
    private List<String> newresult;
    private int count;

    public wordinfo(List<String> newresult, int count) {
        this.newresult = newresult;
        this.count = count;
    }

    public List<String> getnewresult() {
        return newresult;
    }

    public int getcount() {
        return count;
    }
}
