package com.moviesRest;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "movieList")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movies {

    @XmlElement(name="movie")
    private List<Movie> movieList;

    public Movies() {
        movieList = new ArrayList<>();
    }

    public add

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
