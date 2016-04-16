package synahive.restapi.services

import synahive.restapi.models.db.ClassifierEntityTable
import synahive.restapi.models.{ ClassifierEntityUpdate, ClassifierEntity }
import org.mindrot.jbcrypt.BCrypt

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object LanguageClassification extends LanguageClassification

trait LanguageClassification extends ClassifierEntityTable {

  import driver.api._
  
  def getLanguage(text: String): 


}