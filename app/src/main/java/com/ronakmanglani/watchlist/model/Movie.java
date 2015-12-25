package com.ronakmanglani.watchlist.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Movie {

    public String id;
    public String title;
    public String releaseDate;
    public String runtime;
    public String overview;
    public String voteAverage;
    public String voteCount;
    public String backdropImage;
    public String posterImage;
    public ArrayList<String> genre;
    public ArrayList<Video> videos;
    public ArrayList<Credit> cast;
    public ArrayList<Credit> crew;

    public Movie(String id, String title, String releaseDate, String runtime, String overview,
                 String voteAverage, String voteCount, ArrayList<String> genre,
                 String backdropImage, String posterImage, ArrayList<Video> videos,
                 ArrayList<Credit> cast, ArrayList<Credit> crew) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.genre = genre;
        this.backdropImage = backdropImage;
        this.posterImage = posterImage;
        this.videos = videos;
        this.cast = cast;
        this.crew = crew;
    }

    public String getSubtitle() {
        try {
            if (releaseDate.equals("null") && runtime.equals("null")) {
                return "";
            } else if (releaseDate.equals("null")) {
                return runtime + " mins";
            } else if (runtime.equals("null")) {
                return getFormattedDate();
            } else {
                return getFormattedDate() + "\n" + runtime + " mins";
            }
        } catch (Exception ex) {
            return "";
        }
    }
    private String getFormattedDate() {
        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = oldFormat.parse(releaseDate);
        } catch (Exception ex) { }
        SimpleDateFormat newFormat = new SimpleDateFormat("dd MMMM yyyy");
        return newFormat.format(date);
    }
}