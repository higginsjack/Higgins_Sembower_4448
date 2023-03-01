public interface Subject {
    public void registerObserver(Observer obs);
    public void unregisterObserver(Observer obs);
    public void notifyObserver(Observer obs, String msg);
}
