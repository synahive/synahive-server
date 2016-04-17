package synahive.restapi.models.db

import synahive.restapi.models.SubscriptionEntity
import synahive.restapi.utils.DatabaseConfig
import java.sql.Timestamp

trait SubscriptionEntityTable extends UserEntityTable with DatabaseConfig {

  import driver.api._

  class Subscriptions(tag: Tag) extends Table[SubscriptionEntity](tag, "subscriptions") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    def userId = column[Option[Long]]("user_id")
    def startDate = column[Timestamp]("start_date")
    def endDate = column[Timestamp]("end_date")

    def userFk = foreignKey("USER_FK", userId, users)(_.id, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Cascade)

    def * = (id,userId, startDate, endDate) <> ((SubscriptionEntity.apply _).tupled, SubscriptionEntity.unapply)
  }

  protected val subscriptions = TableQuery[Subscriptions]

}
