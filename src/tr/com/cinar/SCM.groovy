#!/usr/bin/env groovy
// com/cleverbuilder/GlobalVars.groovy
package com.cleverbuilder

class SCM { 
	String URL = "ssh"
	String CredId = "...."

	def steps

    SCM(steps) {
		this.steps = steps
	}
	
    def injectVars() {
        steps.env.PROJECT = steps.sh(script: 'echo $JOB_NAME | cut -d "/" -f 1', returnStdout: true).trim()
        steps.env.REPO = steps.sh(script: 'echo $JOB_NAME | cut -d "/" -f 2', returnStdout: true).trim()
        steps.env.SHORT_SHA = steps.sh(script: 'echo $GIT_COMMIT | cut -c 1-10', returnStdout: true).trim()
        steps.env.TIME = steps.sh(script: 'date +%Y-%m-%d_%H%M%S', returnStdout: true).trim()
        steps.env.TAG = steps.sh(script: 'echo ${BRANCH_NAME}-${SHORT_SHA} | sed "s+/+-+g"', returnStdout: true).trim()
    }	
   
   
}