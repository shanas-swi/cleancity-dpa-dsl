package DpaInstallers.buildTypes

import DpaInstallers.vcsRoots.DpaGitConnector
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

object DpaBuildConfiguration : BuildType({
    name = "DPA - Build Number"
    description = "Generate common build number and identify branch"


    vcs {
        root(DpaInstallers.vcsRoots.DpaGitConnector)

        checkoutMode = CheckoutMode.ON_AGENT
        cleanCheckout = true
    }

    steps {
        script {
            name = "Set Branch Classifier"
            workingDir = "ignite_pi"
            scriptContent = """
                git rev-parse --abbrev-ref HEAD | sed "s/^master//" | sed "s/^release\/.*//" | tr "/.-" "___" | sed "s/..*/\-&/" >>MAVEN_BRANCH_CLASSIFIER_OUTPUT.temp
                echo ##teamcity[setParameter name='env.MAVEN_BRANCH_CLASSIFIER' value='>MAVEN_BRANCH_CLASSIFIER_TC.temp
                tr -d "\n\r" <MAVEN_BRANCH_CLASSIFIER_OUTPUT.temp >>MAVEN_BRANCH_CLASSIFIER_TC.temp
                echo '] >>MAVEN_BRANCH_CLASSIFIER_TC.temp
                tr -d "\n\r" <MAVEN_BRANCH_CLASSIFIER_TC.temp
            """.trimIndent()
            param("org.jfrog.artifactory.selectedDeployableServer.downloadSpecSource", "Job configuration")
            param("org.jfrog.artifactory.selectedDeployableServer.useSpecs", "true")
            param("org.jfrog.artifactory.selectedDeployableServer.uploadSpecSource", "Job configuration")
            param("secure:org.jfrog.artifactory.selectedDeployableServer.deployerPassword", "zxx5629fb5902397aaf775d03cbe80d301b")
            param("org.jfrog.artifactory.selectedDeployableServer.deployerUsername", "jan.cupa")
        }
    }



})
