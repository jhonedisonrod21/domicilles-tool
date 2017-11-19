package controller;

import static spark.Spark.before;
import static spark.Spark.options;
import static spark.Spark.post;

import java.util.List;

import org.json.JSONObject;

import dao.ManagerDomiciliesTool;
import entityPojos.ClientPlatinum;

public class Controller {
	
	public Controller() {
		ManagerDomiciliesTool.getSessionFactory().getCurrentSession();
		
		options("/*", (request, response) -> {
			String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
			if (accessControlRequestHeaders != null) {
				response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
			}
			String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
			if (accessControlRequestMethod != null) {
				response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
			}
			return "OK";
		});

		before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
		
		post("/Login", (req, res) -> {
			JSONObject jsonObject = new JSONObject(req.body());
			JSONObject response = new JSONObject();
			
			String user=jsonObject.getString("userName");
			String pass=jsonObject.getString("password");
			List<ClientPlatinum> clientsPlatinum = ManagerDomiciliesTool.getElementOfTable("ClientPlatinum");
			for (ClientPlatinum clientPlatinum : clientsPlatinum) {
				if (clientPlatinum.getUserName().equals(user) && clientPlatinum.getPassword().equals(pass)) {
					response.put("loginSuccess", true);
					return response;
				}
			}
			response.put("loginSuccess", false);
			return response;
		});
	}

}
