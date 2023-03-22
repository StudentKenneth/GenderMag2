List<Song<String>> foundSongs = Song.searchSongsByYearAndName(songsList, "2012", "Radioactive");
        System.out.println("\nFound songs (by year and name):");
        for (Song<String> song : foundSongs) {
            System.out.println(song);
        }

        // Use comparators to sort songs
        Arrays.sort(songsArray, new SongNameComparator());
        System.out.println("\nSorted by name:");
        for (Song<String> song : songsArray) {
            System.out.println(song);
        }

        Collections.sort(songsList, new SongYearComparator());
        System.out.println("\nSorted by year:");
        for (Song<String> song : songsList) {
            System.out.println(song);import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


class Song<T> {
    private T songData1;
    private T songData2;
    private T songData3;
    private T songData4;

    public Song(T songData1, T songData2, T songData3, T songData4) {
        this.songData1 = songData1;
        this.songData2 = songData2;
        this.songData3 = songData3;
        this.songData4 = songData4;
    }

    // Getters, setters, constructors and toString
public T getSongData1() {
        return songData1;
    }

    public void setSongData1(T songData1) {
        this.songData1 = songData1;
    }

    public T getSongData2() {
        return songData2;
    }

    public void setSongData2(T songData2) {
        this.songData2 = songData2;
    }

    public T getSongData3() {
        return songData3;
    }

    public void setSongData3(T songData3) {
        this.songData3 = songData3;
    }

    public T getSongData4() {
        return songData4;
    }

    public void setSongData4(T songData4) {
        this.songData4 = songData4;
    }

    @Override
    public String toString() {
        return songData1 + ", " + songData2 + ", " + songData3 + ", " + songData4;
    }

    public static <T> void displayAllSongs(LinkedList<Song<T>> songs) {
        for (Song<T> song : songs) {
            System.out.println(song.getSongData1() + ", " + song.getSongData2() + ", " + song.getSongData3());
        }
    }

    public static Song<String>[] readSongsArray(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        Song<String>[] songs = new Song[lines.size() * 2];
        int index = 0;
        for (String line : lines) {
            String[] parts = line.split(" - ");
            String id = String.format("%07d", new Random().nextInt(9999999 - 1000000) + 1000000);
            songs[index++] = new Song<>(id, parts[1], parts[0], parts[2]);
            songs[index++] = new Song<>(id, parts[1], parts[0], parts[2]);
        }
        return songs;
    }

    public static LinkedList<Song<String>> readSongsList(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        LinkedList<Song<String>> songs = new LinkedList<>();
        for (String line : lines) {
            String[] parts = line.split(" - ");
            String id = String.format("%07d", new Random().nextInt(9999999 - 1000000) + 1000000);
            songs.add(new Song<>(id, parts[1], parts[0], parts[2]));
            songs.add(new Song<>(id, parts[1], parts[0], parts[2]));
        }
        return songs;
    }

    public static Song<String> searchSongsByName(Song<String>[] songs, String name) {
        for (Song<String> song : songs) {
            if (song.getSongData2().equalsIgnoreCase(name)) {
                return song;
            }
        }
        return null;
    }

    public static List<Song<String>> searchSongsByYearAndName(LinkedList<Song<String>> songs, String year, String name) {
        List<Song<String>> result = new ArrayList<>();
        for (Song<String> song : songs) {
            if (song.getSongData4().equals(year) && song.getSongData2().equalsIgnoreCase(name)) {
                result.add(song);
            }
        }
        return result;
    }
}
    // Comparators
    class SongNameComparator implements Comparator<Song<String>> {
        @Override
        public int compare(Song<String> song1, Song<String> song2) {
            return song1.getSongData2().compareTo(song2.getSongData2());
        }
    }
    
    class SongYearComparator implements Comparator<Song<String>> {
        @Override
        public int compare(Song<String> song1, Song<String> song2) {
            return song1.getSongData4().compareTo(song2.getSongData4());
        }
    }
    
    


public class Main {
    public static void main(String[] args) throws IOException {
        // Test generic class Song
        Song<String> testSong1 = new Song<>("1000001", "Bohemian Rhapsody", "Queen", "1975");
        Song<Integer> testSong2 = new Song<>(1000002, 2022, 3, 4);
        Song<Float> testSong3 = new Song<>(1000003.0f, 1.5f, 2.5f, 3.5f);

        System.out.println(testSong1);
        testSong1.setSongData1("1000004");
        System.out.println(testSong1.getSongData1());

        // Read songs from file
        String fileName = "songs.txt";
        Song<String>[] songsArray = Song.readSongsArray(fileName);
        LinkedList<Song<String>> songsList = Song.readSongsList(fileName);

        // Display songs
        System.out.println("\nAll songs:");
        Song.displayAllSongs(songsList);

        // Search songs by name
        Song<String> foundSong = Song.searchSongsByName(songsArray, "Radioactive");
        System.out.println("\nFound song (by name): " + foundSong);

        // Search songs by year and name
        List<Song<String>> foundSongs = Song.searchSongsByYearAndName(songsList, "2012", "Radioactive");
        System.out.println("\nFound songs (by year and name):");
        for (Song<String> song : foundSongs) {
            System.out.println(song);
        }
        // Use comparators to sort songs
        Arrays.sort(songsArray, new SongNameComparator());
        System.out.println("\nSorted by name:");
        for (Song<String> song : songsArray) {
            System.out.println(song);
        }

        Collections.sort(songsList, new SongYearComparator());
        System.out.println("\nSorted by year:");
        for (Song<String> song : songsList) {
            System.out.println(song);
    
        }
    }
    }

