package com.moviesRest;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Path(value = "rest")
public class MovieController {

    MovieService movieService = new MovieService();


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Welcome to the world of Movies!";
    }

    @GET
    @Path("/movies")
    @Produces(MediaType.APPLICATION_XML)
    public List<Movie> getAllMovies()
    {
        return movieService.getMovieList();
    }

    @GET
    @Path("/movies/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Movie getMovieById(@PathParam("id") Integer id)
    {
        if(id  < 0){
//            return Response.noContent().build();
            return null;
        }
        return movieService.getMovieById(id);
    }

    @POST
    @Path("/movies")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response addMovie( Movie movie ) throws URISyntaxException
    {
        if(movie == null){
            return Response.status(400).entity("Please add Movie details !!").build();
        }
        if(movie.getTitle() == null) {
            return Response.status(400).entity("Please provide the Movie title !!").build();
        }
        movieService.addMovie(movie);
        return Response.status(200).entity("Movie Added !!").build();

    }

    @DELETE
    @Path("/movies/{id}")
    public String deleteMovie(@PathParam("id") int id)
    {
        return movieService.deleteMovieById(id) ?"Successfully Deleted":"record Didn't exist";
    }

    @PUT
    @Path("/movies/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public String updateMovie(@PathParam("id") int id, Movie movie){

        return movieService.updateMovieById(id, movie) ? "Successfully updated":"record Didn't exist";
    }



}
