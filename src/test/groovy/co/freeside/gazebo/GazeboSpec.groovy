package co.freeside.gazebo

import spock.lang.Specification

@Mixin(ComponentFixtures)
class GazeboSpec extends Specification {

	void 'loads all components in its component directory'() {

		given:
		def gazebo = new Gazebo(workDir)

		expect:
		gazebo.components.name == ['bootstrap', 'jquery']

	}

}
