package com.example.projectceleb.Entity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WikiInfo {

    Celeb celeb;
    Long id = celeb.getId();
    String name = celeb.getFirstName();
    String surname = celeb.getLastName();
    String title = celeb.getMovieTitle();

    //Wiki objects
    Long wikiId;
    String extract;






}


