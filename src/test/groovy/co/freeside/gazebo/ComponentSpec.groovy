package co.freeside.gazebo

import spock.lang.Specification

class ComponentSpec extends Specification {

	def componentDir = new File(getClass().getResource('/components').toURI())

	void 'a library with a simple component.json is parsed'() {

		given:
		def baseDir = new File(componentDir, 'jquery')
		def component = new Component(baseDir)

		expect:
		component.name == 'jquery'
		component.version == '1.8.3'
		component.main.size() == 1
		component.main.first() == new File(componentDir, 'jquery/jquery.js')

	}

	void 'a library with multiple files specified in component.json is parsed'() {

		given:
		def baseDir = new File(componentDir, 'bootstrap')
		def component = new Component(baseDir)

		expect:
		component.name == 'bootstrap'
		component.version == '2.2.2'
		component.main.size() == 2
		component.main.first() == new File(componentDir, 'bootstrap/docs/assets/js/bootstrap.js')
		component.main.last() == new File(componentDir, 'bootstrap/docs/assets/css/bootstrap.css')

	}

}
