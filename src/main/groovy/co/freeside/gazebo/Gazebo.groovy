package co.freeside.gazebo

class Gazebo {

	final File componentsDir

	final Collection<Component> components

	Gazebo(File componentsDir) {

		this.componentsDir = componentsDir

		components = [] as Set
		componentsDir.eachDir {
			components << new Component(it)
		}

	}

}
