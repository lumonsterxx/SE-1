import java.util.LinkedList;

public class Abhaengigkeit extends LinkedList<String[]> implements AbhaengigkeitInterface {

    LinkedList<String[]> ab = new LinkedList<>();

    public Abhaengigkeit(String[][] strings) {
        for(int i = 0; i < strings.length; i++) {
            ab.add(strings[i]);
        }
        transitivitaetenRechner();
    }

    public void transitivitaetenRechner() {
        int temp = ab.size();
        for(int i = 0; i < temp; i++) {
            for(int j = 0; j < temp; j++) {
                if(ab.get(i)[1].equals(ab.get(j)[0]))
                    ab.add(new String[]{ab.get(i)[0], ab.get(j)[1]});
            }
        }
    }

    @Override
    public boolean isWellSorted(String[] sequence) {
        for(int i = 0; i < ab.size(); i++) {
            int tempcount = 0;
            for(int j = 0; j < 2; j++) {
                for(;tempcount < sequence.length; tempcount++) {
                    if(sequence[tempcount].equals(ab.get(i)[j]))
                        break;
                }
                if(tempcount == sequence.length)
                    return false;
            }
        }
        return true;
    }
}
