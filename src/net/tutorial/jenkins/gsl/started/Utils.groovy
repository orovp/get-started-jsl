package net.tutorial.jenkins.gsl.started

class Utils implements Serializable {

	def script

	Utils(script) {
		this.script = script
	}

	/**
	 * @return GIT config for devteam-tools
	 */
	def gitTools() {
	    return [branch: 'master']
	}

}