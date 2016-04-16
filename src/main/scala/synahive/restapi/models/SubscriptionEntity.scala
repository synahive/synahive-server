package synahive.restapi.models

import org.mindrot.jbcrypt.BCrypt

case class SubscriptionEntity(id: Option[Long] = None, startDate: Date, endDate: Date, ) {
  require(!startDate.isEmpty, "start_date.empty")
  require(!endDate.isEmpty, "end_date.empty")
}

case class SubscriptionEntityUpdate(startDate: Option[Date] = None, endDate: Option[Date] = None) {
  def merge(subscription: SubscriptionEntity): SubscriptionEntity = {
    SubscriptionEntity(subscription.id, startDate , endDate)
  }
}