import java.util.ArrayList;

public class Schedule {
    private ArrayList<Pair<Integer, String>> myschedule;
    private int classcheck;
    private String sendString;
    private Pair<Integer,String> temp;

    public Schedule() {
        myschedule = new ArrayList<Pair<Integer, String>>();
    }

    public void addClass(int period, String classs) {
        Pair<Integer, String> pair = new Pair<Integer, String>(period, classs);
        classcheck = 0;
        for (Pair<Integer, String> each : myschedule) {
            if (each.getKey() != pair.getKey()) {
                classcheck++;
            }
        }
        if (classcheck == myschedule.size()) {
            myschedule.add(pair);
        }
        for (int i = 0; i < myschedule.size()-1; i++) {
            for (int j = 0; j < myschedule.size() - i - 1; j++) {
                if (myschedule.get(j).getKey() > myschedule.get(j + 1).getKey()) {
                    temp = myschedule.get(j);
                    myschedule.set(j, myschedule.get(j+1));
                    myschedule.set(j + 1, temp);
                }
            }
        }
    }

    public void deleteClass(int period){
    	for(int i = 0; i < myschedule.size();i++){
    		if(myschedule.get(i).getKey()==(period)){
    			myschedule.remove(i);
    		}
		}
    }
    public void deleteClass(String classs){
    	for(int i = 0; i < myschedule.size();i++){
    		if(myschedule.get(i).getValue().equals(classs)){
    			myschedule.remove(i);
    		}
		}
    }
    public String toString() {
        sendString = "";
        for (int i = 0; i < myschedule.size(); i++) {
            sendString += myschedule.get(i).getKey() + " : " + myschedule.get(i).getValue() + "\n";
        }
        return sendString;
    }
}