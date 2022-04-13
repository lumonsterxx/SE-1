import java.util.LinkedList;

public class Abhaengigkeit extends LinkedList<String[]> implements AbhaengigkeitInterface {

    LinkedList<String[]> ab = new LinkedList<>();                       //leere Linked List erstellen

    public Abhaengigkeit(String[][] strings) {                          //Die uebergebenen Abhaengigkeiten in die Linked List einfuegen
        for(int i = 0; i < strings.length; i++) {
            ab.add(strings[i]);
        }
        transitivitaetenRechner();                                      //transitivitaetenRechner aufrufen
    }

    public void transitivitaetenRechner() {                             //Sucht Transitivitaeten und fuegt diese in die Linked List als neue Abhaengigkeiten ein
        int temp = ab.size();                                           //Speichert die momentane groesse der Linked List
        for(int i = 0; i < temp; i++) {                                 //Geht alle Abhaengigkeiten in der Linked List durch
            for(int j = 0; j < temp; j++) {                             //Und vergleicht sie mit allen anderen
                if(ab.get(i)[1].equals(ab.get(j)[0]))                   //Falls es eine Transitivitaet gibt
                    ab.add(new String[]{ab.get(i)[0], ab.get(j)[1]});   //Wird sie als neue Abhaengigkeit in die Linked List getan
            }
        }
    }

    @Override
    public boolean isWellSorted(String[] sequence) {                        //Prueft ob die Sequence unter Beruecksichtigung der Abhaengigkeiten stimmt
        for(int i = 0; i < ab.size(); i++) {                                //Alle Abhaengigkeiten der Linked List durchgehen
            int tempcount = 0;                                              //Counter erstellen um zu gucken welche Stelle man betrachtet
            for(int j = 0; j < 2; j++) {                                    //Die Abhaengigkeit Betrachten, also bei ("A","C"), ob A vor C kommt
                for(;(tempcount < sequence.length) && (!sequence[tempcount].equals(ab.get(i)[j])); tempcount++);
                                                                            //Wenn wir noch nicht am Ende sind und noch nicht den gesuchten Buchstaben gefunden haben
                                                                            //Dann wird der counter um 1 erhoeht
                if(tempcount == sequence.length)                            //Falls der counter am Ende ist, dann haben wir den Buchstaben nicht an der richtigen stelle gefunden
                    return false;
            }
        }
        return true;
    }
}
