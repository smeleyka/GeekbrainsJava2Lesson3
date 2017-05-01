import java.util.*;

/**
 * Created by admin on 29.04.2017.
 */
public class AddressBook {
    private HashMap<String, HashSet> abookHash = new HashMap<String, HashSet>();


    public void set(String name, String... words) {
        HashSet<String> phone = new HashSet<String>();
        for (String s:words) phone.add(s);
        //HashSet<String> phone = new HashSet< String>(Arrays.asList(words));
        //this.abookHash =  new HashMap<String,HashSet>();
        this.abookHash.put(name, phone);
    }

    public HashSet get(String a) {
        return abookHash.get(a);
    }

    public String getString(String a) {
        String out = "";
        Iterator<String> itr = abookHash.get(a).iterator();
        while (itr.hasNext()) out += itr.next() + "\n";
        return out;
    }

}
