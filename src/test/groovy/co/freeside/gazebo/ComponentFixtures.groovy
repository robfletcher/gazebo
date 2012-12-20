package co.freeside.gazebo

class ComponentFixtures {

	def standardProjectHome = resourceDirectory('/standard')
	def nonStandardProjectHome = resourceDirectory('/nonStandard')
	def customDirProjectHome = resourceDirectory('/customDir')
	def componentDir = new File(standardProjectHome, 'components')

	File resourceDirectory(String name) {
		new File(getClass().getResource(name).toURI())
	}

}
