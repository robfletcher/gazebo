package co.freeside.gazebo

import spock.lang.Shared
import spock.lang.Specification

@Mixin(ComponentFixtures)
class GazeboSpec extends Specification {

	@Shared def realUserHome = System.getProperty('user.home')
	@Shared def fakeUserHome = resourceDirectory('/home').canonicalPath

	void cleanup() {
		System.setProperty('user.home', realUserHome)
	}

	void 'loads all components in the default directory'() {

		given:
		def gazebo = new Gazebo(standardProjectHome)

		expect:
		gazebo.components.name == ['backbone', 'bootstrap', 'jquery']

	}

	void 'loads all components in a directory specified in .bowerrc'() {

		given:
		def gazebo = new Gazebo(customDirProjectHome)

		expect:
		gazebo.components.size() == 1
		gazebo.components.name == ['jquery']
		gazebo.components.version == ['1.8.3']

	}

	void 'loads all components in a directory specified in ~/.bowerrc'() {

		given:
		System.setProperty('user.home', fakeUserHome)

		and:
		def gazebo = new Gazebo(nonStandardProjectHome)

		expect:
		gazebo.components.size() == 1
		gazebo.components.name == ['jquery']
		gazebo.components.version == ['1.8.3']

	}

	void 'local .bowerrc overrides ~/.bowerrc'() {

		given:
		System.setProperty('user.home', fakeUserHome)

		and:
		def gazebo = new Gazebo(customDirProjectHome)

		expect:
		gazebo.components.size() == 1
		gazebo.components.name == ['jquery']
		gazebo.components.version == ['1.8.3']

	}

}
