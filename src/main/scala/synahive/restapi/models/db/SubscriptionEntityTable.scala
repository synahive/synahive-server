package synahive.restapi.models.db

import synahive.restapi.models.SubscriptionEntity
import synahive.restapi.utils.DatabaseConfig

trait SubscriptionEntityTable extends UserEntityTable with DatabaseConfig {

  import driver.api._

  class Subscriptions(tag: Tag) extends Table[SubscriptionEntity](tag, "subscriptions") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    def startDate = column[Date]("start_date")
    def endDate = column[Date]("end_date")

    def userFk = foreignKey("USER_FK", userId, users)(_.id, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Cascade)

    def * = (id, startDate, endDate) <> ((SubscriptionEntity.apply _).tupled, SubscriptionEntity.unapply)
  }

  protected val subscriptions = TableQuery[Subscriptions]

}
