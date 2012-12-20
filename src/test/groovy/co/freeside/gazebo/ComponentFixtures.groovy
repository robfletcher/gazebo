package co.freeside.gazebo

class ComponentFixtures {

	def workDir = new File(getClass().getResource('/root').toURI())
	def componentDir = new File(workDir, 'components')

}
