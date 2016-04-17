package synahive.restapi.models

import java.util.Date

case class SubscriptionEntity(id: Option[Long] = None,userId: Option[Long], startDate: Date, endDate: Date) {

}

case class SubscriptionEntityUpdate(userId: Option[Long] = None,startDate: Option[Date] = None, endDate: Option[Date] = None) {
  def merge(subscription: SubscriptionEntity): SubscriptionEntity = {
    SubscriptionEntity(subscription.userId,subscription.id, subscription.startDate , subscription.endDate)
  }
}