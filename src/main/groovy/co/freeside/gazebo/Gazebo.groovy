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
		def config = [:]

		def globalConfigFile = new File(System.getProperty('user.home'), '.bowerrc')
		if (globalConfigFile.isFile()) {
			config += readFileAsJson(globalConfigFile)
		}

		def localConfigFile = new File(baseDir, '.bowerrc')
		if (localConfigFile.isFile()) {
			config += readFileAsJson(localConfigFile)
		}

		config
	}

	private readFileAsJson(File localConfigFile) {
		localConfigFile.withReader { reader ->
			new JsonSlurper().parse(reader)
		}
	}
}
