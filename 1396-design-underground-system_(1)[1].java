import java.util.*;

class UndergroundSystem {

    HashMap<Integer, String> station = new HashMap<>();
    HashMap<Integer, Integer> time = new HashMap<>();

    HashMap<String, Integer> totalTime = new HashMap<>();
    HashMap<String, Integer> count = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        station.put(id, stationName);
        time.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {

        String start = station.get(id);
        int startTime = time.get(id);

        String route = start + "->" + stationName;

        int travelTime = t - startTime;

        totalTime.put(route,
                totalTime.getOrDefault(route, 0) + travelTime);

        count.put(route,
                count.getOrDefault(route, 0) + 1);

        station.remove(id);
        time.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        return (double) totalTime.get(route) / count.get(route);
    }
}