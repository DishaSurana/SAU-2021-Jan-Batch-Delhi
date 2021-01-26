package com.moviesRest;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "movieList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieService {

    @XmlElement(name="movie")
    private List<Movie> movieList;

    public MovieService() {
        movieList = new ArrayList<>();
        //default record
        movieList.add(new Movie(1001,"DDLJ",1990,"Yash Raj"));
    }


    public void addMovie(Movie movie){
        movieList.add(movie);
    }

    public Movie getMovieById(int id){
        Movie movie = null;
        for(int i=0; i < movieList.size(); i++){
            if(movieList.get(i).getMovieId() == id){
                movie = movieList.get(i);
                break;
            }
        }
        return movie;
    }

    public boolean deleteMovieById(int id){
        Movie movie = null;
        int i;
        for( i=0; i < movieList.size(); i++){
            if(movieList.get(i).getMovieId() == id){
                movie = movieList.get(i);
                break;
            }
        }
        movieList.remove(i);
        return movie == null ? false:true;
    }

    public boolean updateMovieById(int id, Movie newMovie){
        Movie movie = null;
        int i;
        for( i=0; i < movieList.size(); i++){
            if(movieList.get(i).getMovieId() == id){
                movie = movieList.get(i);
                break;
            }
        }
        if(movie != null){
            movieList.set(i, newMovie);
            return true;
        }
        else
            return false;

    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
