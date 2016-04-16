package synahive.restapi.models

import org.mindrot.jbcrypt.BCrypt

case class ClassifierEntity(id: Option[Long] = None, providerName: String, providerUrl: String, providerKey: String, providerType: String) {
  require(!providerName.isEmpty, "api_name.empty")
  require(!providerUrl.isEmpty, "api_url.empty")
  require(!providerKey.isEmpty, "api_key.empty")
  require(!providerType.isEmpty, "api_type.empty")
  
}

case class ClassifierEntityUpdate(providerName: Option[String] = None, providerUrl: Option[String] = None, providerKey: Option[String] = None, providerType: Option[String] = None) {
  def merge(classifier: ClassifierEntity): ClassifierEntity = {
    ClassifierEntity(classifier.id, classifier.providerName, classifier.providerUrl, classifier.providerKey, classifier.providerType)
  }
}