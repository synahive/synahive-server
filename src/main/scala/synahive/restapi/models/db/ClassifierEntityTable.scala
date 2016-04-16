package synahive.restapi.models.db

import synahive.restapi.models.ClassifierEntity
import synahive.restapi.utils.DatabaseConfig

trait ClassifierEntityTable extends DatabaseConfig {

  import driver.api._

  class Classifiers(tag: Tag) extends Table[ClassifierEntity](tag, "classifiers") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    def providerName = column[String]("api_name")
    def providerUrl = column[String]("api_url")
    def providerKey = column[String]("api_key")
    def providerType = column[String]("api_type") // Language classifier, Sentiment analyzer etc.

    def * = (id, providerName, providerUrl, providerKey, providerType) <> ((ClassifierEntity.apply _).tupled, ClassifierEntity.unapply)
  }

  protected val classifiers = TableQuery[Classifiers]

}
