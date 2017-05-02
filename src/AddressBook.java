import java.util.*;

/**
 * Created by admin on 29.04.2017.
 */
public class AddressBook {
    private HashMap<String, HashSet> abookHashMap = new HashMap<String, HashSet>();

    public void set(String name, Integer... words) {
        if (this.abookHashMap.containsKey(name)) {
            for (Integer s : words) abookHashMap.get(name).add(s);
        } else {
            HashSet<Integer> phone = new HashSet<Integer>(Arrays.asList(words));
            this.abookHashMap.put(name, phone);
        }
    }

    public HashSet getHash(String a) {
        return abookHashMap.get(a);
    }

    public String getString(String a) {
        String out = "";
        Iterator<Integer> itr = abookHashMap.get(a).iterator();
        while (itr.hasNext()) {
            String i = itr.next().toString();
            out += i + "\n";
        }
        return out;
    }
}
