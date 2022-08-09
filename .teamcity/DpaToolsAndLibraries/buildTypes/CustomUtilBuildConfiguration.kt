package buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.CheckoutMode
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import _Self.vcsRoots.CustomUtilConnector
import jetbrains.buildServer.configs.kotlin.v2019_2.DslContext

object CustomUtilBuildConfiguration : BuildType({
    name = "CleanCity_SwdpaCustomutil"
    description = "Build Dpa Custom Util build configuration"
    val temporaryDir = "temp"


    vcs {
        root(CustomUtilConnector)
        checkoutMode = CheckoutMode.ON_AGENT
        cleanCheckout = true
    }
    steps {
        maven {
            name = "clean install"
            goals = "clean install"
            mavenVersion = bundled_3_6()
            userSettingsSelection = "settings.xml"
            runnerArgs = "-U"
            param("org.jfrog.artifactory.selectedDeployableServer.publishBuildInfo", "true")
            param("org.jfrog.artifactory.selectedDeployableServer.defaultModuleVersionConfiguration", "GLOBAL")
            param("org.jfrog.artifactory.selectedDeployableServer.envVarsExcludePatterns", "*password*,*secret*")
            param("org.jfrog.artifactory.selectedDeployableServer.targetSnapshotRepo", "maven-libs-snapshot")
            param("org.jfrog.artifactory.selectedDeployableServer.deployArtifacts", "true")
            param("org.jfrog.artifactory.selectedDeployableServer.targetRepo", "maven-libs-release")
        }
        script {
            name = "maven version"
            scriptContent = "mvn --version"
            param("org.jfrog.artifactory.selectedDeployableServer.downloadSpecSource", "Job configuration")
            param("org.jfrog.artifactory.selectedDeployableServer.useSpecs", "false")
            param("org.jfrog.artifactory.selectedDeployableServer.uploadSpecSource", "Job configuration")
        }
    }

    failureConditions {
        executionTimeoutMin = 5
        testFailure = false
    }

    triggers {
        vcs {
        }
    }

    requirements {
        exists("env.JDK_11_x64")
    }

})
