/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ngoth
 */
public class SongList {
    private List<Song> listSong;
    public String info;

    public SongList() {
        this.listSong = new ArrayList<>(); // Initialize listSong
        this.info = "";
    }
    
    public void inputData(String name, int duration, String composer){
        Song song = new Song(name, duration, composer);
        listSong.add(song);
        this.info = String.format("Add Song(%s, %d, %s)", name, duration, composer);
    }
    
    public Song getSongMaxDuration(){
        if(listSong.isEmpty())
            return null;
        Song MaxDuration = listSong.stream().max(Comparator.comparingInt(Song::getDuration)).orElse(null);
        if(MaxDuration != null){
            this.info = String.format("Max Duration Song is %s", MaxDuration.getName());
        }
        return MaxDuration;
    }
    
    public List<Song> getTop3Ranking(){
        listSong.sort(Comparator.comparingInt(Song::getDuration).reversed());
        List<Song> Top3 = new ArrayList<>();
        for(int i = 0; i < Math.min(3, listSong.size()); i++){
            Top3.add(listSong.get(i));
        }
        this.info = "Top 3 Ranking include ";
        for(int i = 0; i < Top3.size(); i++){
            if(i != 0)
                this.info += ", ";
            this.info += Top3.get(i).getName();
        }
        return Top3;
    }
    
    public void removeSongMaxDuration(){
        Song SongMaxDuration = getSongMaxDuration();
        if(SongMaxDuration != null){
            listSong.remove(SongMaxDuration);
            this.info = String.format("Remove Song Max Duration");
        }
    }
    
    public void removeAllData(){
        listSong.clear();
        this.info = String.format("*** Remove All Songs");
    }
}
