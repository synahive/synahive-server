package synahive.restapi.http

import akka.http.scaladsl.server.Directives._
import synahive.restapi.http.routes._
import synahive.restapi.utils.CorsSupport

trait HttpService extends UsersServiceRoute with AuthServiceRoute with CorsSupport {

  val routes =
    pathPrefix("v1") {
      corsHandler {
        usersRoute ~
          authRoute
      }
    }

}
