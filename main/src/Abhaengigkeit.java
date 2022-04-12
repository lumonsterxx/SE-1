public class Abhaengigkeit implements AbhaengigkeitInterface{

    String[][] ab;

    public Abhaengigkeit(String[][] strings) {
        ab = strings;
    }

    @Override
    public boolean isWellSorted(String[] sequence) {
        for(int i = 0; i < ab.length; i++) {                //Doppeltes array durchgehen
            int count = 0;                                  //counter um die sequence durch zu gehen und die buchstaben in der richtigen Abhängigkeit zu suchen
            for(int j = 0; j < ab[i].length; j++) {         //Inneres Array vom doppelten array durchgehe
                for(;count < sequence.length; count++) {    //Sequence durchgehen
                    if(sequence[count].equals(ab[i][j]))    //falls der richtige buchstabe gefunden wurde, wird von der stelle de nächste gesucht
                        break;
                }
                if(count == sequence.length)                //falls dieser jedoch nicht gefunden wurde, da er vor der anderen war, wird false ausgegeben, da es dann die falsche reihenfolge war
                    return false;
            }
        }
        return true;
    }
}
