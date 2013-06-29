package me.loki2302.controllers;

import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;

@Singleton
public class HomeController {
	public Result index() {
		return Results.html();
	}
}
