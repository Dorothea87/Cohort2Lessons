package Week2.Tuesday.TuesdayMVP.Sanctuary2

trait Species {
  def speciesName: String
  def conservationStatus: String
  def numOfYoungRange: (Int, Int)
  def avgLifespanRange: (Int, Int)
}
