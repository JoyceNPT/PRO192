/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author ngoth
 */
public class Song {
    private String name;
    private int duration;
    private String composer;

    public Song(String name, int duration, String composer) {
        this.name = name;
        this.duration = duration;
        this.composer = composer;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getComposer() {
        return composer;
    }
    
    
}
