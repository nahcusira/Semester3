/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class Music {

    String name;
    String artist;
    int Rated;

    public Music() {
    }

    public Music(String name, String artist, int Rated) {
        this.name = name;
        this.artist = artist;
        this.Rated = Rated;
    }

    @Override
    public String toString() {
        return name + " | " + artist + " | " + Rated;
    }

}
