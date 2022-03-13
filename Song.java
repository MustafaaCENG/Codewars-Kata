package KatasSolution;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Song {
    private final String title, artist;
    private final Set<String> gelenList = new TreeSet<>(String::compareToIgnoreCase);

    Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    // MustafaCENG
    String getTitle() {
        return title;
    }

    String getArtist() {
        return artist;
    }

    int howMany(List<String> dinleyici) {
        return (int) dinleyici.stream().filter(gelenList::add).count();
    }
}
