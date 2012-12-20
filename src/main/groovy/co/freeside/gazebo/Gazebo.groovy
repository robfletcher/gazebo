package co.freeside.gazebo

import groovy.json.JsonSlurper

class Gazebo {

	final File baseDir

	final Collection<Component> components

	Gazebo(File baseDir) {

		this.baseDir = baseDir

		def config = loadConfig()

		def componentsDir = new File(baseDir, config.directory ?: 'components')

		components = [] as Set
		componentsDir.eachDir {
			components << new Component(it)
		}

	}

	private loadConfig() {
		def configFile = new File(baseDir, '.bowerrc')
		if (configFile.isFile()) {
			configFile.withReader { reader ->
				new JsonSlurper().parse(reader)
			}
		} else {
			[:]
		}
	}
}
