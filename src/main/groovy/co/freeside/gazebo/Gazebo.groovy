package co.freeside.gazebo

class Gazebo {

	final File componentsDir

	final Collection<Component> components

	Gazebo(File baseDir) {

		componentsDir = new File(baseDir, 'components')

		components = [] as Set
		componentsDir.eachDir {
			components << new Component(it)
		}

	}

}
