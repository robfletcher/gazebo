package co.freeside.gazebo

import spock.lang.Specification

@Mixin(ComponentFixtures)
class GazeboSpec extends Specification {

	void 'loads all components in the default component directory'() {

		given:
		def gazebo = new Gazebo(standardProjectHome)

		expect:
		gazebo.components.name == ['bootstrap', 'jquery']

	}

	void 'loads all components in a component directory specified in .bowerrc'() {

		given:
		def gazebo = new Gazebo(customDirProjectHome)

		expect:
		gazebo.components.size() == 1
		gazebo.components.name == ['jquery']
		gazebo.components.version == ['1.8.3']

	}

}
