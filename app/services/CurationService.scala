package services

import models._


/**
 * Service to manipulate curation objects.
 */
trait CurationService {
  def insert(curation: CurationObject)

  /**
   * Get curation object.
   */
  def get(id: UUID): Option[CurationObject]

  /**
   * Update status of a curation object.
   */
  def updateStatus(id: UUID, status: String)

  /**
   * Set the curation object as submitted and set the submitted date to current date
   */
  def setSubmitted(id: UUID)

  /**
   * Set the curation object as Published and set the publish date to current date.
   */
  def setPublished(id:UUID)

  /**
   * remove curation object, also delete it from staging area.
   */
  def remove(id: UUID): Unit

  /**
   * Add metadata to curation object, no influence to live object
   */
  def addDatasetUserMetaData(id: UUID, json: String)

  /**
   * Add metadata to curation object, no influence to live object
   */
  def addFileUserMetaData(curationId: UUID, file: Int, json: String)

  /**
   * Update the repository selected
   */
  def updateRepository(curationId: UUID, repository: String)

  /**
   * List curation and published objects a dataset is related to.
   */
  def getCurationObjectByDatasetId(datasetId: UUID): List[CurationObject]
}
