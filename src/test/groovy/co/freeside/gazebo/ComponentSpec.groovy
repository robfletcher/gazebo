package co.freeside.gazebo

import spock.lang.Specification

class ComponentSpec extends Specification {

	def componentDir = new File(getClass().getResource('/components').toURI())

	void 'a library with a standard component.json is parsed'() {

		given:
		def baseDir = new File(componentDir, 'jquery')
		def component = new Component(baseDir)

		expect:
		component.name == 'jquery'
		component.version == '1.8.3'
		component.main.size() == 1
		component.main.first() == new File(componentDir, 'jquery/jquery.js')

	}

}
