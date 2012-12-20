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

	private Map loadConfig() {
		def config = [:]
		mergeConfigFile config, new File(System.getProperty('user.home'), '.bowerrc')
		mergeConfigFile config, new File(baseDir, '.bowerrc')

		config
	}

	private void mergeConfigFile(Map config, File configFile) {
		if (configFile.isFile()) {
			config.putAll readFileAsJson(configFile)
		}
	}

	private readFileAsJson(File localConfigFile) {
		localConfigFile.withReader { reader ->
			new JsonSlurper().parse(reader)
		}
	}
}
