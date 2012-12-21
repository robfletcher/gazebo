package co.freeside.gazebo

import spock.lang.Specification

@Mixin(ComponentFixtures)
class ComponentSpec extends Specification {

	void 'a component with a simple component.json is parsed'() {

		given:
		def baseDir = new File(componentDir, 'jquery')
		def component = new Component(baseDir)

		expect:
		component.name == 'jquery'
		component.version == '1.8.3'
		component.main.size() == 1
		component.main.first() == new File(baseDir, 'jquery.js')
		component.dependencies == [:]

	}

	void 'a component with multiple main files is parsed'() {

		given:
		def baseDir = new File(componentDir, 'bootstrap')
		def component = new Component(baseDir)

		expect:
		component.main.size() == 2
		component.main.first() == new File(baseDir, 'docs/assets/js/bootstrap.js')
		component.main.last() == new File(baseDir, 'docs/assets/css/bootstrap.css')

	}

	void 'a component with dependencies is parsed'() {

		given:
		def baseDir = new File(componentDir, 'bootstrap')
		def component = new Component(baseDir)

		expect:
		component.dependencies == [jquery: '~1.8.0']

	}

	void 'a component with main files specified in package.json is parsed'() {

		given:
		def baseDir = new File(componentDir, 'backbone')
		def component = new Component(baseDir)

		expect:
		component.main.size() == 1
		component.main.first() == new File(baseDir, 'backbone.js')

	}

}
