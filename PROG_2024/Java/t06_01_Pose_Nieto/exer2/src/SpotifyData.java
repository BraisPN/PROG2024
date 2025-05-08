public record SpotifyData(String date, String position, String song, String artist, String duration_ms) {

    public String date() {
        return date;
    }

    public String position() {
        return position;
    }

    public String song() {
        return song;
    }

    public String artist() {
        return artist;
    }

    public String duration_ms() {
        return duration_ms;
    }
    
}
