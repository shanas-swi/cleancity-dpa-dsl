import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.2"

project {

    buildType(Build)

    subProject(DpaInstallers)
    subProject(DpaToolsAndLibraries)
}

object Build : BuildType({
    name = "Build-Sample"

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }
})


object DpaInstallers : Project({
    name = "DPA Installers"

    vcsRoot(DpaGitConnector)

    buildType(DpaInstallers_Build)
})

object DpaInstallers_Build : BuildType({
    name = "Build-Sample2"

    vcs {
        root(DpaGitConnector)
    }

    triggers {
        vcs {
        }
    }
})

object DpaGitConnector : GitVcsRoot({
    name = "DPA (github) master"
    url = "https://github.com/solarwinds/dpa.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
//    authMethod = uploadedKey {
//        uploadedKey = connectorsSshKeyName()
//        uploadedKey = "TeamCity Access to GitHub"
//    }
    authMethod = password {
        userName = "shanas-swi"
        password = "credentialsJSON:bf61d350-be02-4443-bc11-aea55db613a2"
    }
})


object DpaToolsAndLibraries : Project({
    name = "DPA Tools and Libraries"

    vcsRoot(DpaTestRuntimeGitConnector)

    buildType(DpaToolsAndLibraries_Build)
})

object DpaToolsAndLibraries_Build : BuildType({
    name = "Build-Sample3"

    vcs {
        root(DpaTestRuntimeGitConnector)
    }

    triggers {
        vcs {
        }
    }
})

object DpaTestRuntimeGitConnector : GitVcsRoot({
    name = "DPA Test Runtime (github) master"
    url = "https://github.com/solarwinds/dpa-test-runtime.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
//    authMethod = uploadedKey {
//        uploadedKey = connectorsSshKeyName()
//        uploadedKey = "TeamCity Access to GitHub"
//    }
    authMethod = password {
        userName = "shanas-swi"
        password = "credentialsJSON:bf61d350-be02-4443-bc11-aea55db613a2"
    }
})
