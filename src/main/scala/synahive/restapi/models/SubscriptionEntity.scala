package synahive.restapi.models

import java.sql.Timestamp

case class SubscriptionEntity(id: Option[Long] = None,userId: Option[Long], startDate: Timestamp, endDate: Timestamp) {

}

case class SubscriptionEntityUpdate(userId: Option[Long] = None,startDate: Option[Timestamp] = None, endDate: Option[Timestamp] = None) {
  def merge(subscription: SubscriptionEntity): SubscriptionEntity = {
    SubscriptionEntity(subscription.userId,subscription.id, subscription.startDate , subscription.endDate)
  }
}