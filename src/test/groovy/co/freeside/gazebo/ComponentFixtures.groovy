package co.freeside.gazebo

class ComponentFixtures {

	def standardProjectHome = resourceDirectory('/projects/standard')
	def nonStandardProjectHome = resourceDirectory('/projects/nonStandard')
	def customDirProjectHome = resourceDirectory('/projects/customDir')
	def componentDir = new File(standardProjectHome, 'components')

	File resourceDirectory(String name) {
		new File(getClass().getResource(name).toURI())
	}

}
