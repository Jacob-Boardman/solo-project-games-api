package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.GameServiceImp;

@Path("/game")
public class GameEndpoints {

	@Inject
	private GameServiceImp service;

	@Path("/getAllGames")
	@GET
	@Produces({ "application/json" })
	public String getAllGames() {
		return service.getAllGames();
	}

	@Path("/getGameById/{id}")
	@GET
	@Produces({ "application/json" })
	public String getGameById(@PathParam("id") Long id) {
		return service.getGameById(id);
	}

	@Path("/createGame")
	@POST
	@Produces({ "application/json" })
	public String createGame(String game) {
		return service.createGame(game);
	}

	@Path("/updateGame/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateGame(@PathParam("id") Long id, String game) {
		return service.updateGame(id, game);
	}

	@Path("/deleteGame/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteGame(@PathParam("id") Long id) {
		return service.deleteGame(id);
	}

}
