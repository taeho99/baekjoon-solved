import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> genreMap = new HashMap<>();
        for(int i=0; i< genres.length; i++) {
            if(genreMap.containsKey(genres[i])) {
                Genre genre = genreMap.get(genres[i]);
                genre.addSong(new Song(i, plays[i]));
            } else {
                Genre genre = new Genre(genres[i]);
                genre.addSong(new Song(i, plays[i]));
                genreMap.put(genres[i], genre);
            }
        }
        List<Genre> genreList = new ArrayList<>(genreMap.values());
        Collections.sort(genreList, (o1, o2) -> o2.playSum - o1.playSum);

        List<Integer> answer = new ArrayList<>();

        for (Genre genre : genreList) {
            for (int i : genre.get2Song()) {
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    class Genre {
        String genre;
        List<Song> songs = new ArrayList<>();
        int playSum;

        public Genre(String genre) {
            this.genre = genre;
        }

        public void addSong(Song song) {
            songs.add(song);
            playSum += song.play;
        }

        public int[] get2Song() {
            if(songs.size() == 1) {
                return new int[] {songs.get(0).num};
            }
            Collections.sort(songs, (o1, o2) -> o2.play - o1.play);
            return new int[] {songs.get(0).num, songs.get(1).num};
        }

    }

    class Song {
        int num; //고유번호
        int play;

        public Song(int num, int play) {
            this.num = num;
            this.play = play;
        }
    }
}