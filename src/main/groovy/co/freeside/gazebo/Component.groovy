package co.freeside.gazebo

import groovy.json.JsonSlurper

class Component {

	final File baseDir
	private final metadata

	Component(File baseDir) {
		this.baseDir = baseDir

		def slurper = new JsonSlurper()
		metadata = new File(baseDir, 'component.json').withReader { reader ->
			slurper.parse(reader)
		}
	}

	String getName() {
		metadata.name
	}

	String getVersion() {
		metadata.version
	}

	List<File> getMain() {
		def filenames = metadata.main instanceof String ? [metadata.main] : metadata.main
		filenames.collect {
			new File(baseDir, it).canonicalFile
		}
	}

}
