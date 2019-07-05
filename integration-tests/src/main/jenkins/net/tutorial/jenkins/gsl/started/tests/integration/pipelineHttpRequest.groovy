package net.tutorial.jenkins.gsl.started.tests.integration

@Library('getStarted-jsl')
import net.tutorial.jenkins.gsl.started.HttpRequest

parallel(
        action1: {
            node() {
                def httpRequest = new HttpRequest()
                println httpRequest.getResource()
            }
        },
        action2: {
            node() {
                sh 'sleep 4'
                error 'message'
            }
        }
)