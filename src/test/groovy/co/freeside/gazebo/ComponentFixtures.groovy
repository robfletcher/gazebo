package co.freeside.gazebo

class ComponentFixtures {

	def standardProjectHome = new File(getClass().getResource('/standard').toURI())
	def customDirProjectHome = new File(getClass().getResource('/customDir').toURI())
	def componentDir = new File(standardProjectHome, 'components')

}
