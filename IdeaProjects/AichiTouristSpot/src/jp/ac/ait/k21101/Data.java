package jp.ac.ait.k21101;

public class Data {

    // 緯度
    private double latitude;
    // 経度
    private double longitude;
    // 愛工大からの距離
    private double distance;
    // データ名称
    private String name;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 緯度経度をパースして、フィールドの緯度経度に設定する
     * @param point
     */
    public void parseLatLongAndSet(String point) {
        String[] data = point.replace("\"", "").split(" ");
        this.latitude = Double.parseDouble(data[1].replace(")", ""));
        this.longitude = Double.parseDouble(data[0].replace("POINT(", ""));
    }

    public void calcDistance() {
        double a = 35.1834122;
        double b = 137.1130419;
        this.distance = Math.sqrt(Math.pow((this.latitude - a), 2.0) + Math.pow((this.longitude - b), 2.0));
    }
}
