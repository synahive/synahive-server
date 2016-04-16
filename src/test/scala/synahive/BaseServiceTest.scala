package synahive

import synahive.restapi.http.HttpService
import synahive.restapi.models.{ TokenEntity, UserEntity }
import synahive.restapi.utils.Migration
import org.scalatest._

import akka.event.{ NoLogging, LoggingAdapter }
import akka.http.scaladsl.testkit.ScalatestRouteTest

import scala.concurrent.Await
import scala.concurrent.duration._

trait BaseServiceTest extends WordSpec with Matchers with ScalatestRouteTest with HttpService with Migration {
  protected val log: LoggingAdapter = NoLogging

  import driver.api._

  val testUsers = Seq(
    UserEntity(Some(1), "Synahive", "test"),
    UserEntity(Some(2), "Marius", "test"),
    UserEntity(Some(3), "Gerald", "test")
  )

  val testTokens = Seq(
    TokenEntity(userId = Some(1)),
    TokenEntity(userId = Some(2)),
    TokenEntity(userId = Some(3))
  )

  reloadSchema()
  Await.result(db.run(users ++= testUsers), 10.seconds)
  Await.result(db.run(tokens ++= testTokens), 10.seconds)
}
