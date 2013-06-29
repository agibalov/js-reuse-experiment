package conf;

import me.loki2302.controllers.ApiController;
import me.loki2302.controllers.HomeController;
import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;

public class Routes implements ApplicationRoutes {
	@Override
	public void init(Router router) {
		router.GET().route("/").with(HomeController.class, "index");
		
		router.GET().route("/api/native/addNumbers").with(ApiController.class, "addNumbersNative");
		router.GET().route("/api/js/addNumbers").with(ApiController.class, "addNumbersJS");
		
		router.GET().route("/assets/.*").with(AssetsController.class, "serve");
	}		
}